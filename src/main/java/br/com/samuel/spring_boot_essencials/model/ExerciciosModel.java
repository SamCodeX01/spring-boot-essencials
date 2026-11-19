package br.com.samuel.spring_boot_essencials.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name="exercicios")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExerciciosModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column
    private UUID id; //Universally Unique Identifier - Identificador Único Universal) serve para identificar registros de forma única em qualquer sistema ou banco de dados, sem o risco de colisão (duplicidade)

    @Column(nullable = false)//Significa que a coluna não permite valores nulos (equivale à restrição NOT NULL no SQL puro).
    private String nome;

    @Column(name = "grupo_muscular",nullable = false)
    private String grupoMuscular;
}

