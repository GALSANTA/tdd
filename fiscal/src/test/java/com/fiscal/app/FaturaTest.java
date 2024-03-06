package com.fiscal.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FaturaTest {

    private Fatura fatura;
    private String msg;
	private Exception exception;

	@BeforeEach
	void criaFatura() {
        this.fatura = Fatura.criarFatura("Nando", "Rua A", TipoServico.TREINAMENTO, new BigDecimal(100.00));
	}

    @Test
	void toStringTest() {
		msg = "Fatura [nome=Nando, endereco=Rua A, servico=TREINAMENTO, valor=100]";
		assertEquals(msg, this.fatura.toString());
	}

    @Test
	void toStringNomeVaziaTest() {
        exception = assertThrows(IllegalArgumentException.class, ()->{
			Fatura.criarFatura("", "Rua A", TipoServico.TREINAMENTO, new BigDecimal(100.00));
		});
		assertEquals(exception.toString(), "java.lang.IllegalArgumentException: ERRO: Nenhum parametro pode ser vazio");
	}

	@Test
	void toStringNomeNullTest() {
        exception = assertThrows(IllegalArgumentException.class, ()->{
			Fatura.criarFatura(null, "Rua A", TipoServico.TREINAMENTO, new BigDecimal(100.00));
		});
		assertEquals(exception.toString(), "java.lang.IllegalArgumentException: ERRO: Nenhum parametro pode ser nulo");
	}

	@Test
	void toStringEnderecoVaziaTest() {
        exception = assertThrows(IllegalArgumentException.class, ()->{
			Fatura.criarFatura("Nando", "", TipoServico.TREINAMENTO, new BigDecimal(100.00));
		});
		assertEquals(exception.toString(), "java.lang.IllegalArgumentException: ERRO: Nenhum parametro pode ser vazio");
	}

	@Test
	void toStringEnderecoNullTest() {
        exception = assertThrows(IllegalArgumentException.class, ()->{
			Fatura.criarFatura("Nando", null, TipoServico.TREINAMENTO, new BigDecimal(100.00));
		});
		assertEquals(exception.toString(), "java.lang.IllegalArgumentException: ERRO: Nenhum parametro pode ser nulo");
	}

	@Test
	void toStringServicoNullTest() {
        exception = assertThrows(IllegalArgumentException.class, ()->{
			Fatura.criarFatura("Nando", "Rua A", null, new BigDecimal(100.00));
		});
		assertEquals(exception.toString(), "java.lang.IllegalArgumentException: ERRO: Nenhum parametro pode ser nulo");
	}

	@Test
	void toStringValorVaziaTest() {
        exception = assertThrows(NumberFormatException.class, ()->{
			Fatura.criarFatura("Nando", "", TipoServico.TREINAMENTO, new BigDecimal(""));
		});
		assertEquals(exception.toString(), "java.lang.NumberFormatException");
	}

	@Test
	void toStringValorNullTest() {
        exception = assertThrows(IllegalArgumentException.class, ()->{
			Fatura.criarFatura("Nando", null, TipoServico.TREINAMENTO, null);
		});
		assertEquals(exception.toString(), "java.lang.IllegalArgumentException: ERRO: Nenhum parametro pode ser nulo");
	}
}