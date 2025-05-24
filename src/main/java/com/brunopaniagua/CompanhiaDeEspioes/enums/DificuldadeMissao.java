package com.brunopaniagua.CompanhiaDeEspioes.enums;

public enum DificuldadeMissao {
    S("Muito Difícil"),
    A("Difícil"),
    B("Mediano"),
    C("Fácil");

    private String descricao;

    DificuldadeMissao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
