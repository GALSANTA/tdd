package com.fiscal.app;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Main App.
 * 
 * @author Fernando Marques.
 *
 */

public class App {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while (choice != 2) {
            clearScreen();
            System.out.println("-- Gerador de Nota Fiscal --\n");
            System.out.println("1. Adicionar fatura");
            System.out.println("2. Sair \n");
            System.out.print("Escolha uma opção: ");

            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        clearScreen();
                        Fatura f = addFatura(scanner);
                        break;
                    case 2:
                        System.out.println("Saindo");
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                        break;
                }
            } else {
                System.out.println("Entrada inválida. Por favor, insira um número.");
                scanner.nextLine();
            }
        }
        scanner.close();
    }

    private static Fatura addFatura(Scanner scanner) {

        System.out.println("\n-- Adicionando fatura --\n");
        System.out.print("\nNome: ");
        String nome = scanner.next();
        scanner.nextLine();

        System.out.print("\nEndereco: ");
        String endereco = scanner.next();
        scanner.nextLine();

        System.out.println("\nTipo de Servico");
        System.out.println("1. CONSULTORIA");
        System.out.println("2. TREINAMENTO");
        System.out.println("3. OUTRO");
        System.out.print("Servico: ");
        TipoServico servico;
        int escolha = scanner.nextInt();
        scanner.nextLine();

        if (escolha == 1) servico = TipoServico.CONSULTORIA;
        else if (escolha == 2) servico = TipoServico.TREINAMENTO;
        else servico = TipoServico.OUTRO;
       
        System.out.print("\nValor: $ ");
        BigDecimal valor = scanner.nextBigDecimal();

        return Fatura.criarFatura(nome, endereco, servico, valor);
    }

    private static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
