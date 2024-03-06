package com.gerenciador.app;

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
    private Gerenciador gerenciador1;

    @Before
    public void setUp() {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        try {
            data = formato.parse("01/01/2024");
            novaData = formato.parse("02/03/2024");
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        tarefa1 = new Tarefa(data, "Tarefa1", "descrição1", Prioridade.MEDIA);
        gerenciador1 = new Gerenciador();
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
}