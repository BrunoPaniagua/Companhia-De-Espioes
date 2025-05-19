package dto;

import enums.RankEspioes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EspiaoDTO {

    private Long id;
    private String nome;
    private int idade;
    private RankEspioes rank;
    private Long idMissao;

}
