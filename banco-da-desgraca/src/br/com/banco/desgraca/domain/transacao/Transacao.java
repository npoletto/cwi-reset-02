package br.com.banco.desgraca.domain.transacao;

import br.com.banco.desgraca.domain.transacao.enums.TipoTransacao;

import java.text.DecimalFormat;
import java.time.LocalDate;

public class Transacao {
    private LocalDate date;
    private TipoTransacao tipoTransacao;
     private double valor;

    public Transacao(LocalDate date, TipoTransacao tipoTransacao, double valor) {
        this.date = date;
        this.tipoTransacao = tipoTransacao;
        this.valor = valor;
    }

    public LocalDate getDate() {
        return date;
    }

    public TipoTransacao getTipoTransacao() {
        return tipoTransacao;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder(valor<0 ? "-" : "+");
        str.append("\t");
        str.append(DecimalFormat.getCurrencyInstance().format(Math.abs(valor)));
        if(str.length()<10) str.append("\t");
        str.append("\t");
        str.append(date);
        str.append("\t");
        str.append(tipoTransacao.getDescricao());
        return str.toString();
    }
}
