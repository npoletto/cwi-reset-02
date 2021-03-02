package br.com.cwi.resetflix.testesAleatorios;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class RegrasPessoas {
    static HashMap<Long, Pessoa> pessoas = new HashMap<>();
    private long id=1L;

    public Pessoa addPessoa(String nome) {
        Pessoa pessoa = new Pessoa(id++, nome, null); //idsFilmes nulo por enquanto para facilitar
        pessoas.put(pessoa.getId(), pessoa );  //só para simular um banco de dados
        return pessoa;
    }

    public void tornarDiretor(Pessoa pessoa) {
        pessoas.get(pessoa.getId()).addProfissao(new Diretor());
    }

    public void tornarAtor(Pessoa pessoa) {
        pessoas.get(pessoa.getId()).addProfissao(new Ator());
    }

    public ArrayList<Pessoa> getProfissionais(TipoProfissao tipoProfissao) {
        ArrayList<Pessoa> lista = new ArrayList<>();
        for(long key : pessoas.keySet()) {
            Pessoa pessoa = pessoas.get(key);
                for(Profissao profissao : pessoa.getProfissoes()) {
                    if(profissao.getTipoProfissao()==tipoProfissao) {
                        lista.add(pessoa);
                    }
                }
        }
        return lista;
    }


}
