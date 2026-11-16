package br.com.samuel.spring_boot_essencials.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

    @Entity
    @Table(name="alunos")
    @Setter
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
public class AlunosModel {
        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        @Column
        private UUID id; //Universally Unique Identifier - Identificador Único Universal) serve para identificar registros de forma única em qualquer sistema ou banco de dados, sem o risco de colisão (duplicidade)

        @Column(nullable = false)//Significa que a coluna não permite valores nulos (equivale à restrição NOT NULL no SQL puro).
        private String nome;

        @Column(nullable = false)
        private String email;

        @OneToOne
        @JoinColumn(name = "avaliacao_fisica_id")
        private AvaliacoesFisicasModel avaliacoesFisicasModel;

        @OneToMany(mappedBy = "alunosModel") //a classe/tabela TreinosModel, contem o aluno que é o "private AlunosModel aluno"
        private Set<TreinosModel> treinos = new HashSet<>();//Set<TreinosModel>: É uma coleção (parecida com uma List) que guarda vários treinos de um mesmo aluno, mas não permite treinos repetidos na lista.

    }

