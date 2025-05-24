package com.brunopaniagua.CompanhiaDeEspioes.dto;

import com.brunopaniagua.CompanhiaDeEspioes.enums.DificuldadeMissao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MissaoDTO {

    private Long id;
    private String titulo;
    private DificuldadeMissao dificuldade;
    private String descricao;
    private List<Long> idEspioes;
}
