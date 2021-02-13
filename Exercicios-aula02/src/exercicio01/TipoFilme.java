package exercicio01;

public enum TipoFilme {
    TERROR("Terror")
    ;
    private String descricao;

    TipoFilme(String descricao) {
        this.descricao = descricao;
    }


    public String getDescricao() {
        return descricao;
    }
}

