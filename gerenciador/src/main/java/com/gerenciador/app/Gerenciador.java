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

}
