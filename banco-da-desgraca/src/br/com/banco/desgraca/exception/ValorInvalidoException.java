package br.com.banco.desgraca.exception;

public class ValorInvalidoException extends IllegalArgumentException {
    public ValorInvalidoException (String mensagemDeErro) {
        super(mensagemDeErro);
    }

}
