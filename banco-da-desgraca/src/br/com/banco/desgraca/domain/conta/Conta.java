package br.com.banco.desgraca.domain.conta;

import br.com.banco.desgraca.domain.InstituicaoBancaria;

public abstract class Conta {
    private double saldo;
    private int numeroConta;
    private InstituicaoBancaria instituicaoBancaria;
    private TipoContaBancaria tipoContaBancaria;

    public Conta(double saldo, int numeroConta, InstituicaoBancaria instituicaoBancaria, TipoContaBancaria tipoContaBancaria) {
        this.saldo = saldo;
        this.numeroConta = numeroConta;
        this.instituicaoBancaria = instituicaoBancaria;
        this.tipoContaBancaria = tipoContaBancaria;
    }

    @Override
    public String toString() {
        return tipoContaBancaria.getDescricao() + " " + instituicaoBancaria.getDescricao() + " Nº: " + numeroConta;
    }

    public double getSaldo() {
        return saldo;
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

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
