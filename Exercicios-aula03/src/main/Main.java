package main;

import main.entidades.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Ator ator1 = new Ator("João", 32, 4, Genero.MASCULINO);
        Ator ator2 = new Ator("Maria", 12, 2, Genero.FEMININO);
        Ator ator3 = new Ator("Pablo", 40, 0, Genero.NAO_BINARIO);

        Diretor diretor = new Diretor("Martin", 78, 20, Genero.MASCULINO);
        ArrayList<Pessoa> elenco = new ArrayList<>();
        elenco.add(ator1);
        elenco.add(ator2);
        elenco.add(ator3);
        elenco.add(diretor);

        Filme filme = new Filme(elenco);

        System.out.println(filme.creditos());
    }
}
