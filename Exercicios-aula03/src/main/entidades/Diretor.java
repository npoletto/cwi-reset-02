package main.entidades;

public class Diretor extends Pessoa {
    private int qtdFilmesProduzidos;


    public Diretor(String nome, int idade, int qtdFilmesProduzidos, Genero genero) {
        super(nome,idade, genero);
        this.qtdFilmesProduzidos = qtdFilmesProduzidos;
    }

    public int getQtdFilmesProduzidos() {
        return qtdFilmesProduzidos;
    }

    public void setQtdFilmesProduzidos(int qtdFilmesProduzidos) {
        this.qtdFilmesProduzidos = qtdFilmesProduzidos;
    }

    @Override
    public String toString() {
        return getNome() + " - Idade: "+ getIdade() + " - Gênero: " + getGenero().getDescricao() + " - Filmes dirigidos: " + qtdFilmesProduzidos;
    }

}
