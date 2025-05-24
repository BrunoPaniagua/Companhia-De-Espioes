package com.brunopaniagua.CompanhiaDeEspioes.service;

import com.brunopaniagua.CompanhiaDeEspioes.dto.MissaoDTO;
import com.brunopaniagua.CompanhiaDeEspioes.mapper.MissaoMapper;
import com.brunopaniagua.CompanhiaDeEspioes.model.MissaoModel;
import com.brunopaniagua.CompanhiaDeEspioes.repository.MissaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MissaoService {

    private final MissaoRepository missaoRepository;
    private final MissaoMapper missaoMapper;

    public MissaoService(MissaoRepository missaoRepository, MissaoMapper missaoMapper) {
        this.missaoRepository = missaoRepository;
        this.missaoMapper = missaoMapper;
    }

    public MissaoDTO cadastrarMissao(MissaoDTO missaoDTO){
        MissaoModel novaMissao = missaoMapper.map(missaoDTO);
        missaoRepository.save(novaMissao);
        return missaoMapper.map(novaMissao);
    }

    public List<MissaoDTO> listarMissoes(){
        List<MissaoModel> missao = missaoRepository.findAll();
        return missao.stream()
                .map(missaoMapper::map)
                .collect(Collectors.toList());
    }
}
