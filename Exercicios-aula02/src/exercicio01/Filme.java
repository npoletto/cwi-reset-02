package exercicio01;

public class Filme {
    private String nome;
    private String descricao;
    private Diretor diretor;
    private int ano;
    private int duracao;
    private int avaliacao;

    public Filme(String nome, Diretor diretor, String descricao, int ano, int duracao, int avaliacao) {
        this.nome = nome;
        this.diretor = diretor;
        this.descricao = descricao;
        this.ano = ano;
        this.avaliacao = avaliacao;
    }

    public Filme(String nome) {
        this.nome = nome;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(int avaliacao) {
        this.avaliacao = avaliacao;
    }

    public Diretor getDiretor() {
        return diretor;
    }

    public void setDiretor(Diretor diretor) {
        this.diretor = diretor;
    }

    public String rodarFilme() {
        return "Filme: "+ nome +
                "\nDiretor: "+diretor+
                "\nDescrição: "+descricao+
                "\nAno: "+ano+
                "\nAvaliação: "+avaliacao;


    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }
}
