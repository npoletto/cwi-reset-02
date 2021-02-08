package aula01.exercicio1e2;

public class AplicacaoCalculadoraEComparador {
    public static void main(String[] args) {



        /*
            Exercício 1, testando calculadora.
            Teste adicional: Verificar se aceita tanto inteiros como doubles.
         */

        Calculadora calculadora = new Calculadora();
        double doubleA = 1.1, doubleB = 2.3;
        int intA = 1 , intB = 2;
        System.out.println("Soma: " + calculadora.soma(doubleA,doubleB));
        System.out.println("Soma: " + calculadora.soma(intA,intB));


        /*
            Exercício 2, testando comparador.
        */
        Comparador comparador = new Comparador();
        System.out.println("Resultado da comparação menor que: " + comparador.menorQue(doubleA, doubleB));



    }
}
