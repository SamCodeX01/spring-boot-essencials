package br.com.samuel.spring_boot_essencials.model;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ProdutoModel {

    private Integer id;
    private String nome;
    private BigDecimal preco;
    private Integer quantidade;
}
