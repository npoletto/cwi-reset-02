package br.com.cwi.resetflix.entity;

import java.util.List;

import br.com.cwi.resetflix.domain.Genero;

public class FilmeEntity extends ObraEntity {
    private Long idDiretor;

    public FilmeEntity(final Long id, final String nome, final Genero genero, final Long idDiretor, final List<Long> idsAtores) {
        super(id, nome, genero, idsAtores);
        this.idDiretor = idDiretor;
    }

}
