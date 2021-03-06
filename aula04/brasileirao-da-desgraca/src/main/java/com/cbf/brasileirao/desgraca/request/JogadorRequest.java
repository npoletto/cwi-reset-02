package com.cbf.brasileirao.desgraca.request;

import com.cbf.brasileirao.desgraca.enums.Posicao;
import com.cbf.brasileirao.desgraca.enums.TipoJogador;

public class JogadorRequest {

    private Integer id;
    private String nome;
    private Posicao posicao;
    private TipoJogador tipo;

    public Integer getId() {
        return id;
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

    public Posicao getPosicao() {
        return posicao;
    }

    public void setPosicao(Posicao posicao) {
        this.posicao = posicao;
    }

    public TipoJogador getTipo() {
        return tipo;
    }

    public void setTipo(TipoJogador tipo) {
        this.tipo = tipo;
    }
}
