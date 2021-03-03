package br.com.cwi.resetflix.repository;

import static java.util.Arrays.asList;

import java.util.*;

import br.com.cwi.resetflix.domain.ContadorIdsEntidades;
import br.com.cwi.resetflix.entity.AtorEntity;
import org.springframework.stereotype.Repository;

import br.com.cwi.resetflix.domain.Genero;
import br.com.cwi.resetflix.entity.FilmeEntity;

@Repository
public class FilmesRepository {

    //static Map<Long, FilmeEntity> filmes = new HashMap<>();
    static Map<Long, FilmeEntity> filmes;

    static {
        filmes = Collections.singletonMap(1L,
                new FilmeEntity(1L, "Interestelar", Genero.FICCAO_CIENTIFICA,
                        1L, asList(2L))
        );
    }

    public List<FilmeEntity> getFilmes() {
        return new ArrayList<>(filmes.values());
    }

    public List<FilmeEntity> getFilmes(Genero genero) {
        List<FilmeEntity> lista = new ArrayList<>();
        for(FilmeEntity filme : filmes.values()) {
            if(filme.getGenero()==genero) {
                lista.add(filme);
            }
        }
        return lista;
    }


    public List<FilmeEntity> acharFilmesAtor(final Long id) {
        List<FilmeEntity> lista = new ArrayList<>();
        for(FilmeEntity filme : filmes.values()) {
            for(Long idAtor: filme.getIdsAtores()) {
                if(idAtor.equals(id)) lista.add( filme );
            }
        }
        return lista;
    }

    public List<FilmeEntity> acharFilmesDiretor(final Long id) {
        List<FilmeEntity> lista = new ArrayList<>();
        for(FilmeEntity filme : filmes.values()) {
            if(filme.getIdDiretor().equals(id)) lista.add( filme );
        }
        return lista;
    }

    public FilmeEntity acharFilmesById(Long id) {
        return filmes.getOrDefault(id, null);
    }
}
