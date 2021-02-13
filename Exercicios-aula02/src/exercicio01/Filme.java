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
        this.duracao = duracao;
        this.avaliacao = avaliacao;
    }

    public void exibir() {
        System.out.println( "Filme: "+ nome +
                "\nDiretor: "+diretor.getNome()+
                "\nDescrição: "+descricao+
                "\nAno: "+ano+
                "\nDuração: "+duracao+ " minutos"+
                "\nAvaliação: "+avaliacao);

    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }
}
