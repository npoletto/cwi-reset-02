package main.entidades;

import java.text.DecimalFormat;

public class Casa extends Imovel {

    private boolean possuiPatio;

    public Casa(Endereco endereco, double valor, boolean possuiPatio) {
        super(endereco, valor);
        this.possuiPatio = possuiPatio;
    }

    public String apresentacao() {
        return  getEndereco() + " - " +
                (possuiPatio ? "Com pátio" : "Sem pátio") +
                " - " + " Valor: R$" + DecimalFormat.getCurrencyInstance().format(getValor());
    }
}
