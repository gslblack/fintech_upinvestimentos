package br.com.upinvestimentos.javabeans;

import java.util.Scanner;

public class AplicacaoTransacao {

    public static void main(String[] args) {
        Transacoes trans = new Transacoes();

        // Criando um Scanner para receber entrada do usuário
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Digite o valor da sua transação:");
            double valorTransacao = scanner.nextDouble();
            trans.setValor(valorTransacao);

            System.out.println("Qual o tipo da conta usada? Corrente ou poupança?");
            String tipoConta = scanner.next();
            trans.setTipoConta(tipoConta);

            System.out.println("Descreva em detalhes:");
            // Lendo a descrição da transação
            String descricaoTransacao = scanner.nextLine(); // Consumir a quebra de linha pendente
            descricaoTransacao = scanner.nextLine(); // Ler a descrição da transação
            trans.setDescricao(descricaoTransacao);

            System.out.println("Sua transação foi registrada!");

            // Exibindo os detalhes da transação registrada
            System.out.println("Valor registrado: " + trans.getValor());
            System.out.println("Tipo registrado: " + trans.getTipoConta());
            System.out.println("Descrição: " + trans.getDescricao());
        }
    }

    public static class Transacoes {
        private double valor;
        private String tipoConta;
        private String descricao;

        // Métodos para configurar os valores da transação
        public void setValor(double valor) {
            this.valor = valor;
        }

        public void setTipoConta(String tipoConta) {
            this.tipoConta = tipoConta;
        }

        public void setDescricao(String descricao) {
            this.descricao = descricao;
        }

        // Métodos para obter os valores da transação
        public double getValor() {
            return this.valor;
        }

        public String getTipoConta() {
            return this.tipoConta;
        }

        public String getDescricao() {
            return this.descricao;
        }
    }
}
