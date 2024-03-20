package com.gerenciador.app.functionalTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.gerenciador.app.Gerenciador;
import com.gerenciador.app.Prioridade;
import com.gerenciador.app.Tarefa;

public class GerenciadorTest {
    private Date data;
    private Date novaData;
    private Tarefa tarefa1;
    private Gerenciador gerenciador1;

    @Before
    public void setUp() {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        try {
            data = formato.parse("01/01/2024");
            novaData = formato.parse("02/03/2024");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        tarefa1 = new Tarefa(data, "Tarefa1", "descrição1", Prioridade.MEDIA);
        gerenciador1 = new Gerenciador();
        gerenciador1.adicionaTarefa(tarefa1);
    }

    @Test
    public void testAtualizaTodosOsCampos()
    {
        gerenciador1.atualizaTituloTarefa(1, "Tarefa Atualizada");
        gerenciador1.atualizaDataTarefa(1, novaData);
        gerenciador1.atualizaPrioridade(1, Prioridade.ALTA);
        gerenciador1.atualizaDescricao(1, "nova descrição");
        assertEquals(gerenciador1.tarefas.get(0).getTitulo(), "Tarefa Atualizada");
        assertEquals(gerenciador1.tarefas.get(0).getDataDeVencimento(), novaData);
        assertEquals(gerenciador1.tarefas.get(0).getPrioridade(), Prioridade.ALTA);
        assertEquals(gerenciador1.tarefas.get(0).getDescricao(), "nova descrição");
    }

    @Test
    public void testAtualizaTituloDataPrioridade()
    {
        gerenciador1.atualizaTituloTarefa(1, "Tarefa Atualizada");
        gerenciador1.atualizaDataTarefa(1, novaData);
        gerenciador1.atualizaPrioridade(1, Prioridade.ALTA);
        assertEquals(gerenciador1.tarefas.get(0).getTitulo(), "Tarefa Atualizada");
        assertEquals(gerenciador1.tarefas.get(0).getDataDeVencimento(), novaData);
        assertEquals(gerenciador1.tarefas.get(0).getPrioridade(), Prioridade.ALTA);
    }
    
    @Test
    public void testAtualizaTituloDataDescricao()
    {
        gerenciador1.atualizaTituloTarefa(1, "Tarefa Atualizada");
        gerenciador1.atualizaDataTarefa(1, novaData);
        gerenciador1.atualizaDescricao(1, "nova descrição");
        assertEquals(gerenciador1.tarefas.get(0).getTitulo(), "Tarefa Atualizada");
        assertEquals(gerenciador1.tarefas.get(0).getDataDeVencimento(), novaData);
        assertEquals(gerenciador1.tarefas.get(0).getDescricao(), "nova descrição");
    }

    @Test
    public void testAtualizaTituloData()
    {
        gerenciador1.atualizaTituloTarefa(1, "Tarefa Atualizada");
        gerenciador1.atualizaDataTarefa(1, novaData);
        assertEquals(gerenciador1.tarefas.get(0).getTitulo(), "Tarefa Atualizada");
        assertEquals(gerenciador1.tarefas.get(0).getDataDeVencimento(), novaData);
    }

    @Test
    public void testAtualizaTituloPrioridadeDescricao()
    {
        gerenciador1.atualizaTituloTarefa(1, "Tarefa Atualizada");
        gerenciador1.atualizaPrioridade(1, Prioridade.ALTA);
        gerenciador1.atualizaDescricao(1, "nova descrição");
        assertEquals(gerenciador1.tarefas.get(0).getTitulo(), "Tarefa Atualizada");
        assertEquals(gerenciador1.tarefas.get(0).getPrioridade(), Prioridade.ALTA);
        assertEquals(gerenciador1.tarefas.get(0).getDescricao(), "nova descrição");
    }

    @Test
    public void testAtualizaTituloPrioridade()
    {
        gerenciador1.atualizaTituloTarefa(1, "Tarefa Atualizada");
        gerenciador1.atualizaPrioridade(1, Prioridade.ALTA);
        assertEquals(gerenciador1.tarefas.get(0).getTitulo(), "Tarefa Atualizada");
        assertEquals(gerenciador1.tarefas.get(0).getPrioridade(), Prioridade.ALTA);
    }

    @Test
    public void testAtualizaTituloDescricao()
    {
        gerenciador1.atualizaTituloTarefa(1, "Tarefa Atualizada");
        gerenciador1.atualizaDescricao(1, "nova descrição");
        assertEquals(gerenciador1.tarefas.get(0).getTitulo(), "Tarefa Atualizada");
        assertEquals(gerenciador1.tarefas.get(0).getDescricao(), "nova descrição");
    }

    @Test
    public void testAtualizaTitulo()
    {
        gerenciador1.atualizaTituloTarefa(1, "Tarefa Atualizada");
        assertEquals(gerenciador1.tarefas.get(0).getTitulo(), "Tarefa Atualizada");
    }

    @Test
    public void testAtualizaDataPrioridadeDescricao()
    {
        gerenciador1.atualizaDataTarefa(1, novaData);
        gerenciador1.atualizaPrioridade(1, Prioridade.ALTA);
        gerenciador1.atualizaDescricao(1, "nova descrição");
        assertEquals(gerenciador1.tarefas.get(0).getDataDeVencimento(), novaData);
        assertEquals(gerenciador1.tarefas.get(0).getPrioridade(), Prioridade.ALTA);
        assertEquals(gerenciador1.tarefas.get(0).getDescricao(), "nova descrição");
    }

    @Test
    public void testAtualizaDataPrioridade()
    {
        gerenciador1.atualizaDataTarefa(1, novaData);
        gerenciador1.atualizaPrioridade(1, Prioridade.ALTA);
        assertEquals(gerenciador1.tarefas.get(0).getDataDeVencimento(), novaData);
        assertEquals(gerenciador1.tarefas.get(0).getPrioridade(), Prioridade.ALTA);
    }

    @Test
    public void testAtualizaDataDescricao()
    {
        gerenciador1.atualizaDataTarefa(1, novaData);
        gerenciador1.atualizaDescricao(1, "nova descrição");
        assertEquals(gerenciador1.tarefas.get(0).getDataDeVencimento(), novaData);
        assertEquals(gerenciador1.tarefas.get(0).getDescricao(), "nova descrição");
    }

    @Test
    public void testAtualizaData()
    {
        gerenciador1.atualizaDataTarefa(1, novaData);
        assertEquals(gerenciador1.tarefas.get(0).getDataDeVencimento(), novaData);
    }

    @Test
    public void testAtualizaPrioridadeDescricao()
    {
        gerenciador1.atualizaPrioridade(1, Prioridade.ALTA);
        gerenciador1.atualizaDescricao(1, "nova descrição");
        assertEquals(gerenciador1.tarefas.get(0).getPrioridade(), Prioridade.ALTA);
        assertEquals(gerenciador1.tarefas.get(0).getDescricao(), "nova descrição");
    }

    @Test
    public void testAtualizaPrioridade()
    {
        gerenciador1.atualizaPrioridade(1, Prioridade.ALTA);
        assertEquals(gerenciador1.tarefas.get(0).getPrioridade(), Prioridade.ALTA);
    }

    @Test
    public void testAtualizaDescricao()
    {
        gerenciador1.atualizaDescricao(1, "nova descrição");
        assertEquals(gerenciador1.tarefas.get(0).getDescricao(), "nova descrição");
    }
}
