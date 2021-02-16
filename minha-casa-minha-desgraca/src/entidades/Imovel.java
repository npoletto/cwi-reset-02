package entidades;

import java.text.DecimalFormat;

public class Imovel {
    private Endereco endereco;
    private double valor;

    public Imovel(Endereco endereco, double valor) {
        this.endereco = endereco;
        this.valor = valor;
    }



    public String apresentacao() {
        return (endereco + " Valor: R$" + DecimalFormat.getCurrencyInstance().format(valor) + "\n" );
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public double getValor() {
        return valor;
    }
}
