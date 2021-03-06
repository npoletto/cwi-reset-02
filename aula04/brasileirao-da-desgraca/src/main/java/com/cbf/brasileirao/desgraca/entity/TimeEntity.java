package com.cbf.brasileirao.desgraca.entity;

import java.time.LocalDate;
import java.util.List;

public class TimeEntity {

    private Integer id;
    private String nome;
    private LocalDate dataFundacao;
    private double caixa;
    private String nomeTecnico;
    private List<JogadorEntity> jogadores;
    private List<CampeonatoEntity> campeonatos;

    public TimeEntity(String nome, LocalDate dataFundacao, double caixa, String nomeTecnico, List<JogadorEntity> jogadores, List<CampeonatoEntity> campeonatos) {
        this.nome = nome;
        this.dataFundacao = dataFundacao;
        this.nomeTecnico = nomeTecnico;
        this.jogadores = jogadores;
        this.campeonatos = campeonatos;
        this.caixa = caixa;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataFundacao() {
        return dataFundacao;
    }

    public void setDataFundacao(LocalDate dataFundacao) {
        this.dataFundacao = dataFundacao;
    }

    public double getCaixa() {
        return caixa;
    }

    public void setCaixa(double caixa) {
        this.caixa = caixa;
    }

    public String getNomeTecnico() {
        return nomeTecnico;
    }

    public void setNomeTecnico(String nomeTecnico) {
        this.nomeTecnico = nomeTecnico;
    }

    public List<JogadorEntity> getJogadores() {
        return jogadores;
    }

    public void setJogadores(List<JogadorEntity> jogadores) {
        this.jogadores = jogadores;
    }

    public List<CampeonatoEntity> getCampeonatos() {
        return campeonatos;
    }

    public void setCampeonatos(List<CampeonatoEntity> campeonatos) {
        this.campeonatos = campeonatos;
    }
}
