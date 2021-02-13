package exercicio01;

public class Ator extends Pessoa {
    private int nroOscarsVencidos;

    public Ator(String nome, int idade, int nroOscarsVencidos, Genero genero) {
        super(nome, idade, genero);
        this.nroOscarsVencidos = nroOscarsVencidos;
    }

    public int getNroOscarsVencidos() {
        return nroOscarsVencidos;
    }

    public void setNroOscarsVencidos(int nroOscarsVencidos) {
        this.nroOscarsVencidos = nroOscarsVencidos;
    }
}
