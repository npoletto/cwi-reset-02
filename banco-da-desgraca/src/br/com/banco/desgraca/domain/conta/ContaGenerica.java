package br.com.banco.desgraca.domain.conta;

import br.com.banco.desgraca.Data;
import br.com.banco.desgraca.domain.banco.enums.InstituicaoBancaria;
import br.com.banco.desgraca.domain.transacao.enums.TipoTransacao;
import br.com.banco.desgraca.domain.transacao.Transacao;
import br.com.banco.desgraca.domain.conta.enums.TipoContaBancaria;
import br.com.banco.desgraca.exception.CriacaoDeContaNaoPermitidaException;
import br.com.banco.desgraca.exception.SaldoInsuficienteException;
import br.com.banco.desgraca.exception.SaqueNaoPermitidoException;
import br.com.banco.desgraca.exception.ValorInvalidoException;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;


public abstract class ContaGenerica implements ContaBancaria {
    private int numeroConta;
    private InstituicaoBancaria instituicaoBancaria;
    private TipoContaBancaria tipoContaBancaria;
    private RegrasContas regrasContas;

    private ArrayList<Transacao> transacoes = new ArrayList<>();

    public ContaGenerica(int numeroConta, InstituicaoBancaria instituicaoBancaria, TipoContaBancaria tipoContaBancaria) {
        if( !instituicaoBancaria.isPermitido(tipoContaBancaria) ) {
            throw new CriacaoDeContaNaoPermitidaException("Banco "+instituicaoBancaria.getDescricao() + " não aceita abertura de contas do tipo "+tipoContaBancaria);
        }
        this.numeroConta = numeroConta;
        this.instituicaoBancaria = instituicaoBancaria;
        this.tipoContaBancaria = tipoContaBancaria;

    }

    @Override
    public String toString() {
        return tipoContaBancaria.getDescricao() + " " + instituicaoBancaria.getDescricao() + " Nº: " + numeroConta;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public InstituicaoBancaria getInstituicaoBancaria() {
        return instituicaoBancaria;
    }

    public TipoContaBancaria getTipoContaBancaria() {
        return tipoContaBancaria;
    }

    public void setRegrasContas(RegrasContas regrasContas) {
        this.regrasContas = regrasContas;
    }

    @Override
    public Double consultarSaldo() {
        double saldo = 0.0;
        for (Transacao transacao : transacoes) {
            saldo+=transacao.getValor();
        }
        //Forçar o arredondamento para 2 casas decimais para evitar problemas com o uso de Double.
        return new BigDecimal(saldo).setScale(2,RoundingMode.HALF_DOWN).doubleValue();
    }

    @Override
    public void depositar(Double valor) {
        validaValorRecebido(valor);
        LocalDate data = Data.getDataTransacao();
        Transacao transacao = new Transacao(data, TipoTransacao.DEPOSITO, valor);
        transacoes.add(transacao);
        System.out.println(data + " - Depositando "+ DecimalFormat.getCurrencyInstance().format(valor) + " na " + toString() + ".");
    }

    @Override
    public void sacar(Double valor) {
        validaValorRecebido(valor);
        double saldo = consultarSaldo();

        if( valor < regrasContas.getSaqueMinimo()) {
            throw new SaqueNaoPermitidoException("O valor mínimo para saques é de: " + DecimalFormat.getCurrencyInstance().format(regrasContas.getSaqueMinimo()));
        }

        if( regrasContas.getSaqueMultiploDoValor() > 0 && valor % regrasContas.getSaqueMultiploDoValor() != 0) {
            throw new SaqueNaoPermitidoException("O valor precisa ser múltiplo de: " + DecimalFormat.getCurrencyInstance().format(regrasContas.getSaqueMultiploDoValor()));
        }

        if( saldo - ( valor * ( 1 + regrasContas.getTaxaSaque()) ) < 0) {
            throw new SaldoInsuficienteException("Não há saldo suficiente na conta.");
        } else {
            LocalDate data = Data.getDataTransacao();
            Transacao transacaoSaque = new Transacao(data,TipoTransacao.SAQUE,-valor);
            transacoes.add(transacaoSaque);
            System.out.println(data + " - Sacando "+ DecimalFormat.getCurrencyInstance().format(valor) + " na " + toString() + ".");

            if(regrasContas.getTaxaSaque() > 0) {
                cobraTaxa(regrasContas.getTaxaSaque(), valor, data);
            }
        }

    }

    @Override
    public void transferir(Double valor, ContaBancaria contaDestino) {
        validaValorRecebido(valor);
        double saldo = consultarSaldo();

        boolean mesmaInstituicaoBancaria = (instituicaoBancaria == contaDestino.getInstituicaoBancaria());
        double taxaTransferencia = mesmaInstituicaoBancaria ? regrasContas.getTaxaTransferenciaMesmaInstituicao() : regrasContas.getTaxaTransferenciaOutraInstituicao();
        if( saldo - ( valor * ( 1 + taxaTransferencia) ) < 0) {
            throw new SaldoInsuficienteException("Não há saldo suficiente na conta.");
        }
        LocalDate data = Data.getDataTransacao();

        Transacao transacaoTransferencia = new Transacao(data, TipoTransacao.TRANSFERENCIA, -valor);
        transacoes.add(transacaoTransferencia);
        System.out.println(data + " - Transferindo "+ DecimalFormat.getCurrencyInstance().format(valor) + " na " + toString() + ", para " + contaDestino.toString() );
        contaDestino.depositar(valor);

        if(taxaTransferencia>0) {
            cobraTaxa(taxaTransferencia, valor, data);
        }
    }

    @Override
    public void exibirExtrato(LocalDate inicio, LocalDate fim) {
        System.out.println("\n----- EXTRATO " + toString());
        for (Transacao transacao : transacoes) {
            if(     transacao.getDate().isEqual(inicio) ||
                    transacao.getDate().isEqual(fim) ||
                    (transacao.getDate().isAfter(inicio) && transacao.getDate().isBefore(fim))
            ) {
                System.out.println(transacao);
            }
        }
        System.out.println("\nSALDO: " + DecimalFormat.getCurrencyInstance().format(consultarSaldo()));
        System.out.println("-----");
    }

    private void validaValorRecebido(Double valor) {
        if( valor == null) {
            throw new ValorInvalidoException("Valor não pode ser nulo." );
        }
        if( valor < 0 || valor.isNaN()) {
            throw new ValorInvalidoException("Valor inválido. (" + valor +")" );
        }
    }

    private void cobraTaxa(Double taxa, Double valor, LocalDate data) {
        BigDecimal bdTaxa = new BigDecimal(taxa).setScale(4, RoundingMode.DOWN);
        BigDecimal bdvalor = new BigDecimal(valor).setScale(2, RoundingMode.DOWN);
        BigDecimal bdDesconto = bdTaxa.multiply(bdvalor).setScale(2, RoundingMode.DOWN);

        Transacao transacaoTaxa = new Transacao(data, TipoTransacao.TAXA, -bdDesconto.doubleValue());
        transacoes.add(transacaoTaxa);
        System.out.println(data + " - Taxa bancária: "+ DecimalFormat.getCurrencyInstance().format(bdDesconto.doubleValue()) + " na " + toString() + ".");
    }
}
