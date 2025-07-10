package com.ecommercebicicleta.service;

import com.ecommercebicicleta.model.Produto;
import java.util.List;

public interface EstoqueGerenciavel {
    void adicionarProduto(Produto produto);
    List<Produto> listarProdutos();
    void removerProduto(String nomeProduto);
    Produto buscarProduto(String nomeProduto);
}