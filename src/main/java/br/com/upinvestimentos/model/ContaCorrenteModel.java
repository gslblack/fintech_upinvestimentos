package br.com.upinvestimentos.model;

public class ContaCorrenteModel {

	private int cd_conta_cc; // Identificador do usuário
    private double vl_saldo_atual; // Nome do usuário
    
    	// CD_USER é FOREIN key
    // Construtor padrão sem argumentos
  	public ContaCorrenteModel() {
  		super();
  	}
    
 // Construtor com dados obrigatórios
 	public ContaCorrenteModel(int cd_conta_cc, double vl_saldo_atual) {
 		super();
 		this.cd_conta_cc = cd_conta_cc;
 		this.vl_saldo_atual = vl_saldo_atual;
 	}
    
 // Métodos de acesso para o campo usuarioId
 	public int getcd_conta_cc() {
 		return cd_conta_cc;
 	}

 	public void setcd_conta_cc(int cd_conta_cc) {
 		this.cd_conta_cc = cd_conta_cc;
 	}

     // Métodos de acesso para o campo nome
 	public Double getvl_saldo_atual() {
 		return vl_saldo_atual;
 	}

 	public void setvl_saldo_atual(Double nm_user, double vl_saldo_atual) {
 		this.vl_saldo_atual = vl_saldo_atual;
 	}

}
