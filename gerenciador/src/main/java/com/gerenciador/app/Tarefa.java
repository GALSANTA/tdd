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

    public String getDescricao() {
        return descricao;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public void setDataDeVencimento(Date dataDeVencimento) {
        this.dataDeVencimento = dataDeVencimento;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }

    @Override
    public String toString() {
        return this.titulo + "\nData de Vencimento: " + dataDeVencimento.toString() + "\nPrioridade: " + 
        prioridade.toString() + "\nDescrição: " + descricao + "\n";
    }
}
