package com.brunopaniagua.CompanhiaDeEspioes.service;

import com.brunopaniagua.CompanhiaDeEspioes.dto.EspiaoDTO;
import com.brunopaniagua.CompanhiaDeEspioes.mapper.EspiaoMapper;
import com.brunopaniagua.CompanhiaDeEspioes.model.EspiaoModel;
import org.springframework.stereotype.Service;
import com.brunopaniagua.CompanhiaDeEspioes.repository.EspiaoRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EspiaoService {

    private final EspiaoRepository espiaoRepository;
    private final EspiaoMapper espiaoMapper;

    public EspiaoService(EspiaoRepository espiaoRepository, EspiaoMapper espiaoMapper) {
        this.espiaoRepository = espiaoRepository;
        this.espiaoMapper = espiaoMapper;
    }

    public EspiaoDTO cadastrarEspiao(EspiaoDTO espiaoDTO) {
        EspiaoModel espiao = espiaoMapper.map(espiaoDTO);
        espiaoRepository.save(espiao);
        return espiaoMapper.map(espiao);
    }

    public List<EspiaoDTO> listarEspioes() {
        List<EspiaoModel> espioes = espiaoRepository.findAll();
        return espioes.stream()
                .map(espiaoMapper :: map)
                .collect(Collectors.toList());
    }
}
