package exercicio01;

public class Aplicacao {
    public static void main(String[] args) {
        Diretor coppola = new Diretor("Francis Ford Coppola", 81, 27);
        Filme godfather = new Filme("The Godfather",
                coppola,
                " filme norte-americano de 1972, dirigido por Francis Ford Coppola, baseado no livro homônimo escrito por Mario Puzo. É estrelado por Marlon Brando, Al Pacino, James Caan, Richard Castellano, Robert Duvall, Sterling Hayden, John Marley, Richard Conte e Diane Keaton. O enredo se baseia na história da família mafiosa Corleone, de 1945 até 1955. Teve duas sequências: The Godfather: Part II, em 1974; e The Godfather: Part III em 1990.",
                1972,
                180,
                5);
        Diretor lynch = new Diretor("David Lynch", 75, 14);
        Filme blueVelvet = new Filme("Blue Velvet",
                lynch,
                "filme de longa-metragem de 1986, do gênero suspense, com roteiro e direção de David Lynch e trilha sonora criada por Angelo Badalamenti. O filme é um exemplo de neo-noir e contém elementos de surrealismo.[3]",
                1986,
                180,
                4);

        System.out.println(godfather.rodarFilme());
        System.out.println("\n");
        System.out.println(blueVelvet.rodarFilme());

    }


}
