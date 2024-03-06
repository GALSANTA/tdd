package com.gerenciador.app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        Gerenciador gerenciador = new Gerenciador();
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while (choice != 5) {
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
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        System.out.println("\nTitulo da Tarefa: ");
                        String titulo = scanner.nextLine();
                        System.out.println("\nData de vencimento da tarefa: formato (dd/MM/yyyy)");
                        String data = scanner.nextLine();
                        System.out.println("\nPrioridade da tarefa: formato (ALTA, MEDIA, BAIXA)");
                        String prioridade = scanner.nextLine();
                        System.out.println("\nDescrição da tarefa: ");
                        String descricao = scanner.nextLine();
                        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                        Date dataFormatada = new Date();
                        try {
                            dataFormatada = formato.parse(data);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        Tarefa novaTarefa = new Tarefa(dataFormatada, titulo, descricao, stringToPrioridade(prioridade));
                        gerenciador.adicionaTarefa(novaTarefa);
                        System.out.println("\nPressione Enter!");
                        scanner.nextLine();
                        break;
                    case 2:
                        System.out.println("Que tarefa deseja atualizar? (número da tarefa)");
                        int tarefaId = scanner.nextInt();
                        System.out.println("O que deseja modificar na tarefa?: (Titulo, Data, Prioridade, Descricao) ");
                        scanner.nextLine();
                        String mudanca = scanner.nextLine();

                        if(mudanca.equalsIgnoreCase("Titulo")){
                            System.out.println("Qual será o novo titulo?");
                            String novoTitulo = scanner.nextLine();
                            gerenciador.atualizaTituloTarefa(tarefaId, novoTitulo);
                        }else if(mudanca.equalsIgnoreCase("Descricao")){
                            System.out.println("Qual será a nova descrição?");
                            String novaDescricao = scanner.nextLine();
                            gerenciador.atualizaDescricao(tarefaId, novaDescricao);
                        }else if(mudanca.equalsIgnoreCase("Prioridade")){
                            System.out.println("Qual será a nova prioridade? (ALTA, MEDIA, BAIXA)");
                            String novaPrioridade = scanner.nextLine();
                            gerenciador.atualizaPrioridade(tarefaId, stringToPrioridade(novaPrioridade));
                        }else if(mudanca.equalsIgnoreCase("Data")){
                            System.out.println("Qual será a nova Data? (dd/MM/yyyy)");
                            String novaData = scanner.nextLine();
                            Date novaDataFormatada = new Date();
                            SimpleDateFormat novoFormato = new SimpleDateFormat("dd/MM/yyyy");
                            try {
                                novaDataFormatada = novoFormato.parse(novaData);
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }
                            gerenciador.atualizaDataTarefa(tarefaId, novaDataFormatada);
                        }else{
                            System.out.println("Essa não é um opção válida!");
                        }
                        System.out.println("\nPressione Enter!");
                        scanner.nextLine(); 
                        break;
                    case 3:
                        System.out.println("\nQue terefa deseja remover? (número da tarefa)");
                        int tarefaID = scanner.nextInt();
                        gerenciador.removerTarefa(tarefaID);
                        System.out.println("\nPressione Enter!");
                        scanner.nextLine(); 
                        break;
                    case 4:
                        System.out.println(gerenciador.listaTarefas());
                        System.out.println("\nPressione Enter!");
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

    public static Prioridade stringToPrioridade(String prioridade){
        Prioridade result = Prioridade.BAIXA;
        if(prioridade.equalsIgnoreCase("ALTA")){
            result = Prioridade.ALTA;
        }else if(prioridade.equalsIgnoreCase("MEDIA")){
            result = Prioridade.MEDIA;
        }else if(prioridade.equalsIgnoreCase("BAIXA")){
            result = Prioridade.BAIXA;
        }
        
        return result;
    }
}
