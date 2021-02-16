package main.entidades;

public class Beneficiario {
    private String nome;
    private Double salario;


    public Beneficiario(String nome, Double salario) {
        this.nome = nome;
        this.salario = salario;
    }


    public Double getSalario() {
        return salario;
    }

    public String getNome() {
        return nome;
    }
}
