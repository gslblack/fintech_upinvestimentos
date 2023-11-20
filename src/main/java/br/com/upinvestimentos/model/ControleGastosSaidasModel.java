package br.com.upinvestimentos.model;

public class ControleGastosSaidasModel {

	private int cdTransacao; // Código da transação  
	private Double valorSaida; //Saldo atual
	private String descricaoSaida;
	
	    
	    // Construtor padrão sem argumentos
		public ControleGastosSaidasModel() {
			super();
		}
	

		// Construtor com dados obrigatórios (exceto a senha)
		public ControleGastosSaidasModel(Double valorSaida, String descricaoSaida) {
			super();
			this.valorSaida = valorSaida;
			this.descricaoSaida = descricaoSaida;
			
		}

		public Double getValorSaida() {
			return valorSaida;
		}


		public String getDescricaoSaida() {
			return descricaoSaida;
		}
	
		public void setValorSaida(Double valorSaida) {
			this.valorSaida = valorSaida;
		}
		
		public void setDescricaoSaida(String descricaoSaida) {
			this.descricaoSaida = descricaoSaida;
		}


		public int getCdTransacao() {
			return cdTransacao;
		}


		public void setCdTransacao(int cdTransacao) {
			this.cdTransacao = cdTransacao;
		}
	
	
}
