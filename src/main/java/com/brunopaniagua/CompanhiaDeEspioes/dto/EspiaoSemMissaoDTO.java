package com.brunopaniagua.CompanhiaDeEspioes.dto;

import com.brunopaniagua.CompanhiaDeEspioes.enums.RankEspioes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EspiaoSemMissaoDTO {
    private Long id;
    private String nome;
    private int idade;
    private RankEspioes rank;
}
