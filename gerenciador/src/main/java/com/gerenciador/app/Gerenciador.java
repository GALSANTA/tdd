package com.gerenciador.app;

import java.util.ArrayList;
import java.util.Date;

public class Gerenciador {

    public ArrayList<Tarefa> tarefas;
    
    public Gerenciador(){
        tarefas = new ArrayList<Tarefa>();
    }

    public boolean adicionaTarefa(Tarefa tarefa){
        Date dataNovaTarefa = tarefa.getDataDeVencimento();
        Prioridade prioridadeNovaTarefa = tarefa.getPrioridade();
        for(int i = 0; i < tarefas.size(); i++){

            int comparaDatas = dataNovaTarefa.compareTo(tarefas.get(i).getDataDeVencimento());
            Boolean prioridadeNovaMaior = prioridadeNovaTarefa.comparaPrioridade(tarefas.get(i).getPrioridade());

            if(comparaDatas < 0 || prioridadeNovaMaior){
                tarefas.add(i, tarefa);
                break;
            }
        }
        if(!tarefas.contains(tarefa)){
            tarefas.add(tarefa);
        }

        return tarefas.contains(tarefa);
    }

    public boolean removerTarefa(Integer tarefaID){
        tarefaID -= 1;
        Boolean response = false;
        try {
            tarefas.remove(tarefaID);
            response = true;
        } catch (Exception e) {
            System.err.println(e);
        }
        return response;
    }

    public String listaTarefas(){
        String tarefasString = "Tarefas: \n";

        for(int i = 0; i < tarefas.size(); i++){
            tarefasString += "Tarefa " + Integer.toString(i+1) + "\n" + tarefas.get(i).toString();
        }

        return tarefasString;
    }

    public void atualizaDataTarefa(int tarefaID, Date novaData){
        tarefas.get(tarefaID - 1).setDataDeVencimento(novaData);
    }

    public void atualizaTituloTarefa(int tarefaID, String novoTitulo){
        tarefas.get(tarefaID - 1).setTitulo(novoTitulo);
    }
    
    public void atualizaPrioridade(int tarefaID, Prioridade novaPrioridade){
        tarefas.get(tarefaID - 1).setPrioridade(novaPrioridade);
    }

}
