package com.brunopaniagua.CompanhiaDeEspioes.mapper;

import com.brunopaniagua.CompanhiaDeEspioes.dto.EspiaoDTO;
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
        if(dto.getIdMissao() != null) {
            espiaoModel.setMissao(missaoRepository.getById(dto.getIdMissao()));
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
            espiaoDTO.setIdMissao(model.getMissao().getId());
        }else {
            espiaoDTO.setIdMissao(null);
        }
        return espiaoDTO;
    }

}
