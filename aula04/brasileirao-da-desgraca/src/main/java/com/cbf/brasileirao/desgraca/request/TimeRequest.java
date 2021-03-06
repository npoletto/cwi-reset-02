package com.cbf.brasileirao.desgraca.request;

import java.time.LocalDate;
import java.util.List;

public class TimeRequest {

    private String nome;
    private LocalDate dataFundacao;
    private double caixa;
    private List<CampeonatoRequest> campeonatos;
    private List<JogadorRequest> jogadores;
    private TecnicoRequest tecnico;

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

    public List<CampeonatoRequest> getCampeonatos() {
        return campeonatos;
    }

    public void setCampeonatos(List<CampeonatoRequest> campeonatos) {
        this.campeonatos = campeonatos;
    }

    public List<JogadorRequest> getJogadores() {
        return jogadores;
    }

    public void setJogadores(List<JogadorRequest> jogadores) {
        this.jogadores = jogadores;
    }

    public TecnicoRequest getTecnico() {
        return tecnico;
    }

    public void setTecnico(TecnicoRequest tecnico) {
        this.tecnico = tecnico;
    }
}
