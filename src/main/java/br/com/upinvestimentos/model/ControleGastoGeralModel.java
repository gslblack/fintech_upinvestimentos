package br.com.upinvestimentos.model;

public class ControleGastoGeralModel {

	private int cdTransacao; // Código da transação  
	private Double valorSaldo; //Saldo atual
	private int idUser;
	    
	    // Construtor padrão sem argumentos
		public ControleGastoGeralModel() {
			super();
		}
	

		// Construtor com dados obrigatórios (exceto a senha)
		public ControleGastoGeralModel(int cdTransacao, Double valorSaldo, int idUser) {
			super();
			this.cdTransacao = cdTransacao;
			this.valorSaldo = valorSaldo;
			this.idUser = idUser;
		}


		public int getCdTransacao() {
			// TODO Auto-generated method stub
			return cdTransacao;
		}
		
		public void setCdTransacao(int cdTransacao) {
			this.cdTransacao = cdTransacao;
		}


		public int getItUser() {
			// TODO Auto-generated method stub
			return idUser;
		}


		public Double getValorSaldo() {
			// TODO Auto-generated method stub
			return valorSaldo;
		}

		
}
