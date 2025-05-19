package model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import enums.RankEspioes;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "espioes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EspiaoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "idade")
    private int idade;

    @Column(name = "rank")
    private RankEspioes rank;

    @ManyToOne
    @JoinColumn(name = "missao_id")
    private MissaoModel missao;
}
