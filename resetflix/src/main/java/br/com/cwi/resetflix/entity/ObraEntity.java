package br.com.cwi.resetflix.entity;

import br.com.cwi.resetflix.domain.Genero;

import java.util.List;

public class ObraEntity {

    private Long id;
    private String nome;
    private Genero genero;
    private List<Long> idsAtores;

    public ObraEntity(final Long id, final String nome, final Genero genero, final List<Long> idsAtores) {
        this.id = id;
        this.nome = nome;
        this.genero = genero;
        this.idsAtores = idsAtores;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(final String nome) {
        this.nome = nome;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(final Genero genero) {
        this.genero = genero;
    }

    public List<Long> getIdsAtores() {
        return idsAtores;
    }

    public void setIdsAtores(final List<Long> idsAtores) {
        this.idsAtores = idsAtores;
    }

}
