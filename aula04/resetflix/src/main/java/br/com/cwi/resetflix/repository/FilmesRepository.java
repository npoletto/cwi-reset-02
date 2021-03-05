package br.com.cwi.resetflix.repository;

import static java.util.Arrays.asList;

import java.util.*;

import br.com.cwi.resetflix.domain.BancoDeDadosResetFlix;
import br.com.cwi.resetflix.domain.ContadorIdsEntidades;
import br.com.cwi.resetflix.entity.AtorEntity;
import br.com.cwi.resetflix.exception.NotFoundException;
import br.com.cwi.resetflix.exception.UsuarioDesocupadoException;
import org.springframework.stereotype.Repository;

import br.com.cwi.resetflix.domain.Genero;
import br.com.cwi.resetflix.entity.FilmeEntity;

@Repository
public class FilmesRepository {

    private BancoDeDadosResetFlix banco = new BancoDeDadosResetFlix();

    public List<FilmeEntity> getFilmes() {
        return new ArrayList<>(banco.getFilmes().values());
    }

    public List<FilmeEntity> getFilmes(Genero genero) {
        List<FilmeEntity> lista = new ArrayList<>();
        for(FilmeEntity filme : banco.getFilmes().values()) {
            if(filme.getGenero()==genero) {
                lista.add(filme);
            }
        }
        return lista;
    }

    public List<FilmeEntity> getFilmesNaoAssistidos(Genero genero) {
        List<FilmeEntity> lista = new ArrayList<>();
        for(FilmeEntity filme : banco.getFilmes().values()) {
            if(filme.getGenero()==genero && !banco.isFilmeAssistido(filme.getId())) {
                lista.add(filme);
            }
        }
        return lista;
    }

    public List<FilmeEntity> acharFilmesAtor(final Long id) {
        List<FilmeEntity> lista = new ArrayList<>();
        for (Long idFilme : banco.getAtorById(id).getIdsFilmes()) {
            lista.add(banco.getFilmeById(idFilme));
        }
        return lista;
    }

    public List<FilmeEntity> acharFilmesDiretor(final Long id) {
        List<FilmeEntity> lista = new ArrayList<>();
        for(Long idFilme : banco.getDiretorById(id).getIdsFilmes()) {
            lista.add(banco.getFilmeById(idFilme));
        }
        return lista;
    }

    public FilmeEntity acharFilmesById(Long id) {
        FilmeEntity filme = banco.getFilmeById(id);
        if(filme==null) {
            throw new NotFoundException("Filme não encontrado");
        }
        return filme;
    }

    public Long criarFilme(FilmeEntity filmeSalvar) {
        return banco.insertFilme(filmeSalvar);
    }

    public void marcarComoAssistido(Long id) {
        banco.setFilmeAssistido(id);
    }

    public boolean isFilmeAssistido(Long id) {
        return banco.isFilmeAssistido(id);
    }

    public List<FilmeEntity> getRecomendacoes() {
        Set<Long> idsAssistidos = banco.getIdsFilmesAssistidos();
        HashMap<Genero, Integer> contagemGenerosAssistidos = new HashMap<>();
        for(Long id : idsAssistidos) {
            Genero genero = acharFilmesById(id).getGenero();
            int contagem = contagemGenerosAssistidos.getOrDefault(genero, 0);
            contagemGenerosAssistidos.put(genero, ++contagem);
        }
        Integer maior = 0;
        Genero generoMaior = null;
        for(Map.Entry<Genero,Integer> genero : contagemGenerosAssistidos.entrySet()) {
            if(genero.getValue() > maior) {
                maior = genero.getValue();
                generoMaior = genero.getKey();
            }
        }
        if(generoMaior==null) {
            throw new UsuarioDesocupadoException("Nada para indicar! Usuário nunca assistiu nada.");
        }
        return getFilmesNaoAssistidos(generoMaior);
    }
}
