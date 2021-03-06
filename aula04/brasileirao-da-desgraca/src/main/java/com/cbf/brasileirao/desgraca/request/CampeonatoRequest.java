package com.cbf.brasileirao.desgraca.request;

import com.cbf.brasileirao.desgraca.enums.NivelCampeonato;
import com.cbf.brasileirao.desgraca.enums.TipoCampeonato;

public class CampeonatoRequest {

    private Integer id;
    private String nome;
    private TipoCampeonato tipo;
    private NivelCampeonato nivel;

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

    public TipoCampeonato getTipo() {
        return tipo;
    }

    public void setTipo(TipoCampeonato tipo) {
        this.tipo = tipo;
    }

    public NivelCampeonato getNivel() {
        return nivel;
    }

    public void setNivel(NivelCampeonato nivel) {
        this.nivel = nivel;
    }
}
