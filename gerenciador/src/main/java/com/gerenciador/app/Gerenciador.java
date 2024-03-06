package com.gerenciador.app;

import java.util.ArrayList;

public class Gerenciador {

    public ArrayList<Tarefa> tarefas;
    
    public Gerenciador(){
        tarefas = new ArrayList<Tarefa>();
    }

    public boolean adicionaTarefa(Tarefa tarefa){
        return tarefas.add(tarefa);
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

}
