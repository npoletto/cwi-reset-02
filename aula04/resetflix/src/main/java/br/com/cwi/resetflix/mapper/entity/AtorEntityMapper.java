package br.com.cwi.resetflix.mapper.entity;

import br.com.cwi.resetflix.entity.AtorEntity;
import br.com.cwi.resetflix.request.CriarAtorRequest;

public class AtorEntityMapper {

    public AtorEntity mapear(final CriarAtorRequest request) {
        return new AtorEntity(request.getNome(), request.getIdFilmes());
    }
}
