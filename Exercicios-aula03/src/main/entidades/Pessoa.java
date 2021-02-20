package main.entidades;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Pessoa {

        private String nome;
        private LocalDate dataNascimento;
        private Genero genero;
        private int idade;

    public String getNome() {
        return nome;
    }

    public LocalDate getdataNascimento() {
        return dataNascimento;
    }

    public Genero getGenero() {
        return genero;
    }

    public Pessoa(String nome, LocalDate dataNascimento, Genero genero) {
            this.nome = nome;
            this.dataNascimento = dataNascimento;
            this.genero = genero;
            this.idade = (int) dataNascimento.until(LocalDate.now(),ChronoUnit.YEARS);
        }

        public String toString() {
            return nome + " - idade: " + idade + " - Gênero: "+ genero.getDescricao();
        }

        public int getIdade() {
            return idade;
        }

        public void imprime() {
            System.out.println(toString());
        }
    }

