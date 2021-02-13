package exercicio01;

public class Diretor extends Pessoa {
    private int qtdFilmesProduzidos;


    public Diretor(String nome, int idade, int qtdFilmesProduzidos, Genero genero) {
        super(nome,idade, genero);
        this.qtdFilmesProduzidos = qtdFilmesProduzidos;
    }

    public int getQtdFilmesProduzidos() {
        return qtdFilmesProduzidos;
    }

    public void setQtdFilmesProduzidos(int qtdFilmesProduzidos) {
        this.qtdFilmesProduzidos = qtdFilmesProduzidos;
    }

}
