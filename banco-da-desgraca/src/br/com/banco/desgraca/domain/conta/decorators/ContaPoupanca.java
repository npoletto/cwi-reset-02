package br.com.banco.desgraca.domain.conta.decorators;

import br.com.banco.desgraca.domain.banco.enums.InstituicaoBancaria;
import br.com.banco.desgraca.domain.conta.ContaBancaria;
import br.com.banco.desgraca.domain.conta.ContaGenerica;
import br.com.banco.desgraca.domain.conta.RegrasContas;
import br.com.banco.desgraca.domain.conta.enums.TipoContaBancaria;


public class ContaPoupanca extends ContaGenerica implements ContaBancaria {

    public ContaPoupanca(int numeroConta, InstituicaoBancaria instituicaoBancaria, TipoContaBancaria tipoContaBancaria) {
        super(numeroConta, instituicaoBancaria, tipoContaBancaria);
        RegrasContas regraContas = new RegrasContas(0.02,0.005,0.01,50,0);
        setRegrasContas(regraContas);
    }
}
