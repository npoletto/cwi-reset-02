package main.entidades;

import java.text.DecimalFormat;

public class Apartamento extends Imovel {

    private int andar;

    public Apartamento(Endereco endereco, double valor, int andar) {
        super(endereco, valor);
        this.andar = andar;
    }

    public String apresentacao() {
        return  super.getEndereco() + " - " +
                andar + "º andar" +
                " - " + " Valor: R$" + DecimalFormat.getCurrencyInstance().format(super.getValor());
    }
}
