package br.com.cwi.resetflix.service;

import br.com.cwi.resetflix.domain.Genero;
import br.com.cwi.resetflix.entity.AtorEntity;
import br.com.cwi.resetflix.entity.DiretorEntity;
import br.com.cwi.resetflix.entity.FilmeEntity;
import br.com.cwi.resetflix.exception.BadRequestException;
import br.com.cwi.resetflix.exception.UsuarioDesocupadoException;
import br.com.cwi.resetflix.mapper.entity.FilmeEntityMapper;
import br.com.cwi.resetflix.mapper.details.ConsultarDetalhesFilmeResponseMapper;
import br.com.cwi.resetflix.mapper.response.FilmeResponseMapper;
import br.com.cwi.resetflix.repository.AtoresRepository;
import br.com.cwi.resetflix.repository.DiretoresRepository;
import br.com.cwi.resetflix.repository.FilmesRepository;
import br.com.cwi.resetflix.request.CriarFilmeRequest;
import br.com.cwi.resetflix.response.ConsultarDetalhesFilmeResponse;
import br.com.cwi.resetflix.response.FilmeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FilmesService {

    @Autowired
    AtoresRepository atoresRepository;

    @Autowired
    DiretoresRepository diretoresRepository;

    @Autowired
    FilmesRepository filmesRepository;

    static FilmeResponseMapper MAPPER_RESPONSE = new FilmeResponseMapper();
    static ConsultarDetalhesFilmeResponseMapper MAPPER_DETALHES_FILME = new ConsultarDetalhesFilmeResponseMapper();
    static FilmeEntityMapper MAPPER_ENTITY = new FilmeEntityMapper();

    public List<FilmeResponse> getFilmes(Genero genero) {
        if(genero==null) {
            return MAPPER_RESPONSE.mapear(filmesRepository.getFilmes());
        } else {
            return MAPPER_RESPONSE.mapear(filmesRepository.getFilmes(genero));
        }

    }

    public ConsultarDetalhesFilmeResponse getFilmesById(Long id) {
        FilmeEntity filmeSalvo = filmesRepository.acharFilmesById(id);
        DiretorEntity diretorSalvo = diretoresRepository.acharDiretorPorId(filmeSalvo.getIdDiretor());
        List<AtorEntity> atores = new ArrayList<>();
        for (Long idAtor : filmeSalvo.getIdsAtores()) {
            atores.add(atoresRepository.acharAtorPorId(idAtor));
        }
        return MAPPER_DETALHES_FILME.mapear(filmeSalvo, diretorSalvo, atores );
    }

    public Long criarFilme(CriarFilmeRequest request) {
        if(request.getNome()==null || request.getNome().isEmpty()) {
            throw new BadRequestException("O filme precisa de um nome.");
        }
        FilmeEntity filmeSalvar = MAPPER_ENTITY.mapear(request);
        return filmesRepository.criarFilme(filmeSalvar);
    }

    public void assistir(Long id) {
        filmesRepository.marcarComoAssistido(id);
    }

    public List<FilmeResponse> recomendacoes() {
        List<FilmeResponse> recomendacoes = MAPPER_RESPONSE.mapear(filmesRepository.getRecomendacoes());
        if(recomendacoes.isEmpty()) {
            throw new UsuarioDesocupadoException("Você já assistiu tudo do seu estilo predileto.");
        }
        return recomendacoes;
    }
}
