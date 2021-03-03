package br.com.cwi.resetflix.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.cwi.resetflix.domain.ContadorIdsEntidades;
import br.com.cwi.resetflix.exception.NotFoundException;
import org.springframework.stereotype.Repository;

import br.com.cwi.resetflix.entity.AtorEntity;

@Repository
public class AtoresRepository {

    static Map<Long, AtorEntity> atores = new HashMap();

    public List<AtorEntity> getAtores(){
        return new ArrayList<>(atores.values());
    }

    public Long criarAtor(final AtorEntity atorSalvar) {
        if(atorSalvar.getId() == null){
            atorSalvar.setId(ContadorIdsEntidades.getNextIdPessoa());
        }
        atores.put(atorSalvar.getId(), atorSalvar);
        return atorSalvar.getId();
    }

    public AtorEntity acharAtorPorId(final Long id) {
        AtorEntity ator = atores.getOrDefault(id, null);
        if(ator==null) throw new NotFoundException("Ator não encontrado.");
        return ator;
    }
}
