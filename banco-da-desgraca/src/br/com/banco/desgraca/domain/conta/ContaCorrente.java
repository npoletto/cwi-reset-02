package br.com.banco.desgraca.domain.conta;

import br.com.banco.desgraca.domain.InstituicaoBancaria;
import br.com.banco.desgraca.exception.SaldoInsuficienteException;

import java.time.LocalDate;

public class ContaCorrente extends Conta implements ContaBancaria {
private InstituicaoBancaria instituicaoBancaria;

    public ContaCorrente(double saldo, int numeroConta, InstituicaoBancaria instituicaoBancaria, TipoContaBancaria tipoContaBancaria) {
        super(saldo,numeroConta,instituicaoBancaria,tipoContaBancaria);
    }

    @Override
    public InstituicaoBancaria getInstituicaoBancaria() {
        return instituicaoBancaria;
    }

    @Override
    public Double consultarSaldo() {
        return getSaldo();
    }

    @Override
    public void depositar(Double valor) {
        setSaldo(getSaldo() + valor);
    }

    @Override
    public void sacar(Double valor) {
        if(getSaldo() -valor < 0) throw new SaldoInsuficienteException("Saldo insuficiente.");
        setSaldo(getSaldo() - valor);
    }

    @Override
    public void transferir(Double valor, ContaBancaria contaDestino) {
        if(getSaldo() -valor < 0) throw new SaldoInsuficienteException("Saldo insuficiente.");
        setSaldo(getSaldo() - valor);
        contaDestino.depositar(valor);
    }

    @Override
    public void exibirExtrato(LocalDate inicio, LocalDate fim) {
        System.out.println("Saldo: "+getSaldo());
    }
}
