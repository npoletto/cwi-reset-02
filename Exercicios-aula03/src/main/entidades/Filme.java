package main.entidades;

import java.util.ArrayList;
import java.util.HashMap;

public class Filme {

    ArrayList<Pessoa> pessoas;
    private String nome;
    private String descricao;
    private Diretor diretor;
    private int ano;
    private int duracao;
    private int avaliacao;

    public Filme(String nome, String descricao, int ano, int duracao, int avaliacao, ArrayList<Pessoa> pessoas) {
        this.nome = nome;
        this.descricao = descricao;
        this.ano = ano;
        this.duracao = duracao;
        this.pessoas = pessoas;
        defineAvaliacao(avaliacao);
    }

    public HashMap<Integer,ArrayList<Pessoa>> getElencoPorIdade (){
        HashMap<Integer,ArrayList<Pessoa>> map = new HashMap<>();

        for(Pessoa pessoa : pessoas) {
            if(map.containsKey(pessoa.getIdade())) {
                map.get(pessoa.getIdade()).add(pessoa);
            } else {
                ArrayList<Pessoa> pessoas = new ArrayList<>();
                pessoas.add(pessoa);
                map.put(pessoa.getIdade(),pessoas);
            }
        }
        return map;
    }


    public String creditos() {
        StringBuffer creditos = new StringBuffer("\n------------ "+nome+" ------------\n");
        Diretor diretor = null;
        for(Pessoa pessoa : pessoas) {
           creditos.append(pessoa + "\n");
        }
        return creditos.toString();
    }


        public void defineAvaliacao(int avaliacao) {
            if(nome.equalsIgnoreCase("o clube da luta")) {
                this.avaliacao = 5;
            } else if(nome.equalsIgnoreCase("batman vs superman")) {
                this.avaliacao = 1;
            } else if(avaliacao<1 || avaliacao>5) {
                this.avaliacao = 3;
                // Alternativa:
                // throw new IllegalArgumentException("A avaliação precisa ser entre 0 e 5.");
            } else {
                this.avaliacao = avaliacao;
            }
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

        public String getNome() {
            return nome;
        }

        public String getDescricao() {
            return descricao;
        }

        public Diretor getDiretor() {
            return diretor;
        }

        public int getAno() {
            return ano;
        }

        public int getAvaliacao() {
            return avaliacao;
        }



}
