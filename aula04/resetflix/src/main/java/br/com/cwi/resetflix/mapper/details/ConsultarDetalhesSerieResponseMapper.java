package br.com.cwi.resetflix.mapper.details;

import br.com.cwi.resetflix.entity.AtorEntity;
import br.com.cwi.resetflix.entity.SerieEntity;
import br.com.cwi.resetflix.mapper.response.AtoresResponseMapper;
import br.com.cwi.resetflix.response.AtoresResponse;
import br.com.cwi.resetflix.response.ConsultarDetalhesSerieResponse;
import br.com.cwi.resetflix.response.DiretoresResponse;

import java.util.List;

public class ConsultarDetalhesSerieResponseMapper {

    public ConsultarDetalhesSerieResponse mapear(final SerieEntity serieSalvo, List<AtorEntity> atores) {
        List<AtoresResponse> atoresResponse = new AtoresResponseMapper().mapear(atores);
        return new ConsultarDetalhesSerieResponse(serieSalvo.getId(), serieSalvo.getNome(),serieSalvo.getGenero(), atoresResponse, serieSalvo.getTemporadas(), serieSalvo.getEpisodios());
    }
}
