package aula01.exercicio3;

public class Aluno {

    final double NOTA_MINIMA = 7.0;

    private String nome;
    private Double nota;


    public Aluno(String nome) {
        this.nome = nome;
    }

    public Aluno(String nome, double nota) {
        this.nome = nome;
        this.nota = nota;
    }

    public String getNome() {
        return nome;
    }

    public double getNota() {
        return nota;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public boolean isAprovado() {
        return(nota >= NOTA_MINIMA);
    }

    public String toString() {
        String resultadoAprovacao = isAprovado() ? "Aprovado" : "Reprovado";
        return "Nome: " + nome + " - nota: "+ nota + " - " + resultadoAprovacao;
    }
}
