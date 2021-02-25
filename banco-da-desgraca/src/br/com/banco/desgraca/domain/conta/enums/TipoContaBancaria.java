package br.com.banco.desgraca.domain.conta.enums;

public enum TipoContaBancaria {
    CONTA_CORRENTE("Conta Corrente"),
    CONTA_DIGITAL("Conta Digital"),
    CONTA_POUPANCA("Conta Poupança");

    private String descricao;

    TipoContaBancaria(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
