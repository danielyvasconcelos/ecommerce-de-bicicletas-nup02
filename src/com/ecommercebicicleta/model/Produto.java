package com.ecommercebicicleta.model;

public abstract class Produto {
    protected String nome;
    protected double preco;
    protected int quantidadeEmEstoque;

    public Produto(String nome, double preco, int quantidadeEmEstoque) {
        this.nome = nome;
        this.preco = preco;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    // getters
    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }

    // setters
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    public String toString() {
        return "Nome: " + nome + ", Preço: R$" + String.format("%.2f", preco) + ", Estoque: " + quantidadeEmEstoque;
    }


    public abstract String exibirDetalhes();
}