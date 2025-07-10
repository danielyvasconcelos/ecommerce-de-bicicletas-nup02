package com.ecommercebicicleta.model;

public class Bicicleta extends Produto {
    private String tipo;
    private String tamanhoQuadro;

    public Bicicleta(String nome, double preco, int quantidadeEmEstoque, String tipo, String tamanhoQuadro) {
        super(nome, preco, quantidadeEmEstoque);
        this.tipo = tipo;
        this.tamanhoQuadro = tamanhoQuadro;
    }

    public String getTipo() {
        return tipo;
    }

    public String getTamanhoQuadro() {
        return tamanhoQuadro;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setTamanhoQuadro(String tamanhoQuadro) {
        this.tamanhoQuadro = tamanhoQuadro;
    }

    public String toString() {
        return super.toString() + ", Tipo: " + tipo + ", Quadro: " + tamanhoQuadro;
    }

    public String exibirDetalhes() {
        return "Bicicleta - " + super.toString() + ", Tipo: " + tipo + ", Quadro: " + tamanhoQuadro;
    }

    public void adicionarEstoque(int quantidade) {
        this.quantidadeEmEstoque += quantidade;
        System.out.println("Adicionadas " + quantidade + " unidades de " + this.nome + " ao estoque.");
    }

    public void adicionarEstoque(int quantidade, boolean confirmacao ){
        if (confirmacao) {
            this.quantidadeEmEstoque += quantidade;
        } else {
            adicionarEstoque(quantidade);
        }
    }
}