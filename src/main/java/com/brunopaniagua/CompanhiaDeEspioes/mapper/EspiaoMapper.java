package com.brunopaniagua.CompanhiaDeEspioes.mapper;

import com.brunopaniagua.CompanhiaDeEspioes.dto.EspiaoDTO;
import com.brunopaniagua.CompanhiaDeEspioes.dto.EspiaoSemMissaoDTO;
import com.brunopaniagua.CompanhiaDeEspioes.dto.MissaoSemEspioesDTO;
import com.brunopaniagua.CompanhiaDeEspioes.model.EspiaoModel;
import org.springframework.stereotype.Component;
import com.brunopaniagua.CompanhiaDeEspioes.repository.MissaoRepository;

@Component
public class EspiaoMapper {

    private final MissaoRepository missaoRepository;

    public EspiaoMapper(MissaoRepository missaoRepository) {
        this.missaoRepository = missaoRepository;
    }

    public EspiaoModel map(EspiaoDTO dto) {
        EspiaoModel espiaoModel = new EspiaoModel();
        espiaoModel.setId(dto.getId());
        espiaoModel.setNome(dto.getNome());
        espiaoModel.setIdade(dto.getIdade());
        espiaoModel.setRank(dto.getRank());

        if(dto.getMissao() != null) {
            espiaoModel.setMissao(missaoRepository.getById(dto.getMissao().getId()));
        }else {
            espiaoModel.setMissao(null);
        }
        return espiaoModel;
    }

    public EspiaoDTO map(EspiaoModel model) {
        EspiaoDTO espiaoDTO = new EspiaoDTO();
        espiaoDTO.setId(model.getId());
        espiaoDTO.setNome(model.getNome());
        espiaoDTO.setIdade(model.getIdade());
        espiaoDTO.setRank(model.getRank());

        if(model.getMissao() != null) {
            espiaoDTO.setMissao(new MissaoSemEspioesDTO(
                    model.getMissao().getId(),
                    model.getMissao().getTitulo(),
                    model.getMissao().getDificuldade(),
                    model.getMissao().getDescricao()
            ));
        }else {
            espiaoDTO.setMissao(null);
        }
        return espiaoDTO;
    }

    public EspiaoModel mapToEspiaoModel(EspiaoSemMissaoDTO dto) {
        EspiaoModel espiaoModel = new EspiaoModel();
        espiaoModel.setId(dto.getId());
        espiaoModel.setNome(dto.getNome());
        espiaoModel.setIdade(dto.getIdade());
        espiaoModel.setRank(dto.getRank());
        // Missao é deixada como null pois é um DTO sem missão
        espiaoModel.setMissao(null);
        return espiaoModel;
    }

    public EspiaoSemMissaoDTO mapToEspiaoSemMissaoDTO(EspiaoModel model) {
        EspiaoSemMissaoDTO dto = new EspiaoSemMissaoDTO();
        dto.setId(model.getId());
        dto.setNome(model.getNome());
        dto.setIdade(model.getIdade());
        dto.setRank(model.getRank());
        return dto;
    }

}
