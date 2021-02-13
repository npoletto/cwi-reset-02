package exercicio01;

public class Diretor {
    private String nome;
    private int idade;
    private int qtdFilmesProduzidos;
    private Genero genero;

    public Diretor(String nome, int idade, int qtdFilmesProduzidos, Genero genero) {
        this.nome = nome;
        this.idade = idade;
        this.qtdFilmesProduzidos = qtdFilmesProduzidos;
        this.genero = genero;
    }


    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getQtdFilmesProduzidos() {
        return qtdFilmesProduzidos;
    }

    public void setQtdFilmesProduzidos(int qtdFilmesProduzidos) {
        this.qtdFilmesProduzidos = qtdFilmesProduzidos;
    }

    public String toString() {
        return nome + " - idade: " + idade + " - Gênero: "+ genero.getDescricao();
    }

    public void imprime() {
        System.out.println(toString());
    }
}
