package br.com.upinvestimentos.javabeans;

import java.util.Scanner;

public class AplicacaoPessoa {

    public static void main(String[] args) {
        // Instanciando um objeto Pessoa
        Pessoa pss = new Pessoa();

        try (Scanner scanner = new Scanner(System.in)) {
            // Captura do número da conta
            System.out.println("Digite o número da sua conta");
            String numeroConta = scanner.nextLine();
            pss.setNumeroConta(numeroConta);

            // Captura da agência
            System.out.println("Digite a sua agência");
            String agencia = scanner.nextLine();
            pss.setAgencia(agencia);
        }

        // Confirmação do registro da conta e da agência
        System.out.println("Sua conta foi registrada!");
        // Exibição do número da conta e da agência registrados
        System.out.println("Número da conta registrado: " + pss.getNumeroConta());
        System.out.println("Agência registrada: " + pss.getAgencia());
    }

    // Classe Pessoa para representar informações de conta
    public static class Pessoa {
        private String numeroConta;
        private String agencia;

        // Método para definir o número da conta
        public void setNumeroConta(String numeroConta) {
            this.numeroConta = numeroConta;
        }

        // Método para definir a agência
        public void setAgencia(String agencia) {
            this.agencia = agencia;
        }

        // Método para obter o número da conta
        public String getNumeroConta() {
            return this.numeroConta;
        }

        // Método para obter a agência
        public String getAgencia() {
            return this.agencia;
        }
    }
}

