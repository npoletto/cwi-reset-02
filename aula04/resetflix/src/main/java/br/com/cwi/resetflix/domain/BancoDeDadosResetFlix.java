package br.com.cwi.resetflix.domain;

import br.com.cwi.resetflix.entity.AtorEntity;
import br.com.cwi.resetflix.entity.DiretorEntity;
import br.com.cwi.resetflix.entity.FilmeEntity;
import br.com.cwi.resetflix.entity.SerieEntity;
import br.com.cwi.resetflix.exception.BadRequestException;
import br.com.cwi.resetflix.exception.NotFoundException;

import java.util.*;

public class BancoDeDadosResetFlix {
    private static Long idAtor = 1L;
    private static Long idDiretor = 1L;
    private static Long idFilme = 1L;
    private static Long idSerie = 1L;

    private static Map<Long, AtorEntity> atores = new HashMap();
    private static Map<Long, DiretorEntity> diretores = new HashMap();
    private static Map<Long, FilmeEntity> filmes = new HashMap();
    private static Map<Long, SerieEntity> series = new HashMap();


    private static Map<Long, List<Long>> chavesAtorFilme = new HashMap<>();
    private static Map<Long, List<Long>> chavesFilmeAtor = new HashMap<>();
    private static Map<Long, List<Long>> chavesSerieAtor = new HashMap<>();
    private static Map<Long, List<Long>> chavesDiretorFilme = new HashMap<>();
    private static Set<Long> idsFilmesAssistidos = new HashSet<>();
    private static Set<Long> idsSeriesAssistidas = new HashSet<>();


    public Long insertAtor(AtorEntity atorSalvar) {
        if (atorSalvar.getId() == null) atorSalvar.setId(idAtor++);
        atores.put(atorSalvar.getId(), atorSalvar);
        if (!atorSalvar.getIdsFilmes().isEmpty()) {
            for(Long idFilme : atorSalvar.getIdsFilmes() ) {
                if(filmes.getOrDefault(idFilme, null) == null) {
                    throw new BadRequestException("Filme associado ao ator não existe.");
                }
                List<Long> atoresFilme = chavesFilmeAtor.getOrDefault(idFilme, new ArrayList<Long>());
                if (atoresFilme.isEmpty()) chavesFilmeAtor.put(idFilme, atoresFilme);
                atoresFilme.add(atorSalvar.getId());
            }
            chavesAtorFilme.put(atorSalvar.getId(), atorSalvar.getIdsFilmes());
        }
        return atorSalvar.getId();
    }

    public Long insertDiretor(DiretorEntity diretorSalvar) {
        if (diretorSalvar.getId() == null) diretorSalvar.setId(idDiretor++);
        diretores.put(diretorSalvar.getId(), diretorSalvar);
        if (!diretorSalvar.getIdsFilmes().isEmpty()) {
            for (Long idFilme : diretorSalvar.getIdsFilmes()) {
                FilmeEntity filme = filmes.getOrDefault(idFilme, null);
                if(filme == null) {
                    throw new BadRequestException("Filme associado ao diretor não existe.");
                }
                filme.setIdDiretor(diretorSalvar.getId());
            }
            chavesDiretorFilme.put(diretorSalvar.getId(), diretorSalvar.getIdsFilmes());
        }
        return diretorSalvar.getId();
    }

    public Long insertFilme(FilmeEntity filmeSalvar) {
            if(filmeSalvar.getId()==null) filmeSalvar.setId(idFilme++);
            filmes.put(filmeSalvar.getId(),filmeSalvar);
            if(!filmeSalvar.getIdsAtores().isEmpty()) {
                for(Long idAtor : filmeSalvar.getIdsAtores()) {
                    if(atores.getOrDefault(idAtor, null) == null) {
                        throw new BadRequestException("Ator associado ao filme não existe.");
                    }
                    List<Long> filmesAtor = chavesAtorFilme.getOrDefault(idAtor, new ArrayList<Long>());
                    if(filmesAtor.isEmpty()) chavesAtorFilme.put(idAtor,filmesAtor);
                    filmesAtor.add(filmeSalvar.getId());
                }
                chavesFilmeAtor.put(filmeSalvar.getId(),filmeSalvar.getIdsAtores());
            }
            return filmeSalvar.getId();
    }

    public Long insertSerie(SerieEntity serieSalvar) {
        if(serieSalvar.getId()==null) serieSalvar.setId(idSerie++);
        series.put(serieSalvar.getId(),serieSalvar);
        if(!serieSalvar.getIdsAtores().isEmpty()) {
            for(Long idAtor : serieSalvar.getIdsAtores()) {
                if(atores.getOrDefault(idAtor, null) == null) {
                    throw new BadRequestException("Ator associado a serie não existe.");
                }
            }
            chavesSerieAtor.put(serieSalvar.getId(),serieSalvar.getIdsAtores());
        }
        return serieSalvar.getId();
    }


    public AtorEntity getAtorById(Long id) {
        AtorEntity ator = atores.getOrDefault(id, null);
        if(ator!=null) {
            ator.setIdsFilmes(chavesAtorFilme.getOrDefault(ator.getId(), new ArrayList<>()));
        }
        return ator;

    }

    public DiretorEntity getDiretorById(Long id) {
        DiretorEntity diretor = diretores.getOrDefault(id, null);
        if(diretor!=null) {
            diretor.setIdsFilmes(chavesDiretorFilme.getOrDefault(diretor.getId(), new ArrayList<>()));
        }
        return diretor;
    }

    public FilmeEntity getFilmeById(Long id) {
        FilmeEntity filme = filmes.getOrDefault(id, null);
        if(filme!=null) {
            filme.setIdsAtores(chavesFilmeAtor.getOrDefault(filme.getId(), new ArrayList<>()));
        }
        return filme;
    }

    public SerieEntity getSerieById(Long id) {
        SerieEntity serie = series.getOrDefault(id, null);
        if(serie!=null) {
            serie.setIdsAtores(chavesSerieAtor.getOrDefault(serie.getId(), new ArrayList<>()));
        }
        return serie;
    }


    public static Map<Long, AtorEntity> getAtores() {
        return atores;
    }

    public static Map<Long, DiretorEntity> getDiretores() {
        return diretores;
    }

    public static Map<Long, FilmeEntity> getFilmes() {
        return filmes;
    }
    public Map<Long, SerieEntity> getSeries() {
        return series;
    }

    public void setFilmeAssistido(Long id) {
        if(!filmes.containsKey(id)) throw new NotFoundException("Filme a assistir não existe.");
        idsFilmesAssistidos.add(id);
    }

    public void setSerieAssistida(Long id) {
        if(!series.containsKey(id)) throw new NotFoundException("Serie a assistir não existe.");
        idsSeriesAssistidas.add(id);
    }

    public boolean isFilmeAssistido(Long id) {
        if(!filmes.containsKey(id)) throw new NotFoundException("Filme não existe.");
        return idsFilmesAssistidos.contains(id);
    }

    public boolean isSerieAssistida(Long id) {
        if(!series.containsKey(id)) throw new NotFoundException("Serie não existe.");
        return idsSeriesAssistidas.contains(id);
    }

    public static Set<Long> getIdsFilmesAssistidos() {
        return idsFilmesAssistidos;
    }

    public static Set<Long> getIdsSeriesAssistidas() {
        return idsSeriesAssistidas;
    }
}
