package br.com.cwi.resetflix.repository;

import br.com.cwi.resetflix.domain.ContadorIdsEntidades;
import br.com.cwi.resetflix.entity.DiretorEntity;
import br.com.cwi.resetflix.exception.NotFoundException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class DiretoresRepository {

    static Map<Long, DiretorEntity> diretores = new HashMap();

    public List<DiretorEntity> getDiretores(){
        return new ArrayList<>(diretores.values());
    }

    public Long criarDiretor(final DiretorEntity diretorSalvar) {
        if(diretorSalvar.getId() == null){
            diretorSalvar.setId(ContadorIdsEntidades.getNextIdPessoa());
        }
        diretores.put(diretorSalvar.getId(), diretorSalvar);
        return diretorSalvar.getId();
    }

    public DiretorEntity acharDiretorPorId(final Long id) {
        DiretorEntity diretor = diretores.getOrDefault(id, null);
        if( diretor==null ) { throw new NotFoundException("Diretor não encontrado"); }
        return diretor;
    }
}
