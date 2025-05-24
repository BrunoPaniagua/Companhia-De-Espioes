package com.brunopaniagua.CompanhiaDeEspioes.controller;

import com.brunopaniagua.CompanhiaDeEspioes.dto.MissaoDTO;
import com.brunopaniagua.CompanhiaDeEspioes.service.MissaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissaoController {

    private final MissaoService missaoService;

    public MissaoController(MissaoService missaoService) {
        this.missaoService = missaoService;
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<String> cadastrarMissao (@RequestBody MissaoDTO missaoDTO){
        MissaoDTO missao = missaoService.cadastrarMissao(missaoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(missao.toString());
    }

    @GetMapping("/mostrar")
    public ResponseEntity<?> mostrarMissao(){
        List<MissaoDTO> missoes = missaoService.listarMissoes();
        if(missoes.isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.ok(missoes);
    }

}
