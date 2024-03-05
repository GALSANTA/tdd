package com.gerenciador.app;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while (choice < 5) {
            clearScreen();
            System.out.println("-- Gerenciador de Tarefas --\n");
            System.out.println("Escolha uma opção: ");
            System.out.println("1. Adicionar tarefa");
            System.out.println("2. Atualizar tarefa");
            System.out.println("3. Excluir tarefa");
            System.out.println("4. Exibir tarefa");
            System.out.println("5. Sair");

            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                //scanner.nextLine(); 

                switch (choice) {
                    case 1:
                        System.out.println("\nAdicionando tarefa");
                        scanner.nextLine(); 
                        break;
                    case 2:
                        System.out.println("\nAtualizando tarefa");
                        scanner.nextLine(); 
                        break;
                    case 3:
                        System.out.println("\nExcluindo tarefa");
                        scanner.nextLine(); 
                        break;
                    case 4:
                        System.out.println("\nExibindo tarefas");
                        scanner.nextLine();
                        break;
                    case 5:
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
