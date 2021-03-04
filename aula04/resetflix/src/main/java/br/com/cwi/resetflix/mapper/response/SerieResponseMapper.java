package br.com.cwi.resetflix.mapper.response;

import br.com.cwi.resetflix.entity.SerieEntity;
import br.com.cwi.resetflix.response.SerieResponse;

import java.util.ArrayList;
import java.util.List;

public class SerieResponseMapper {

    public List<SerieResponse> mapear(final List<SerieEntity> series) {
        List<SerieResponse> responses = new ArrayList<>();

        for(SerieEntity serieEntity : series){
            responses.add(new SerieResponse(serieEntity.getId(),
                serieEntity.getNome(), serieEntity.getGenero()));
        }
        return responses;
    }
}
