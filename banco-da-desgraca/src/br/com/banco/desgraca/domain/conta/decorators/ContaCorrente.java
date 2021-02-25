package br.com.banco.desgraca.domain.conta.decorators;

import br.com.banco.desgraca.domain.banco.enums.InstituicaoBancaria;
import br.com.banco.desgraca.domain.conta.ContaBancaria;
import br.com.banco.desgraca.domain.conta.ContaGenerica;
import br.com.banco.desgraca.domain.conta.RegrasContas;
import br.com.banco.desgraca.domain.conta.enums.TipoContaBancaria;

public class ContaCorrente extends ContaGenerica implements ContaBancaria {


    public ContaCorrente(int numeroConta, InstituicaoBancaria instituicaoBancaria) {
        super(numeroConta,instituicaoBancaria,TipoContaBancaria.CONTA_CORRENTE);
        RegrasContas regraContas = new RegrasContas(0,0,0.01,0,5);
        setRegrasContas(regraContas);
    }


}
