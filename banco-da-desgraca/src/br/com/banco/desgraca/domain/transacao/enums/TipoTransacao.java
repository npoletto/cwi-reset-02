package br.com.banco.desgraca.domain.transacao.enums;

public enum TipoTransacao {
    DEPOSITO ("Depósito"),
    TRANSFERENCIA ("Transferência"),
    SAQUE("Saque"),
    TAXA("Taxa Bancária");

    private String descricao;

    TipoTransacao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}


