package com.gerenciador.app;

public enum Prioridade {
    BAIXA, MEDIA, ALTA;

    public boolean comparaPrioridade(Prioridade prioridade){
        return this.ordinal() >= prioridade.ordinal();
    }

}
