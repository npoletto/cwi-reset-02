package br.com.cwi.resetflix.testesAleatorios;

public class Ator implements Profissao {
    private TipoProfissao tipoProfissao;

    public Ator() {
        tipoProfissao = TipoProfissao.ATOR;
    }

    @Override
    public TipoProfissao getTipoProfissao() {
        return tipoProfissao;
    }

    public void atua() {
        System.out.println("Estou atuando...");
    }
}
