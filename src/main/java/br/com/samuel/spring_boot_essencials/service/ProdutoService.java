package br.com.samuel.spring_boot_essencials.service;

import br.com.samuel.spring_boot_essencials.exception.NotFoundException;
import br.com.samuel.spring_boot_essencials.model.ProdutoModel;
import dto.ProdutoDto;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoService {
    private static final List<ProdutoModel> PRODUTOS = new ArrayList<>();

        static{
            PRODUTOS.add(ProdutoModel.builder()
                .id(1)
                .nome("Notebook").
                preco(new BigDecimal(5000))
                .quantidade(10)
                .build());

            PRODUTOS.add(ProdutoModel.builder()
                .id(2)
                .nome("Iphone").
                preco(new BigDecimal(7000))
                .quantidade(10)
                .build());

            PRODUTOS.add(ProdutoModel.builder()
                .id(3)
                .nome("Mouse")
                .preco(new BigDecimal(500))
                .quantidade(10)
                .build());
    }

    public List<ProdutoModel> findAll(){
        return new ArrayList<>(PRODUTOS);
    }

    public ProdutoModel createProduct(ProdutoDto produtoDto){
        Integer identificador = PRODUTOS.stream()
                .mapToInt(ProdutoModel::getId)
                .max()
                .orElse(0) + 1;

        ProdutoModel novoProduto = ProdutoModel.builder()
                .id(identificador)
                .nome(produtoDto.getNome())
                .preco(produtoDto.getPreco())
                .quantidade(produtoDto.getQuantidade())
                .build();
        PRODUTOS.add(novoProduto);
        return novoProduto;
    }

    public ProdutoModel atualizarProduto(ProdutoDto produtoDto, Integer id) throws NotFoundException {
            ProdutoModel produto = PRODUTOS.stream()
                    .filter(p -> p.getId().equals(id))
                    .findAny()
                    .orElseThrow(() -> new NotFoundException("Produto não Encontrado!"));

            produto.setNome(produtoDto.getNome());
            produto.setPreco(produtoDto.getPreco());
            produto.setQuantidade(produtoDto.getQuantidade());

            return produto;
    }


    public void removerProdutos(Integer id){
        PRODUTOS.removeIf(p -> p.getId().equals(id));
    }

}
