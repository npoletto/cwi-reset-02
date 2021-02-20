package main.entidades;


import main.entidades.Diretor;
import main.entidades.Pessoa;
import main.entidades.Ator;

import java.util.ArrayList;

public class Filme {

    ArrayList<Pessoa> elenco;

    public Filme(ArrayList elenco) {
        this.elenco = elenco;
    }

    public String creditos() {
        StringBuffer creditos = new StringBuffer();
        for(Pessoa pessoa : elenco) {
            creditos.append(pessoa.getNome() + " - Idade: "+ pessoa.getIdade() + " - Gênero: " + pessoa.getGenero().getDescricao());
            if(pessoa instanceof Diretor) {
                creditos.append(" - Filmes dirigidos: " + ((Diretor) pessoa).getQtdFilmesProduzidos() );
            } else if (pessoa instanceof Ator) {
                creditos.append(" - Oscars: " + ((Ator) pessoa).getNroOscarsVencidos() );
            }
            creditos.append("\n");
        }

        return creditos.toString();
    }


}
