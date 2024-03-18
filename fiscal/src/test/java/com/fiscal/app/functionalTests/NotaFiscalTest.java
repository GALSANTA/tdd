package com.fiscal.app.functionalTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import com.fiscal.app.Fatura;
import com.fiscal.app.NotaFiscal;
import com.fiscal.app.TipoServico;

public class NotaFiscalTest {

    private NotaFiscal notaFiscal;
    private String msg;
	private Exception exception;
    private Fatura fatura;

    @Test
	void normalConsultoria() {
        msg = "NotaFiscal [cliente=Nando, valor=100, imposto=25.00]";
        fatura = Fatura.criarFatura("Nando", "Rua A", TipoServico.CONSULTORIA, new BigDecimal(100));
        this.notaFiscal = NotaFiscal.criarNotaFiscal(fatura);
        assertEquals(msg, this.notaFiscal.toString());
	}

    @Test
	void flutuanteConsultoria() {
        msg = "NotaFiscal [cliente=Nando, valor=1.5, imposto=0.38]";
        fatura = Fatura.criarFatura("Nando", "Rua A", TipoServico.CONSULTORIA, new BigDecimal(1.5));
        this.notaFiscal = NotaFiscal.criarNotaFiscal(fatura);
        assertEquals(msg, this.notaFiscal.toString());
	}

    @Test
	void minimoConsultoria() {
        msg = "NotaFiscal [cliente=Nando, valor=1, imposto=0.25]";
        fatura = Fatura.criarFatura("Nando", "Rua A", TipoServico.CONSULTORIA, new BigDecimal(1));
        this.notaFiscal = NotaFiscal.criarNotaFiscal(fatura);
        assertEquals(msg, this.notaFiscal.toString());
	}

    @Test
	void negativoConsultoria() {
        exception = assertThrows(IllegalArgumentException.class, ()->{
        fatura = Fatura.criarFatura("Nando", "Rua A", TipoServico.CONSULTORIA, new BigDecimal(-1));
			NotaFiscal.criarNotaFiscal(fatura);
		});
		assertEquals(exception.toString(), "java.lang.IllegalArgumentException: ERRO: Valor negativo");
    }

    @Test
	void zeroConsultoria() {
        exception = assertThrows(IllegalArgumentException.class, ()->{
        fatura = Fatura.criarFatura("Nando", "Rua A", TipoServico.CONSULTORIA, new BigDecimal(0));
			NotaFiscal.criarNotaFiscal(fatura);
		});
		assertEquals(exception.toString(), "java.lang.IllegalArgumentException: ERRO: Valor zero");
    }

    @Test
	void normalTreinamento() {
        msg = "NotaFiscal [cliente=Nando, valor=100, imposto=15.00]";
        fatura = Fatura.criarFatura("Nando", "Rua A", TipoServico.TREINAMENTO, new BigDecimal(100));
        this.notaFiscal = NotaFiscal.criarNotaFiscal(fatura);
        assertEquals(msg, this.notaFiscal.toString());
	}

    @Test
	void flutuanteTreinamento() {
        msg = "NotaFiscal [cliente=Nando, valor=1.5, imposto=0.22]";
        fatura = Fatura.criarFatura("Nando", "Rua A", TipoServico.TREINAMENTO, new BigDecimal(1.5));
        this.notaFiscal = NotaFiscal.criarNotaFiscal(fatura);
        assertEquals(msg, this.notaFiscal.toString());
	}

    @Test
	void minimoTreinamento() {
        msg = "NotaFiscal [cliente=Nando, valor=1, imposto=0.15]";
        fatura = Fatura.criarFatura("Nando", "Rua A", TipoServico.TREINAMENTO, new BigDecimal(1));
        this.notaFiscal = NotaFiscal.criarNotaFiscal(fatura);
        assertEquals(msg, this.notaFiscal.toString());
	}

    @Test
	void negativoTreinamento() {
        exception = assertThrows(IllegalArgumentException.class, ()->{
        fatura = Fatura.criarFatura("Nando", "Rua A", TipoServico.TREINAMENTO, new BigDecimal(-1));
			NotaFiscal.criarNotaFiscal(fatura);
		});
		assertEquals(exception.toString(), "java.lang.IllegalArgumentException: ERRO: Valor negativo");
    }

    @Test
	void zeroTreinamento() {
        exception = assertThrows(IllegalArgumentException.class, ()->{
        fatura = Fatura.criarFatura("Nando", "Rua A", TipoServico.TREINAMENTO, new BigDecimal(0));
			NotaFiscal.criarNotaFiscal(fatura);
		});
		assertEquals(exception.toString(), "java.lang.IllegalArgumentException: ERRO: Valor zero");
    }

    @Test
	void normalOutro() {
        msg = "NotaFiscal [cliente=Nando, valor=100, imposto=6.00]";
        fatura = Fatura.criarFatura("Nando", "Rua A", TipoServico.OUTRO, new BigDecimal(100));
        this.notaFiscal = NotaFiscal.criarNotaFiscal(fatura);
        assertEquals(msg, this.notaFiscal.toString());
	}

    @Test
	void flutuanteOutro() {
        msg = "NotaFiscal [cliente=Nando, valor=1.5, imposto=0.09]";
        fatura = Fatura.criarFatura("Nando", "Rua A", TipoServico.OUTRO, new BigDecimal(1.5));
        this.notaFiscal = NotaFiscal.criarNotaFiscal(fatura);
        assertEquals(msg, this.notaFiscal.toString());
	}

    @Test
	void minimoOutro() {
        msg = "NotaFiscal [cliente=Nando, valor=1, imposto=0.06]";
        fatura = Fatura.criarFatura("Nando", "Rua A", TipoServico.OUTRO, new BigDecimal(1));
        this.notaFiscal = NotaFiscal.criarNotaFiscal(fatura);
        assertEquals(msg, this.notaFiscal.toString());
	}

    @Test
	void negativoOutro() {
        exception = assertThrows(IllegalArgumentException.class, ()->{
        fatura = Fatura.criarFatura("Nando", "Rua A", TipoServico.OUTRO, new BigDecimal(-1));
			NotaFiscal.criarNotaFiscal(fatura);
		});
		assertEquals(exception.toString(), "java.lang.IllegalArgumentException: ERRO: Valor negativo");
    }

    @Test
	void zeroOutro() {
        exception = assertThrows(IllegalArgumentException.class, ()->{
        fatura = Fatura.criarFatura("Nando", "Rua A", TipoServico.OUTRO, new BigDecimal(0));
			NotaFiscal.criarNotaFiscal(fatura);
		});
		assertEquals(exception.toString(), "java.lang.IllegalArgumentException: ERRO: Valor zero");
    }
}