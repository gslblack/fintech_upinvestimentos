package br.com.upinvestimentos.model;

public class ControleGastosEntradasModel {

	
	private int cdTransacao; // Código da transação  
	private Double valorEntrada; //Saldo atual
	private String descricaoEntrada;
	
	    
	    // Construtor padrão sem argumentos
		public ControleGastosEntradasModel() {
			super();
		}
	

		// Construtor com dados obrigatórios (exceto a senha)
		public ControleGastosEntradasModel(Double valorEntrada, String descricaoEntrada) {
			super();
			this.valorEntrada = valorEntrada;
			this.descricaoEntrada = descricaoEntrada;
			
		}

		public Double getValorEntrada() {
			return valorEntrada;
		}


		public String getDescricaoEntrada() {
			return descricaoEntrada;
		}
	
		public void setValorEntrada(Double valorEntrada) {
			this.valorEntrada = valorEntrada;
		}
		
		public void setDescricaoEntrada(String descricaoEntrada) {
			this.descricaoEntrada = descricaoEntrada;
		}


		public int getCdTransacao() {
			return cdTransacao;
		}


		public void setCdTransacao(int cdTransacao) {
			this.cdTransacao = cdTransacao;
		}
}
