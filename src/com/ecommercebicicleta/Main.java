package com.ecommercebicicleta;

import com.ecommercebicicleta.model.Acessorio;
import com.ecommercebicicleta.model.Bicicleta;
import com.ecommercebicicleta.model.Produto;
import com.ecommercebicicleta.service.GerenciadorEstoque;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GerenciadorEstoque gerenciador = new GerenciadorEstoque();

        int opcao;
        do {
            exibirMenu();
            opcao = obterOpcao(scanner);

            scanner.nextLine();

            switch (opcao) {
                case 1:
                    adicionarProduto(scanner, gerenciador);
                    break;
                case 2:
                    listarProdutos(gerenciador);
                    break;
                case 3:
                    removerProduto(scanner, gerenciador);
                    break;
                case 4:
                    buscarProduto(scanner, gerenciador);
                    break;
                case 5:
                    System.out.println("Saindo do sistema. Até mais!");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção entre 1 e 5.");
                    break;
            }
            if (opcao != 5) {
                System.out.println("\nPressione Enter para continuar.");
                scanner.nextLine();
            }
        } while (opcao != 5);

        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("=== Menu do Proprietário da Loja de Bicicletas ===");
        System.out.println("1. Adicionar Novo Produto");
        System.out.println("2. Listar Todos os Produtos");
        System.out.println("3. Remover Produto Existente");
        System.out.println("4. Buscar Produto por Nome");
        System.out.println("5. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static int obterOpcao(Scanner scanner) {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Por favor, digite um número.");
            scanner.next();
            return -1;
        }
    }

    private static void adicionarProduto(Scanner scanner, GerenciadorEstoque gerenciador) {
        System.out.println("\n=== Adicionar Produto ===");
        System.out.println("Que tipo de produto você deseja adicionar?");
        System.out.println("1. Bicicleta");
        System.out.println("2. Acessório");
        System.out.print("Escolha uma opção: ");
        int tipoProduto = obterOpcao(scanner);
        scanner.nextLine();

        System.out.print("Nome do produto: ");
        String nome = scanner.nextLine();

        double preco = 0;
        boolean precoValido = false;
        while (!precoValido) {
            try {
                System.out.print("Preço do produto: R$");
                preco = scanner.nextDouble();
                if (preco < 0) {
                    System.out.println("Preço não pode ser negativo. Tente novamente.");
                } else {
                    precoValido = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida para o preço. Por favor, digite um número.");
                scanner.next();
            }
        }

        int quantidade = 0;
        boolean quantidadeValida = false;
        while (!quantidadeValida) {
            try {
                System.out.print("Quantidade em estoque: ");
                quantidade = scanner.nextInt();
                if (quantidade < 0) {
                    System.out.println("Quantidade não pode ser negativa. Tente novamente.");
                } else {
                    quantidadeValida = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida para a quantidade. Por favor, digite um número inteiro.");
                scanner.next();
            }
        }
        scanner.nextLine();

        if (tipoProduto == 1) {
            System.out.print("Tipo de bicicleta ( Mountain Bike, Speed): ");
            String tipo = scanner.nextLine();
            System.out.print("Tamanho do quadro (Ex: 17\", 19\", 20\", 21\"): ");
            String tamanhoQuadro = scanner.nextLine();
            Bicicleta novaBicicleta = new Bicicleta(nome, preco, quantidade, tipo, tamanhoQuadro);
            gerenciador.adicionarProduto(novaBicicleta);
            System.out.println(novaBicicleta.exibirDetalhes());
            if (quantidade > 0) {
                novaBicicleta.adicionarEstoque(0, true);
            }
        } else if (tipoProduto == 2) {
            System.out.print("Categoria do acessório (Ex: Capacete, Luva, Farol): ");
            String categoria = scanner.nextLine();
            Acessorio novoAcessorio = new Acessorio(nome, preco, quantidade, categoria);
            gerenciador.adicionarProduto(novoAcessorio);
            System.out.println(novoAcessorio.exibirDetalhes());
        } else {
            System.out.println("Opção de tipo de produto inválida.");
        }
    }

    private static void listarProdutos(GerenciadorEstoque gerenciador) {
        System.out.println("\n=== Produtos em Estoque ===");
        List<Produto> produtos = gerenciador.listarProdutos();
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado no estoque.");
        } else {
            for (int i = 0; i < produtos.size(); i++) {
                Produto p = produtos.get(i);
                System.out.println((i + 1) + ". " + p);
            }
        }
    }

    private static void removerProduto(Scanner scanner, GerenciadorEstoque gerenciador) {
        System.out.println("\n=== Remover Produto ===");
        System.out.print("Digite o nome do produto a ser removido: ");
        String nomeRemover = scanner.nextLine();
        gerenciador.removerProduto(nomeRemover);
    }

    private static void buscarProduto(Scanner scanner, GerenciadorEstoque gerenciador) {
        System.out.println("\n=== Buscar Produto ===");
        System.out.print("Digite o nome do produto a ser buscado: ");
        String nomeBuscar = scanner.nextLine();
        Produto produtoEncontrado = gerenciador.buscarProduto(nomeBuscar);

        if (produtoEncontrado != null) {
            System.out.println("Produto encontrado:");
            System.out.println(produtoEncontrado.exibirDetalhes());
        } else {
            System.out.println("Produto '" + nomeBuscar + "' não encontrado no estoque.");
        }
    }
}