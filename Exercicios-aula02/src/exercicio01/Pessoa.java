package exercicio01;

public class Pessoa {

        private String nome;
        private int idade;
        private Genero genero;

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public Genero getGenero() {
        return genero;
    }

    public Pessoa(String nome, int idade, Genero genero) {
            this.nome = nome;
            this.idade = idade;
            this.genero = genero;
        }

        public String toString() {
            return nome + " - idade: " + idade + " - Gênero: "+ genero.getDescricao();
        }

        public void imprime() {
            System.out.println(toString());
        }
    }

