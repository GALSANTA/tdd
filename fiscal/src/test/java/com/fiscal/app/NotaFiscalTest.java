package com.fiscal.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NotaFiscalTest {

    private NotaFiscal notaFiscal;
    private String msg;
	private Exception exception;

	@BeforeEach
	void criarNotaFiscal() {
        Fatura fatura = Fatura.criarFatura("Nando", "Rua A", TipoServico.CONSULTORIA, new BigDecimal(100));
        this.notaFiscal = NotaFiscal.criarNotaFiscal(fatura);
    }

    @Test
	void toStringTest() {
		msg = "NotaFiscal [cliente=Nando, valor=100, imposto=25.00]";
		assertEquals(msg, this.notaFiscal.toString());
	}

    @Test
	void faturaNula() {
        exception = assertThrows(IllegalArgumentException.class, ()->{
			NotaFiscal.criarNotaFiscal(null);
		});
		assertEquals(exception.toString(), "java.lang.IllegalArgumentException: ERRO: Fatura nao pode ser nula");
	}
}