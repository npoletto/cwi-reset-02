package br.com.banco.desgraca.domain.conta;

import br.com.banco.desgraca.domain.InstituicaoBancaria;
import br.com.banco.desgraca.domain.conta.decorators.ContaCorrente;
import br.com.banco.desgraca.domain.conta.decorators.ContaDigital;
import br.com.banco.desgraca.domain.conta.decorators.ContaPoupanca;

public class Banco {
    private InstituicaoBancaria instituicaoBancaria;

    public Banco(InstituicaoBancaria instituicaoBancaria) {
        this.instituicaoBancaria = instituicaoBancaria;
    }

    public ContaBancaria abreContaPoupanca(int numeroConta) {
        return new ContaPoupanca(0, numeroConta, instituicaoBancaria,TipoContaBancaria.CONTA_POUPANCA);
    }

    public ContaDigital abreContaDigital(int numeroConta) {
        return new ContaDigital(0, numeroConta, instituicaoBancaria,TipoContaBancaria.CONTA_DIGITAL);
    }

    public ContaCorrente abreContaCorrente(int numeroConta) {
        return new ContaCorrente(0, numeroConta, instituicaoBancaria, TipoContaBancaria.CONTA_CORRENTE);
    }

}
