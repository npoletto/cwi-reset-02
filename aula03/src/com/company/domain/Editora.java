package com.company.domain;

public class Editora {
    private String nome;
    private String localizacao;


    public Editora(String nome, String localizacao) {
        this.nome = nome;
        validaNome(nome);
        this.localizacao = localizacao;
    }

    public void validaNome(String nome) {
        if(nome.equalsIgnoreCase("DC Comics")) {
            throw new RuntimeException("Acho que temos um instrutor fã da Marvel.");
        }
    }


    public String getNome() {
        return nome;
    }

    public String getLocalizacao() {
        return localizacao;
    }
}
