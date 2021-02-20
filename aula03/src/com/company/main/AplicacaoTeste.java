package com.company.main;

import com.company.domain.Editora;

public class AplicacaoTeste {
    public static void main(String[] args) {
        try {
            Editora editora = new Editora("DC Comics", "EUA");
        } catch(Exception ex) {
            System.out.println("Opa, tivemos um problema:\n"+ex.toString());
        }
    }
}
