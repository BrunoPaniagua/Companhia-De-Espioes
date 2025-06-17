package com.brunopaniagua.CompanhiaDeEspioes.mapper;

import com.brunopaniagua.CompanhiaDeEspioes.dto.EspiaoDTO;
import com.brunopaniagua.CompanhiaDeEspioes.dto.EspiaoSemMissaoDTO;
import com.brunopaniagua.CompanhiaDeEspioes.dto.MissaoDTO;
import com.brunopaniagua.CompanhiaDeEspioes.model.EspiaoModel;
import com.brunopaniagua.CompanhiaDeEspioes.model.MissaoModel;
import org.springframework.stereotype.Component;
import com.brunopaniagua.CompanhiaDeEspioes.repository.EspiaoRepository;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MissaoMapper {

    private final EspiaoMapper espiaoMapper;

    public MissaoMapper(EspiaoMapper espiaoMapper) {
        this.espiaoMapper = espiaoMapper;
    }

    public MissaoModel map(MissaoDTO dto) {
        MissaoModel missaoModel = new MissaoModel();
        missaoModel.setId(dto.getId());
        missaoModel.setTitulo(dto.getTitulo());
        missaoModel.setDificuldade(dto.getDificuldade());
        missaoModel.setDescricao(dto.getDescricao());

        if (dto.getEspioes() != null && !dto.getEspioes().isEmpty()) {
            List<EspiaoModel> espioes = dto.getEspioes().stream()
                    .map(espiaoMapper::mapToEspiaoModel)
                    .collect(Collectors.toList());
            missaoModel.setEspiaos(espioes);
        } else {
            missaoModel.setEspiaos(null);
        }
        return missaoModel;
    }

    public MissaoDTO map(MissaoModel model) {
        MissaoDTO missaoDTO = new MissaoDTO();
        missaoDTO.setId(model.getId());
        missaoDTO.setTitulo(model.getTitulo());
        missaoDTO.setDificuldade(model.getDificuldade());
        missaoDTO.setDescricao(model.getDescricao());

        if (model.getEspiaos() != null && !model.getEspiaos().isEmpty()) {
            List<EspiaoSemMissaoDTO> espioes = model.getEspiaos().stream()
                    .map(espiaoMapper::mapToEspiaoSemMissaoDTO)
                    .collect(Collectors.toList());
            missaoDTO.setEspioes(espioes);
        } else {
            missaoDTO.setEspioes(null);
        }

        return missaoDTO;
    }
}