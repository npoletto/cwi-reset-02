package br.com.cwi.resetflix.testesAleatorios;

import br.com.cwi.resetflix.exception.NotFoundException;

import java.util.ArrayList;

public class Pessoa extends Entidade {
    private ArrayList<Long> idsFilmes = new ArrayList<>();
    private final ArrayList<Profissao> profissoes = new ArrayList<>();

    public Pessoa(Long id, String nome, ArrayList<Long> idsFilmes) {
        super(id, nome);
        this.idsFilmes = idsFilmes;
    }

    public ArrayList<Long> getIdsFilmes() {
        return idsFilmes;
    }

    public void setIdsFilmes(ArrayList<Long> idsFilmes) {
        this.idsFilmes = idsFilmes;
    }

    public void addProfissao(Profissao profissao) {
        profissoes.add(profissao);
    }

    public ArrayList<Profissao> getProfissoes() {
        return profissoes;
    }

    public Profissao getProfissao(TipoProfissao tipoProfissao) {
        for(Profissao profissao : profissoes) {
            if (profissao.getTipoProfissao() == tipoProfissao) {
                return profissao;
            }
        }
        throw new RuntimeException("Pessoa não faz isso.");
    }
}
