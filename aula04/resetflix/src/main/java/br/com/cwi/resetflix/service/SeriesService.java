package br.com.cwi.resetflix.service;

import br.com.cwi.resetflix.domain.Genero;
import br.com.cwi.resetflix.entity.AtorEntity;
import br.com.cwi.resetflix.entity.SerieEntity;
import br.com.cwi.resetflix.exception.BadRequestException;
import br.com.cwi.resetflix.mapper.details.ConsultarDetalhesSerieResponseMapper;
import br.com.cwi.resetflix.mapper.entity.SerieEntityMapper;
import br.com.cwi.resetflix.mapper.response.SerieResponseMapper;
import br.com.cwi.resetflix.repository.AtoresRepository;
import br.com.cwi.resetflix.repository.SeriesRepository;
import br.com.cwi.resetflix.request.CriarSerieRequest;
import br.com.cwi.resetflix.response.ConsultarDetalhesSerieResponse;
import br.com.cwi.resetflix.response.SerieResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SeriesService {

    @Autowired
    AtoresRepository atoresRepository;

    @Autowired
    SeriesRepository seriesRepository;

    static SerieResponseMapper MAPPER_RESPONSE = new SerieResponseMapper();
    static ConsultarDetalhesSerieResponseMapper MAPPER_DETALHES_FILME = new ConsultarDetalhesSerieResponseMapper();
    static SerieEntityMapper MAPPER_ENTITY = new SerieEntityMapper();

    public List<SerieResponse> getSeries(Genero genero) {
        if(genero==null) {
            return MAPPER_RESPONSE.mapear(seriesRepository.getSeries());
        } else {
            return MAPPER_RESPONSE.mapear(seriesRepository.getSeries(genero));
        }

    }

    public ConsultarDetalhesSerieResponse getSeriesById(Long id) {
        SerieEntity serieSalvo = seriesRepository.acharSeriesById(id);
        List<AtorEntity> atores = new ArrayList<>();
        for (Long idAtor : serieSalvo.getIdsAtores()) {
            atores.add(atoresRepository.acharAtorPorId(idAtor));
        }
        return MAPPER_DETALHES_FILME.mapear(serieSalvo, atores );
    }

    public Long criarSerie(CriarSerieRequest request) {
        if(request.getNome()==null || request.getNome().isEmpty()) {
            throw new BadRequestException("O serie precisa de um nome.");
        }
        SerieEntity serieSalvar = MAPPER_ENTITY.mapear(request);
        return seriesRepository.criarSerie(serieSalvar);
    }
}
