package com.brunopaniagua.CompanhiaDeEspioes.dto;

import com.brunopaniagua.CompanhiaDeEspioes.enums.DificuldadeMissao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MissaoSemEspioesDTO {
    private Long id;
    private String titulo;
    private DificuldadeMissao dificuldade;
    private String descricao;
}
