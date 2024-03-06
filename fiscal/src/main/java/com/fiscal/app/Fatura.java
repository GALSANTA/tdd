package com.fiscal.app;

import java.math.BigDecimal;

/**
 * Um classe que encapsula as caracteristicas de Fatura.
 * 
 * @author Fernando Marques.
 *
 */

public class Fatura {

    private String nome;
    private String endereco;
    private TipoServico servico;
    private BigDecimal valor;

    private Fatura(String nome, String endereco, TipoServico servico, BigDecimal valor) {
        this.nome = nome;
        this.endereco = endereco;
        this.servico = servico;
        this.valor = valor;
    }

    public Fatura() {}

    public static Fatura criarFatura(String nome, String endereco, TipoServico servico, BigDecimal valor) throws IllegalArgumentException {
        checarNuloVazio(nome, endereco, servico, valor);
        return new Fatura(nome, endereco, servico, valor);
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public TipoServico getServico() {
        return servico;
    }

    public BigDecimal getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return "Fatura [nome=" + nome + ", endereco=" + endereco + ", servico=" + servico + ", valor=" + valor + "]";
    }

    private static void checarNuloVazio(String nome, String endereco, TipoServico servico, BigDecimal valor) throws IllegalArgumentException {
        if (nome==null || endereco==null || servico==null || valor==null) {
            throw new IllegalArgumentException("ERRO: Nenhum parametro pode ser nulo");
        }
        if (nome=="" || endereco=="") {
            throw new IllegalArgumentException("ERRO: Nenhum parametro pode ser vazio");
        }
    }
}