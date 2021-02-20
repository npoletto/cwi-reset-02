package com.company.main;

import com.company.domain.Diretor;
import com.company.domain.Editora;
import com.company.domain.Filme;
import com.company.enums.Genero;

public class AplicacaoTeste {
    public static void main(String[] args) {
        try {
            Editora editora = new Editora("Marvel", "EUA");
            Filme filme = new Filme("Cidade de Deus",
                                    "Melhor filme nacional",
                                    180,
                                    2010,
                                    5,
                                    new Diretor("padilha", 56, 23, Genero.MASCULINO));
        } catch(Exception ex) {
            System.out.println("Opa, tivemos um problema:\n"+ex.toString());
        }
    }
}
