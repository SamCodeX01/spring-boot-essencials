package br.com.samuel.spring_boot_essencials.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;

import java.math.BigDecimal;

@Entity
@Table(name="avaliacoes_fisicas")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AvaliacoesFisicasModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column
    private UUID id; //Universally Unique Identifier - Identificador Único Universal) serve para identificar registros de forma única em qualquer sistema ou banco de dados, sem o risco de colisão (duplicidade)
    @Column(nullable = false)//Significa que a coluna não permite valores nulos (equivale à restrição NOT NULL no SQL puro).
    private BigDecimal peso;
    @Column(nullable = false)
    private BigDecimal altura;
    @Column(name = "porcentagem_gordura_corporal", nullable = false)
    private BigDecimal porcentagemGorduraCorporal;
}
