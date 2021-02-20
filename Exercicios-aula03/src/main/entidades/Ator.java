package main.entidades;

import java.time.LocalDate;

public class Ator extends Pessoa {
    private int nroOscarsVencidos;

    public Ator(String nome, LocalDate idade, int nroOscarsVencidos, Genero genero) {
        super(nome, idade, genero);
        this.nroOscarsVencidos = nroOscarsVencidos;
    }

    public int getNroOscarsVencidos() {
        return nroOscarsVencidos;
    }

    public void setNroOscarsVencidos(int nroOscarsVencidos) {
        this.nroOscarsVencidos = nroOscarsVencidos;
    }

    @Override
    public String toString() {
        return super.toString() + " - Oscars: " + nroOscarsVencidos;
    }
}
