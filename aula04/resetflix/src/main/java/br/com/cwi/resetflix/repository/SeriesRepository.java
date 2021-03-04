package br.com.cwi.resetflix.repository;

import br.com.cwi.resetflix.domain.BancoDeDadosResetFlix;
import br.com.cwi.resetflix.domain.Genero;
import br.com.cwi.resetflix.entity.SerieEntity;
import br.com.cwi.resetflix.exception.NotFoundException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SeriesRepository {

    private BancoDeDadosResetFlix banco = new BancoDeDadosResetFlix();

    public List<SerieEntity> getSeries() {
        return new ArrayList<>(banco.getSeries().values());
    }

    public List<SerieEntity> getSeries(Genero genero) {
        List<SerieEntity> lista = new ArrayList<>();
        for(SerieEntity serie : banco.getSeries().values()) {
            if(serie.getGenero()==genero) {
                lista.add(serie);
            }
        }
        return lista;
    }


     public SerieEntity acharSeriesById(Long id) {
        SerieEntity serie = banco.getSerieById(id);
        if(serie==null) {
            throw new NotFoundException("Serie não encontrado");
        }
        return serie;
    }

    public Long criarSerie(SerieEntity serieSalvar) {
        return banco.insertSerie(serieSalvar);
    }
}
