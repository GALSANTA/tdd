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
    private Tarefa tarefa1;

    @Before
    public void setUp() {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        try {
            data = formato.parse("01/01/2024");
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        tarefa1 = new Tarefa(data, "Tarefa1", "descrição1", Prioridade.MEDIA);
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
}
