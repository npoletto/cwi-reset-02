package main;

import main.entidades.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        Ator ator1 = new Ator("Nicolas Cage", LocalDate.parse("30-01-1959",formatter), 1, Genero.MASCULINO);
        Ator ator2 = new Ator("Mary Louise Streep", LocalDate.parse("03-04-1939",formatter), 3, Genero.FEMININO);
        Ator ator2b = new Ator("Mary Louise Streep2", LocalDate.parse("03-04-1939",formatter), 3, Genero.FEMININO);
        Ator ator2c = new Ator("Mary Louise Streep3", LocalDate.parse("03-04-1939",formatter), 3, Genero.FEMININO);
        Ator ator3 = new Ator("Elliot Page", LocalDate.parse("27-04-1982",formatter), 0, Genero.NAO_BINARIO);

        Diretor diretor = new Diretor("Martin Scorsese",LocalDate.parse("01-01-1985",formatter) , 20, Genero.MASCULINO);
        ArrayList<Pessoa> elenco = new ArrayList<>();
        elenco.add(ator1);
        elenco.add(ator2);
        elenco.add(ator2b);
        elenco.add(ator2c);
        elenco.add(ator3);
        elenco.add(diretor);

        Filme filme = new Filme("Filme fictício", "Nunca existiu", 2020, 60, 5, elenco);

        HashMap<Integer,ArrayList<Pessoa>> mapa = filme.getElencoPorIdade();

        for (Integer idade : mapa.keySet()) {
            System.out.println("\nIdade: "+idade);
            ArrayList<Pessoa> pessoas = mapa.get(idade);
            for(Pessoa pessoa : pessoas) {
                System.out.println(pessoa);
            }
        }


        //System.out.println(filme.creditos());
    }
}
