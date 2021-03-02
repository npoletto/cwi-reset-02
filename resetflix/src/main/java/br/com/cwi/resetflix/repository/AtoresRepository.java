package br.com.cwi.resetflix.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.cwi.resetflix.entity.AtorEntity;

@Repository
public class AtoresRepository {

    static HashMap<Long, AtorEntity> atores = new HashMap<>();
    static Long contadorIds = 1L;

    public List<AtorEntity> getAtores(){
        return new ArrayList<>(atores.values());
    }

    public Long criarAtor(final AtorEntity atorSalvar) {
        if(atorSalvar.getId() == null){
            atorSalvar.setId(contadorIds);
            contadorIds++;
        }
        atores.put(atorSalvar.getId(), atorSalvar);
        return atorSalvar.getId();
    }

    public AtorEntity acharAtorPorId(final Long id) {
        return atores.getOrDefault(id, null);
    }
}
