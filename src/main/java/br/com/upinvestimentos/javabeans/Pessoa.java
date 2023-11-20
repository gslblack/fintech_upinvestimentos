package br.com.upinvestimentos.javabeans;

import java.io.Serializable;

public class Pessoa implements Serializable {

    // Identificador para serialização
    private static final long serialVersionUID = 1L;

    // Atributos da classe Pessoa
    String nome;
    private int rg;
    private int cpf;
    private String DtNascimento;
    private String email;
    private String senha;
    private int agencia;
    private int numero;

    // Construtor padrão
    public Pessoa() {
    }

    // Construtor com parâmetros para inicializar todos os campos da classe
    public Pessoa(String nome, int rg, int cpf, String DtNascimento, String email, String senha, int agencia,
            int numero) {
        this.nome = nome;
        this.rg = rg;
        this.cpf = cpf;
        this.DtNascimento = DtNascimento;
        this.email = email;
        this.senha = senha;
        this.agencia = agencia;
        this.numero = numero;
    }

    // Métodos getters e setters para acessar e modificar os campos da classe
    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // Método para exibir informações de uma pessoa
    public void exibirInformacoes() {
        System.out.println("Nome: " + this.nome);
        System.out.println("RG: " + this.rg);
        System.out.println("CPF: " + this.cpf);
        System.out.println("Data de Nascimento: " + this.DtNascimento);
        System.out.println("E-mail: " + this.email);
        System.out.println("Senha: " + this.senha);
        System.out.println("Agência: " + this.agencia);
        System.out.println("Número: " + this.numero);
    }
}
