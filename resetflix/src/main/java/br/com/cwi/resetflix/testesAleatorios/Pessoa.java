package br.com.cwi.resetflix.testesAleatorios;

import br.com.cwi.resetflix.exception.NotFoundException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Pessoa extends Entidade {
    private List<Long> idsFilmes = new ArrayList<>();
    private final Set<TipoProfissao> profissoes = new HashSet<>();

    public Pessoa(Long id, String nome, ArrayList<Long> idsFilmes) {
        super(id, nome);
        this.idsFilmes = idsFilmes;
    }

    public List<Long> getIdsFilmes() {
        return idsFilmes;
    }

    public void setIdsFilmes(ArrayList<Long> idsFilmes) {
        this.idsFilmes = idsFilmes;
    }

    public void addProfissao(TipoProfissao tipoProfissao) {
        profissoes.add(tipoProfissao);
    }

    public Set<TipoProfissao> getProfissoes() {
        return profissoes;
    }

    public boolean isProfissao(TipoProfissao tipoProfissao) {
        return profissoes.contains(tipoProfissao);
    }
}
