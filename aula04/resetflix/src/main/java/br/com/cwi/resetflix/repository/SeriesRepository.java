package br.com.cwi.resetflix.repository;

import br.com.cwi.resetflix.domain.BancoDeDadosResetFlix;
import br.com.cwi.resetflix.domain.Genero;
import br.com.cwi.resetflix.entity.FilmeEntity;
import br.com.cwi.resetflix.entity.SerieEntity;
import br.com.cwi.resetflix.exception.NotFoundException;
import br.com.cwi.resetflix.exception.UsuarioDesocupadoException;
import org.springframework.stereotype.Repository;

import java.util.*;

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

    public void marcadoComoAssistido(Long id, Integer temporada, Integer episodio) {
        banco.setSerieAssistida(id);
        /*Basta assistir um episódio que a série inteira será marcada como assistida.
        Logo a informação de temporada e episódio agora é irrelevante.
        */
    }

    public List<SerieEntity> recomendacoes() {
        Set<Long> idsAssistidos = banco.getIdsSeriesAssistidas();
        HashMap<Genero, Integer> contagemGenerosAssistidos = new HashMap<>();
        for(Long id : idsAssistidos) {
            Genero genero = acharSeriesById(id).getGenero();
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
        return getSeriesNaoAssistidas(generoMaior);
    }

    public List<SerieEntity> getSeriesNaoAssistidas(Genero genero) {
        List<SerieEntity> lista = new ArrayList<>();
        for(SerieEntity serie : banco.getSeries().values()) {
            if(serie.getGenero()==genero && !banco.isSerieAssistida(serie.getId())) {
                lista.add(serie);
            }
        }
        return lista;
    }
    
}
