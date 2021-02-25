package br.com.banco.desgraca.exception;

public class CriacaoDeContaNaoPermitidaException extends RuntimeException {
    public CriacaoDeContaNaoPermitidaException(String mensagemDeErro) {
        super(mensagemDeErro);
    }
}
