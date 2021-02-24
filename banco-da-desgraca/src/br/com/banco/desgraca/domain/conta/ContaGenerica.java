package br.com.banco.desgraca.domain.conta;

import br.com.banco.desgraca.domain.InstituicaoBancaria;
import br.com.banco.desgraca.exception.SaldoInsuficienteException;
import br.com.banco.desgraca.exception.SaqueNaoPermitidoException;
import br.com.banco.desgraca.exception.ValorInvalidoException;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.HashMap;

public abstract class ContaGenerica implements ContaBancaria {
    private double saldo;
    private int numeroConta;
    private InstituicaoBancaria instituicaoBancaria;
    private TipoContaBancaria tipoContaBancaria;
    private RegrasContas regrasContas;

    public ContaGenerica(double saldo, int numeroConta, InstituicaoBancaria instituicaoBancaria, TipoContaBancaria tipoContaBancaria) {
        this.saldo = saldo;
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
        return saldo;
    }

    @Override
    public void depositar(Double valor) {
        validaValorRecebido(valor);
        saldo +=valor;
    }

    @Override
    public void sacar(Double valor) {
        validaValorRecebido(valor);

        if( valor < regrasContas.saqueMinimo) {
            throw new SaqueNaoPermitidoException("O valor mínimo para saques é de: " + DecimalFormat.getCurrencyInstance().format(regrasContas.saqueMinimo));
        }

        if( regrasContas.saqueMultiploDoValor > 0 && valor % regrasContas.saqueMultiploDoValor!=0) {
            throw new SaqueNaoPermitidoException("O valor precisa ser múltiplo de: " + DecimalFormat.getCurrencyInstance().format(regrasContas.saqueMultiploDoValor));
        }

        if( saldo - ( valor * ( 1 + regrasContas.taxaSaque) ) < 0) {
            throw new SaldoInsuficienteException("Não há saldo suficiente na conta.");
        } else {
            saldo -= valor;
            saldo -= valor * (1 + regrasContas.taxaSaque);
        }

    }

    @Override
    public void transferir(Double valor, ContaBancaria contaDestino) {
        validaValorRecebido(valor);

        boolean mesmaInstituicaoBancaria = (instituicaoBancaria == contaDestino.getInstituicaoBancaria());
        double taxaTransferencia = mesmaInstituicaoBancaria ? regrasContas.taxaTransferenciaMesmaInstituicao : regrasContas.taxaTransferenciaOutraInstituicao;

        if( saldo - ( valor * ( 1 + taxaTransferencia) ) < 0) {
            throw new SaldoInsuficienteException("Não há saldo suficiente na conta.");
        }

        saldo -=valor;
        saldo -=valor*(1 + taxaTransferencia);

    }

    @Override
    public void exibirExtrato(LocalDate inicio, LocalDate fim) {

    }

    private void validaValorRecebido(Double valor) {
        if( valor < 0 || valor.isNaN()) {
            throw new ValorInvalidoException("Valor solicitado inválido. (" + valor +")" );
        }

    }
}
