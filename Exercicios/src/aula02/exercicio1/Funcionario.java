package aula02.exercicio1;

public class Funcionario {

    String cpf;
    String nome;
    private int idade;
    private double salario;
    private String cargo;
    private String status;


    public Funcionario(String cpf, String nome, int idade, double salario, String cargo, String status) {
        this.cpf = cpf;
        this.nome = nome;
        this.idade = idade;
        this.salario = salario;
        this.cargo = cargo;
        this.status = status;
    }
}
