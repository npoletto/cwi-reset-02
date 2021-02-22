package br.com.banco.desgraca;

import br.com.banco.desgraca.domain.conta.RegrasContas;
import br.com.banco.desgraca.domain.conta.TipoContaBancaria;

import java.util.HashMap;

public class BancoDaDesgraca {

    public static void main(String[] args) {
        /*
            Inicializando regras de contas bancárias.

         */

        HashMap<TipoContaBancaria, RegrasContas> regras = new HashMap<>();
        regras.put(TipoContaBancaria.CONTA_CORRENTE, new RegrasContas(0,0, 0.01,0, 5));


    }
}
