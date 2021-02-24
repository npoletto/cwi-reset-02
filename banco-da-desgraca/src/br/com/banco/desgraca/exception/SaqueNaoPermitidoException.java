package br.com.banco.desgraca.exception;

public class SaqueNaoPermitidoException extends RuntimeException {

    public SaqueNaoPermitidoException(String mensagemDeErro) {
        super(mensagemDeErro);
    }
}
