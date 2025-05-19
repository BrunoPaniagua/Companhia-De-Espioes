package enums;

public enum RankEspioes {
    RECRUTA("Recruta - Nível Básico"),
    VETERANO("Veterano - Experiência média"),
    ELITE("Elite - Agente altamente treinado");

    private String descricao;

    RankEspioes(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}