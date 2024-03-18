package com.fiscal.app.functionalTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.fiscal.app.Fatura;
import com.fiscal.app.TipoServico;


public class FaturaTest {

    private Fatura fatura;
    private String msg;
	private Exception exception;


    @BeforeEach
	void criaFatura() {
        this.fatura = Fatura.criarFatura("Nando", "Rua A", TipoServico.CONSULTORIA, new BigDecimal(100.00));
	}

    @Test
	void normalTest() {
		msg = "Fatura [nome=Nando, endereco=Rua A, servico=CONSULTORIA, valor=100]";
		assertEquals(msg, this.fatura.toString());
	}

    @Test
	void grandeTest() {
		this.fatura = Fatura.criarFatura("Nando", "Rua A", TipoServico.CONSULTORIA, new BigDecimal(1000000.00));
		msg = "Fatura [nome=Nando, endereco=Rua A, servico=CONSULTORIA, valor=1000000]";
		assertEquals(msg, this.fatura.toString());
	}

    @Test
	void minimoTest() {
		this.fatura = Fatura.criarFatura("Nando", "Rua A", TipoServico.CONSULTORIA, new BigDecimal(1.00));
		msg = "Fatura [nome=Nando, endereco=Rua A, servico=CONSULTORIA, valor=1]";
		assertEquals(msg, this.fatura.toString());
	}

    @Test
	void flutuanteTest() {
		this.fatura = Fatura.criarFatura("Nando", "Rua A", TipoServico.CONSULTORIA, new BigDecimal(1.50));
		msg = "Fatura [nome=Nando, endereco=Rua A, servico=CONSULTORIA, valor=1.5]";
		assertEquals(msg, this.fatura.toString());
	}

    @Test
	void negativoTest() {
        exception = assertThrows(IllegalArgumentException.class, ()->{
			Fatura.criarFatura("Nando", "Rua A", TipoServico.CONSULTORIA, new BigDecimal(-1));
		});
		assertEquals(exception.toString(), "java.lang.IllegalArgumentException: ERRO: Valor negativo");
	}

    @Test
	void zeroTest() {
        exception = assertThrows(IllegalArgumentException.class, ()->{
			Fatura.criarFatura("Nando", "Rua A", TipoServico.CONSULTORIA, new BigDecimal(0));
		});
		assertEquals(exception.toString(), "java.lang.IllegalArgumentException: ERRO: Valor zero");
	}
}