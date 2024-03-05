package com.gerenciador.app;

import java.util.Date;

public class Tarefa {

    public Date dataDeVencimento;
    public String titulo;
    public String descricao;
    public Prioridade prioridade;

    public Tarefa(Date dataDeVencimento, String titulo, String descricao, Prioridade prioridade){
        this.dataDeVencimento = dataDeVencimento;
        this.titulo = titulo;
        this.descricao = descricao;
        this.prioridade = prioridade;
    }
    
    public Date getDataDeVencimento() {
        return dataDeVencimento;
    }

    public String getTitulo() {
        return titulo;
    }

}
