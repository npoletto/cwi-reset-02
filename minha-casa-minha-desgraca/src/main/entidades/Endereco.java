package main.entidades;

public class Endereco {
    private String logradouro;
    private Integer numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private UnidadeFederativa unidadeFederativa;


    public Endereco(String logradouro, Integer numero, String complemento, String bairro, String cidade, UnidadeFederativa unidadeFederativa) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.unidadeFederativa = unidadeFederativa;
    }

    public UnidadeFederativa getUnidadeFederativa() {
        return unidadeFederativa;
    }

    public String getEstado() {
        return unidadeFederativa.getNome();
    }

    public String toString() {
        return  logradouro + ", " + numero +
                (complemento.isEmpty() ? "" : " Complemento: " + complemento) +
                " Bairro: " + bairro + " - " +
                " Cidade: " + cidade + "-" + unidadeFederativa.getSigla();
    }
}
