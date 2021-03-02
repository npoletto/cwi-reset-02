package br.com.cwi.resetflix.testesAleatorios;

public class Diretor implements Profissao {
    private TipoProfissao tipoProfissao;

    public Diretor() {
       this.tipoProfissao = TipoProfissao.DIRETOR;
    }

    public TipoProfissao getTipoProfissao() {
        return tipoProfissao;
    }

    public void dirigeFilme() {
        System.out.println("Estou dirigindo...");
    }
}
