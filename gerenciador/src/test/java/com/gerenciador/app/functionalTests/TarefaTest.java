package com.gerenciador.app.functionalTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.gerenciador.app.Prioridade;
import com.gerenciador.app.Tarefa;

public class TarefaTest 
{
    private Date data;
    private Date novaData;
    private Tarefa tarefa1;

    @Before
    public void setUp() {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        try {
            data = formato.parse("01/01/2024");
            novaData = formato.parse("02/03/2021");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        tarefa1 = new Tarefa(data, "Tarefa1", "descrição1", Prioridade.MEDIA);
    }

    @Test
    public void testCriaTarefaDataInvalida()
    {
        Tarefa tarefa2 = new Tarefa(novaData, "Tarefa2", "descrição2", Prioridade.ALTA);
        assertNull(tarefa2);
    }

    @Test
    public void testCriaTarefaPrioridadeMedia()
    {
        Tarefa tarefa2 = new Tarefa(data, "Tarefa2", "descrição2", Prioridade.MEDIA);
        assertNotNull(tarefa2);
    }

    @Test
    public void testCriaTarefaPrioridadeBaixa()
    {
        Tarefa tarefa2 = new Tarefa(novaData, "Tarefa2", "descrição2", Prioridade.BAIXA);
        assertNotNull(tarefa2);
    }

    @Test
    public void testCriaTarefaPrioridadeInvalida()
    {
        Tarefa tarefa2 = new Tarefa(novaData, "Tarefa2", "descrição2", Prioridade.MEDIA);
        assertNull(tarefa2);
    }
    


}
