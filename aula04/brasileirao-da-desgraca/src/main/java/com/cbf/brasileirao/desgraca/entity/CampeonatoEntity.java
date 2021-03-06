package com.cbf.brasileirao.desgraca.entity;

import com.cbf.brasileirao.desgraca.enums.NivelCampeonato;
import com.cbf.brasileirao.desgraca.enums.TipoCampeonato;

public class CampeonatoEntity {

    private Integer id;
    private String nome;
    private TipoCampeonato tipo;
    private NivelCampeonato nivel;

    public CampeonatoEntity(Integer id, String nome, TipoCampeonato tipo, NivelCampeonato nivel) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.nivel = nivel;
    }

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
