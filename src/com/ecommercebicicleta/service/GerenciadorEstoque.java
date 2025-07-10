package com.ecommercebicicleta.service;

import com.ecommercebicicleta.model.Produto;
import java.util.ArrayList;
import java.util.Iterator; //interface
import java.util.List;

public class GerenciadorEstoque implements EstoqueGerenciavel {
    private List<Produto> produtos;

    public GerenciadorEstoque() {
        this.produtos = new ArrayList<>();
    }


    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
        System.out.println("Produto '" + produto.getNome() + "' adicionado ao estoque.");
    }

    public List<Produto> listarProdutos() {
        return new ArrayList<>(produtos);
    }

    public void removerProduto(String nomeProduto) {
        Iterator<Produto> iterator = produtos.iterator();
        boolean removido = false;
        while (iterator.hasNext()) {
            Produto produto = iterator.next();
            if (produto.getNome().equalsIgnoreCase(nomeProduto)) {
                iterator.remove();
                removido = true;
                System.out.println("Produto '" + nomeProduto + "' removido do estoque.");
                break;
            }
        }
        if (!removido) {
            System.out.println("Produto '" + nomeProduto + "' não encontrado no estoque.");
        }
    }

    public Produto buscarProduto(String nomeProduto) {
        for (Produto produto : produtos) {
            if (produto.getNome().equalsIgnoreCase(nomeProduto)) {
                return produto;
            }
        }
        return null;
    }
}