package br.com.cwi.resetflix.service;

import br.com.cwi.resetflix.entity.DiretorEntity;
import br.com.cwi.resetflix.entity.FilmeEntity;
import br.com.cwi.resetflix.mapper.DiretorEntityMapper;
import br.com.cwi.resetflix.mapper.DiretoresResponseMapper;
import br.com.cwi.resetflix.mapper.ConsultarDetalhesDiretorResponseMapper;
import br.com.cwi.resetflix.repository.DiretoresRepository;
import br.com.cwi.resetflix.repository.FilmeRepository;
import br.com.cwi.resetflix.request.CriarDiretorRequest;
import br.com.cwi.resetflix.response.DiretoresResponse;
import br.com.cwi.resetflix.response.ConsultarDetalhesDiretorResponse;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DiretoresService {
    @Autowired
    private DiretoresRepository diretoresRepository;

    @Autowired
    private FilmeRepository filmeRepository;

    static DiretoresResponseMapper MAPPER_RESPONSE = new DiretoresResponseMapper();
    static DiretorEntityMapper MAPPER_ENTITY = new DiretorEntityMapper();
    static ConsultarDetalhesDiretorResponseMapper MAPPER_DETALHES_DIRETOR = new ConsultarDetalhesDiretorResponseMapper();

    public List<DiretoresResponse> getDiretores() {
        final List<DiretorEntity> diretores = diretoresRepository.getDiretores();
        return MAPPER_RESPONSE.mapear(diretores);
    }

    public Long criarDiretor(final CriarDiretorRequest request) {
        DiretorEntity diretorSalvar = MAPPER_ENTITY.mapear(request);
        return diretoresRepository.criarDiretor(diretorSalvar);
    }

    public ConsultarDetalhesDiretorResponse consultarDetalhesDiretor(final Long id) {
        DiretorEntity diretorSalvo = diretoresRepository.acharDiretorPorId(id);
        List<FilmeEntity> filmesDiretor = filmeRepository.acharFilmesDiretor(id);
        return MAPPER_DETALHES_ATOR.mapear(diretorSalvo, filmesDiretor);
    }
}
