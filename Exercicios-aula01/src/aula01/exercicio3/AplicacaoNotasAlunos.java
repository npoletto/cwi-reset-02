package aula01.exercicio3;

import java.util.Arrays;

public class AplicacaoNotasAlunos {
    public static void main(String[] args) {

        /*
            Demonstrando funcionamento do Objeto Aluno:
            Ex1: passando a nota por set.
            Ex2: passando a nota pelo construtor.
            Ambos exemplos chamam o método toString() da classe Aluno.
            Ex3: Lê dados da classe através de gets e imprime na tela sem usar toString().

         */

        Aluno aluno1 = new Aluno("Alexandre");
        aluno1.setNota(7.0);
        System.out.println(aluno1);

        Aluno aluno2 = new Aluno("João", 6.9);
        System.out.println(aluno2);

        Aluno aluno3 = new Aluno("Jack", 10);

        System.out.println ("\nNome do aluno: "+aluno3.getNome());
        System.out.println ("Nota: "+aluno3.getNota());
        System.out.println ("Aprovado? "+aluno3.isAprovado());

    }


}
