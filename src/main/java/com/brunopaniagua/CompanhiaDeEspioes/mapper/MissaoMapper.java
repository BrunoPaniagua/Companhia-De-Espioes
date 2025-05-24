package com.brunopaniagua.CompanhiaDeEspioes.mapper;

import com.brunopaniagua.CompanhiaDeEspioes.dto.MissaoDTO;
import com.brunopaniagua.CompanhiaDeEspioes.model.EspiaoModel;
import com.brunopaniagua.CompanhiaDeEspioes.model.MissaoModel;
import org.springframework.stereotype.Component;
import com.brunopaniagua.CompanhiaDeEspioes.repository.EspiaoRepository;

import java.util.stream.Collectors;

@Component
public class MissaoMapper {

    private final EspiaoRepository espiaoRepository;

    public MissaoMapper(EspiaoRepository espiaoRepository) {
        this.espiaoRepository = espiaoRepository;
    }

    public MissaoModel map(MissaoDTO dto) {
        MissaoModel missaoModel = new MissaoModel();
        missaoModel.setId(dto.getId());
        missaoModel.setTitulo(dto.getTitulo());
        missaoModel.setDificuldade(dto.getDificuldade());
        missaoModel.setDescricao(dto.getDescricao());

        if (dto.getIdEspioes() != null && !dto.getIdEspioes().isEmpty()) {
            missaoModel.setEspiaos(espiaoRepository.findAllById(dto.getIdEspioes()));
        }else {
            missaoModel.setEspiaos(null);
        }

        return missaoModel;
    }

    public MissaoDTO map(MissaoModel model){
        MissaoDTO missaoDTO = new MissaoDTO();
        missaoDTO.setId(model.getId());
        missaoDTO.setTitulo(model.getTitulo());
        missaoDTO.setDificuldade(model.getDificuldade());
        missaoDTO.setDescricao(model.getDescricao());

        if (model.getEspiaos() != null) {
            missaoDTO.setIdEspioes(model.getEspiaos().stream()
                    .map(EspiaoModel::getId)
                    .collect(Collectors.toList()));
        }else{
            missaoDTO.setIdEspioes(null);
        }

        return missaoDTO;
    }

}
