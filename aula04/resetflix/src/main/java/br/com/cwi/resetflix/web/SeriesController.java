package br.com.cwi.resetflix.web;

import br.com.cwi.resetflix.domain.Genero;
import br.com.cwi.resetflix.request.CriarSerieRequest;
import br.com.cwi.resetflix.response.ConsultarDetalhesSerieResponse;
import br.com.cwi.resetflix.response.SerieResponse;
import br.com.cwi.resetflix.service.SeriesService;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/series")
public class SeriesController implements SeriesContract {

    @Autowired
    private SeriesService seriesService;

    @Override
    @GetMapping
    public List<SerieResponse> getSeries(@RequestParam(value = "genero", required = false) final Genero genero) {
        return seriesService.getSeries(genero);
    }

    @Override
    @GetMapping("/{id}")
    public ConsultarDetalhesSerieResponse getSerieById(@PathVariable("id") final Long id) {
        return seriesService.getSeriesById(id);
    }

    @Override
    @PostMapping
    public Long criarSerie(@RequestBody final CriarSerieRequest request) {
       return seriesService.criarSerie(request);
    }

    @GetMapping("/recomendacoes")
    public List<SerieResponse> getRecomendacoesSeries() {
        return seriesService.recomendacoes();
    }

    @Override
    @PostMapping("/{id}/{temporada}/{episodio}/assistir")
    public void assistirSerie(@PathVariable("id") final Long id,
                              @PathVariable("temporada") final Integer temporada,
                              @PathVariable("episodio") final Integer episodio) {
        System.out.println("ID da série recebido: " + id);
        seriesService.assistir(id, temporada, episodio);
    }
}
