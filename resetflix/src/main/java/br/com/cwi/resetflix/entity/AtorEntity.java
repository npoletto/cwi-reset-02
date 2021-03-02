package br.com.cwi.resetflix.entity;

import java.util.List;

public class AtorEntity extends ProfissionalEntity {

    public AtorEntity(final String nome, final List<Long> idsFilmes) {
        super(nome, idsFilmes);
    }

    public AtorEntity(final Long id, final String nome, final List<Long> idsFilmes) {
        super(id, nome, idsFilmes);
    }

}
