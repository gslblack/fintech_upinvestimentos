package br.com.upinvestimentos.javabeans;

public class AplicacaoConta {

	public static void main(String[] args) {

		Conta cc = new Conta();
		cc.depositar(50.0);
		cc.setAgencia(123);
		cc.setNumero(321);
		cc.setNome("Roberto");
		cc.depositar(1000);
		cc.retirar(250);

		System.out.println(cc.getSaldo());

		Conta poupanca = new Conta(111, 222, 1000);
		poupanca.retirar(50);

		System.out.println(poupanca.getSaldo());
		
		//Utilização da herança
		System.out.println(cc.nome);

	}

}
