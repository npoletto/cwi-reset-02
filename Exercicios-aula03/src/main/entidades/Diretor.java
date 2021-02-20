package main.entidades;

import java.time.LocalDate;

public class Diretor extends Pessoa {
    private int qtdFilmesProduzidos;


    public Diretor(String nome, LocalDate idade, int qtdFilmesProduzidos, Genero genero) {
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
        return super.toString() + " - Filmes dirigidos: " + qtdFilmesProduzidos;
    }

}
