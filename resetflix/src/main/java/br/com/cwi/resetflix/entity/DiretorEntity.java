package br.com.cwi.resetflix.entity;

import java.util.List;

public class DiretorEntity extends ProfissionalEntity {


    public DiretorEntity(Long id, String nome, List<Long> idsFilmes) {
        super(id, nome, idsFilmes);
    }

    public DiretorEntity(String nome, List<Long> idsFilmes) {
        super(nome, idsFilmes);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
