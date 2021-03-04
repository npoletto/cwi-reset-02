package br.com.cwi.resetflix.repository;

import br.com.cwi.resetflix.domain.BancoDeDadosResetFlix;
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

    private BancoDeDadosResetFlix banco = new BancoDeDadosResetFlix();

    public List<DiretorEntity> getDiretores(){
        return new ArrayList<>(banco.getDiretores().values());
    }

    public Long criarDiretor(final DiretorEntity diretorSalvar) {
        return banco.insertDiretor(diretorSalvar);
    }

    public DiretorEntity acharDiretorPorId(final Long id) {
        DiretorEntity diretor = banco.getDiretorById(id);
        if( diretor==null ) { throw new NotFoundException("Diretor não encontrado"); }
        return diretor;
    }
}
