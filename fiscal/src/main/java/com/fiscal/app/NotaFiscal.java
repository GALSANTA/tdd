package com.fiscal.app;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Um classe que encapsula as caracteristicas de Nota Fiscal.
 * 
 * @author Fernando Marques.
 *
 */

public class NotaFiscal {

    private String cliente;
    private BigDecimal valor;
    private BigDecimal imposto;

    private NotaFiscal(String cliente, BigDecimal valor, BigDecimal imposto) {
        this.cliente = cliente;
        this.valor = valor;
        this.imposto = imposto;
    }

    @Override
    public String toString() {
        return "NotaFiscal [cliente=" + cliente + ", valor=" + valor + ", imposto=" + imposto + "]";
    }

    public static NotaFiscal criarNotaFiscal(Fatura fatura) throws IllegalArgumentException {
        if (fatura == null) {
            throw new IllegalArgumentException("ERRO: Fatura nao pode ser nula");
        }
        return new NotaFiscal(
            fatura.getNome(),
            fatura.getValor() ,
            fatura.getServico().imposto().calcularImposto(fatura.getValor()).setScale(2, RoundingMode.HALF_EVEN)
        );
    }
}