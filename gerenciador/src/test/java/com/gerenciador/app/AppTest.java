package com.gerenciador.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{

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
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void testGetData()
    {
        assertEquals(tarefa1.getDataDeVencimento(), data);
    }

    @Test
    public void testGetTitulo()
    {
        assertEquals(tarefa1.getTitulo(), "Tarefa1");
    }

    @Test
    public void testGetDescricao()
    {
        assertEquals(tarefa1.getDescricao(), "descrição1");
    }

    @Test
    public void testGetPrioridade()
    {
        assertEquals(tarefa1.getPrioridade(), Prioridade.MEDIA);
    }

    @Test
    public void testAdicionaTarefa()
    {
        assertTrue(gerenciador1.adicionaTarefa(tarefa1));
    }

    @Test
    public void testAtualizaDataTarefa()
    {
        tarefa1.setDataDeVencimento(novaData);
        assertEquals(tarefa1.getDataDeVencimento(), novaData);
    }

    @Test
    public void testAtualizaTitulo()
    {
        tarefa1.setTitulo("Novo Titulo");
        assertEquals(tarefa1.getTitulo(), "Novo Titulo");
    }

    @Test
    public void testAtualizaDescricao()
    {
        tarefa1.setDescricao("Nova Descrição");
        assertEquals(tarefa1.getDescricao(), "Nova Descrição");
    }
}
