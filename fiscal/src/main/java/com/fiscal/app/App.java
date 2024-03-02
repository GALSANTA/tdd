package com.fiscal.app;

import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {

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
                        System.out.println("\nAdicionando fatura");
                        scanner.nextLine(); 
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

    private static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }  
}
