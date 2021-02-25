package br.com.banco.desgraca.domain.banco.enums;

import br.com.banco.desgraca.domain.conta.enums.TipoContaBancaria;

public enum InstituicaoBancaria {

    BANCO_DO_BRASIL ("Banco do Brasil", true, false),
    BRADESCO ("Bradesco",   true, false),
    CAIXA ("Caixa Econômica Federal", true, false),
    ITAU ("Itaú", true, true),
    NUBANK("Nubank", false, true);

    private String descricao;
    private boolean isPermitidoContaPoupanca;
    private boolean isPermitidoContaDigital;


    InstituicaoBancaria(String descricao, boolean isPermitidoContaPoupanca, boolean isPermitidoContaDigital) {
        this.descricao = descricao;
        this.isPermitidoContaDigital = isPermitidoContaDigital;
        this.isPermitidoContaPoupanca = isPermitidoContaPoupanca;
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean isPermitido(TipoContaBancaria tipoContaBancaria) {
        if(tipoContaBancaria == TipoContaBancaria.CONTA_DIGITAL) return isPermitidoContaDigital;
        else if(tipoContaBancaria == TipoContaBancaria.CONTA_POUPANCA) return isPermitidoContaPoupanca;
        else return true;
    }


}
