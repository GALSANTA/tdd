package com.gerenciador.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class GarenciadorTest {
    
    private Date data;
    private Date novaData;
    private Tarefa tarefa1;
    private Tarefa tarefa2;
    private Gerenciador gerenciador1;

    @Before
    public void setUp() {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        try {
            data = formato.parse("01/01/2024");
            novaData = formato.parse("02/03/2023");
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        tarefa1 = new Tarefa(data, "Tarefa1", "descrição1", Prioridade.MEDIA);
        tarefa2 = new Tarefa(novaData, "Tarefa1", "descrição1", Prioridade.ALTA);
        gerenciador1 = new Gerenciador();
        gerenciador1.adicionaTarefa(tarefa2);
    }

    @Test
    public void testAdicionaTarefa()
    {
        assertTrue(gerenciador1.adicionaTarefa(tarefa1));
    }

    @Test
    public void testRemoverTarefaPeloIndex()
    {
        assertTrue(gerenciador1.removerTarefa(1));
    }

    @Test
    public void testAtualizaDataTarefa(){
        gerenciador1.atualizaDataTarefa(1, data);
        assertEquals(gerenciador1.tarefas.get(0).getDataDeVencimento(), data);
    }

    @Test
    public void testAtualizaTituloTarefa(){
        gerenciador1.atualizaTituloTarefa(1, "Titulo 2");
        assertEquals(gerenciador1.tarefas.get(0).getTitulo(), "Titulo 2");
    }

    @Test
    public void testAtualizaPrioridade(){
        gerenciador1.atualizaPrioridade(1, Prioridade.BAIXA);
        assertEquals(gerenciador1.tarefas.get(0).getPrioridade(), Prioridade.BAIXA);
    }

    @Test
    public void testAtualizaDescricao(){
        gerenciador1.atualizaDescricao(1, "Descrição 2");
        assertEquals(gerenciador1.tarefas.get(0).getDescricao(), "Descrição 2");
    }
}