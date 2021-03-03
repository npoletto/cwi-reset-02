package br.com.cwi.resetflix.domain;

public final class ContadorIdsEntidades {

    private static Long idPessoa = 1L;
    private static Long idObra = 1L;

    public static Long getNextIdPessoa() {
        return idPessoa++;
    }

    public static Long getNextIdObra() {
        return idObra++;
    }
}
