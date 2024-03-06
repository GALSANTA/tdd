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

    public boolean removerTarefa(int tarefaID){
        tarefaID -= 1;
        Boolean result = false;
        try {
            tarefas.remove(tarefaID);
            result = true;
        } catch (Exception e) {

        }
        return result;
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

    public void atualizaDescricao(int tarefaID, String novaDescricao){
        tarefas.get(tarefaID - 1).setDescricao(novaDescricao);
    }

}
