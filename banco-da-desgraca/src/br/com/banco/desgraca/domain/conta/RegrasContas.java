package br.com.banco.desgraca.domain.conta;

public class RegrasContas {
    double taxaSaque;
    double taxaTransferenciaMesmaInstituicao;
    double taxaTransferenciaOutraInstituicao;
    double saqueMinimo;
    double saqueMultiploDoValor;

    public RegrasContas(double taxaSaque,
                        double taxaTransferenciaMesmaInstituicao,
                        double taxaTransferenciaOutraInstituicao,
                        double saqueMinimo,
                        double saqueMultiploDoValor) {

        this.taxaSaque = taxaSaque;
        this.taxaTransferenciaMesmaInstituicao = taxaTransferenciaMesmaInstituicao;
        this.taxaTransferenciaOutraInstituicao = taxaTransferenciaOutraInstituicao;
        this.saqueMinimo = saqueMinimo;
        this.saqueMultiploDoValor = saqueMultiploDoValor;
    }

    public double getTaxaSaque() {
        return taxaSaque;
    }

    public double getTaxaTransferenciaMesmaInstituicao() {
        return taxaTransferenciaMesmaInstituicao;
    }

    public double getTaxaTransferenciaOutraInstituicao() {
        return taxaTransferenciaOutraInstituicao;
    }

    public double getSaqueMinimo() {
        return saqueMinimo;
    }

    public double getSaqueMultiploDoValor() {
        return saqueMultiploDoValor;
    }
}
