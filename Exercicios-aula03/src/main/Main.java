package main;

import main.entidades.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Ator ator1 = new Ator("Nicolas Cage", 57, 1, Genero.MASCULINO);
        Ator ator2 = new Ator("Mary Louise Streep", 71, 3, Genero.FEMININO);
        Ator ator3 = new Ator("Elliot Page", 33, 0, Genero.NAO_BINARIO);

        Diretor diretor = new Diretor("Martin Scorsese", 78, 20, Genero.MASCULINO);
        ArrayList<Pessoa> elenco = new ArrayList<>();
        elenco.add(ator1);
        elenco.add(ator2);
        elenco.add(ator3);

        Filme filme = new Filme("Filme fictício", diretor, "Nunca existiu", 2020, 60, 5, elenco);

        System.out.println(filme.creditos());
    }
}
