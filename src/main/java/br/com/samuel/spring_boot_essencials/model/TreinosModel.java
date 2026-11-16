package br.com.samuel.spring_boot_essencials.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name="treinos")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TreinosModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column
    private UUID id; //Universally Unique Identifier - Identificador Único Universal) serve para identificar registros de forma única em qualquer sistema ou banco de dados, sem o risco de colisão (duplicidade)

    @Column(nullable = false)
//Significa que a coluna não permite valores nulos (equivale à restrição NOT NULL no SQL puro).
    private String nome;

    @ManyToOne //muitos treinos para um aluno
    @JoinColumn(name = "aluno_id")
    private AlunosModel alunosModel;

    @ManyToMany
    @JoinTable(name = "treinos_exercicios", joinColumns = @JoinColumn(name = "treino_id"), inverseJoinColumns = @JoinColumn(name = "exercicio_id"))
    private Set<ExerciciosModel> exercicios = new HashSet<>();
}