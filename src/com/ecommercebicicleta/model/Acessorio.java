package com.ecommercebicicleta.model;

public class Acessorio extends Produto {
    private String categoria;

    public Acessorio(String nome, double preco, int quantidadeEmEstoque, String categoria) {
        super(nome, preco, quantidadeEmEstoque);
        this.categoria = categoria;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String toString() {
        return super.toString() + ", Categoria: " + categoria;
    }

    public String exibirDetalhes() {
        return "Acessório - " + super.toString() + ", Categoria: " + categoria;
    }
}
