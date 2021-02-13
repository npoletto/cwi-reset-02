package aula02.exercicio1;

public class Aplicacao {
    public static void main(String[] args) {
        Diretor coppola = new Diretor("Francis Ford Coppola", 81, 27);
        Filme godfather = new Filme("The Godfather", coppola, "Filme sobre máfia italiana", 1972, 5);
        Diretor lynch = new Diretor("David Lynch", 75, 14);
        Filme blueVelvet = new Filme("Blue Velvet",
                lynch,
                "filme de longa-metragem de 1986, do gênero suspense, com roteiro e direção de David Lynch e trilha sonora criada por Angelo Badalamenti. O filme é um exemplo de neo-noir e contém elementos de surrealismo.[3]",
                1986,
                4);

        System.out.println(godfather);
        System.out.println("\n");
        System.out.println(blueVelvet);

    }


}
