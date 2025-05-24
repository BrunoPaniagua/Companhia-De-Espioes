package com.brunopaniagua.CompanhiaDeEspioes.model;

import com.brunopaniagua.CompanhiaDeEspioes.enums.DificuldadeMissao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name="missoes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MissaoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="titulo")
    private String titulo;

    @Column(name = "dificuldade")
    private DificuldadeMissao dificuldade;

    @Column(name = "descricao")
    private String descricao;

    @OneToMany(mappedBy = "missao")
    private List<EspiaoModel> espiaos;

}
