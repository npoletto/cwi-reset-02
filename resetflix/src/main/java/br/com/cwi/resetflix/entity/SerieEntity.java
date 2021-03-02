package br.com.cwi.resetflix.entity;

import br.com.cwi.resetflix.domain.Genero;

import java.util.List;

public class SerieEntity extends ObraEntity {
    private int temporadas;
    private int episodios;

    public SerieEntity(Long id, String nome, Genero genero, List<Long> idsAtores, int temporadas, int episodios) {
        super(id, nome, genero, idsAtores);
        this.temporadas = temporadas;
        this.episodios = episodios;
    }


}
