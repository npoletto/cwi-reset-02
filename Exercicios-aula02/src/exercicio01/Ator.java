package exercicio01;

public class Ator {
    private String nome;
    private int idade;
    private int nroOscarsVencidos;
    private Genero genero;

    public Ator(String nome, int idade, int nroOscarsVencidos, Genero genero) {
        this.nome = nome;
        this.idade = idade;
        this.nroOscarsVencidos = nroOscarsVencidos;
        this.genero = genero;
    }

    public String toString() {
        return nome + " - idade: " + idade + " - Gênero: "+ genero.getDescricao();
    }

    public void imprime() {
        System.out.println(toString());
    }
}
