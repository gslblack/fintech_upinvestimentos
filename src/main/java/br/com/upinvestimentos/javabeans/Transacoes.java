package br.com.upinvestimentos.javabeans;

import java.io.Serializable;

public class Transacoes implements Serializable {

    // Identificador para serialização
    private static final long serialVersionUID = 1L;

    // Atributos da classe Transacoes
    private int numTransacoes; // Número de transações
    private double valorTransacoes; // Valor das transações
    private String tipoConta; // Tipo de conta relacionada à transação
    private String descricao; // Descrição da transação

    // Construtor padrão
    public Transacoes() {

    }

    // Construtor com parâmetros para inicializar todos os campos da classe
    public Transacoes(int numTransacoes, double valorTransacoes, String tipoConta, String descricao) {
        this.numTransacoes = numTransacoes;
        this.valorTransacoes = valorTransacoes;
        this.tipoConta = tipoConta;
        this.descricao = descricao;
    }

    // Métodos getters e setters para acessar e modificar os campos da classe
    public int getNumTransacoes() {
        return numTransacoes;
    }

    public void setNumTransacoes(int numTransacoes) {
        this.numTransacoes = numTransacoes;
    }

    public double getValorTransacoes() {
        return valorTransacoes;
    }

    public void setValorTransacoes(double valorTransacoes) {
        this.valorTransacoes = valorTransacoes;
    }

    public String getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
