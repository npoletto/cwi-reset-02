package br.com.cwi.resetflix.domain;

public final class ContadorIdsEntidades {

    private static Long id = 1L;

    public static Long getNextId() {
        return id++;
    }
}
