package com.brunopaniagua.CompanhiaDeEspioes.controller;

import com.brunopaniagua.CompanhiaDeEspioes.dto.EspiaoDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.brunopaniagua.CompanhiaDeEspioes.service.EspiaoService;

import java.util.List;

@RestController
@RequestMapping("/espioes")
public class EspiaoController {

    private final EspiaoService espiaoService;

    public EspiaoController(EspiaoService espiaoService) {
        this.espiaoService = espiaoService;
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<String> cadastrarEspiao(@RequestBody EspiaoDTO espiaoDTO){
        EspiaoDTO novoEspiao = espiaoService.cadastrarEspiao(espiaoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoEspiao.toString());
    }

    @GetMapping("/mostrar")
    public ResponseEntity<?> mostrarEspioes(){
        List<EspiaoDTO> espioes = espiaoService.listarEspioes();
        if(espioes.isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.ok(espioes);
    }

}
