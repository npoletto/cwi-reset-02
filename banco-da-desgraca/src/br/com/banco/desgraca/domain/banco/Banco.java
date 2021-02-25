package br.com.banco.desgraca.domain.banco;

import br.com.banco.desgraca.domain.banco.enums.InstituicaoBancaria;
import br.com.banco.desgraca.domain.conta.enums.TipoContaBancaria;
import br.com.banco.desgraca.domain.conta.ContaBancaria;
import br.com.banco.desgraca.domain.conta.decorators.ContaCorrente;
import br.com.banco.desgraca.domain.conta.decorators.ContaDigital;
import br.com.banco.desgraca.domain.conta.decorators.ContaPoupanca;
import br.com.banco.desgraca.exception.CriacaoDeContaNaoPermitidaException;

import java.util.HashMap;

public class Banco {
    private InstituicaoBancaria instituicaoBancaria;
    private HashMap<Integer, ContaBancaria> contas = new HashMap<>();

    public Banco(InstituicaoBancaria instituicaoBancaria) {
        this.instituicaoBancaria = instituicaoBancaria;
    }

    public ContaPoupanca abreContaPoupanca(int numeroConta) {
        validaNumeroConta(numeroConta);
        ContaPoupanca conta = new ContaPoupanca( numeroConta, instituicaoBancaria);
        contas.put(numeroConta, conta);
        return conta;
    }

    public ContaDigital abreContaDigital(int numeroConta) {
        validaNumeroConta(numeroConta);
        ContaDigital conta = new ContaDigital( numeroConta, instituicaoBancaria);
        contas.put(numeroConta, conta);
        return conta;
    }

    public ContaCorrente abreContaCorrente(int numeroConta) {
        validaNumeroConta(numeroConta);
        ContaCorrente conta = new ContaCorrente( numeroConta, instituicaoBancaria);
        contas.put(numeroConta, conta);
        return conta;
    }

    private void validaNumeroConta(int numeroConta) {
        if(numeroConta<=0) {
            throw new CriacaoDeContaNaoPermitidaException("Número de conta: " + numeroConta + " inválido.");
        }
        if(contas.containsKey(numeroConta)) {
            throw new CriacaoDeContaNaoPermitidaException("Número de conta: " + numeroConta + " já existente.");
        }
    }

}
