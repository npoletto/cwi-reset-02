package br.com.cwi.resetflix.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.cwi.resetflix.domain.BancoDeDadosResetFlix;
import br.com.cwi.resetflix.domain.ContadorIdsEntidades;
import br.com.cwi.resetflix.exception.BadRequestException;
import br.com.cwi.resetflix.exception.NotFoundException;
import org.springframework.stereotype.Repository;

import br.com.cwi.resetflix.entity.AtorEntity;

@Repository
public class AtoresRepository {

     private BancoDeDadosResetFlix banco = new BancoDeDadosResetFlix();

    public List<AtorEntity> getAtores(){
        return new ArrayList<>(banco.getAtores().values());
    }

    public Long criarAtor(final AtorEntity atorSalvar) {
        return banco.insertAtor(atorSalvar);
    }

    public AtorEntity acharAtorPorId(final Long id) {
        AtorEntity ator = banco.getAtorById(id);
        if(ator==null) throw new NotFoundException("Ator não encontrado.");
        return ator;
    }
}
