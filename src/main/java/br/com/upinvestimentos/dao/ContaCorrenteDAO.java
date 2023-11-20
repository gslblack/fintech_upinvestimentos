package br.com.upinvestimentos.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.upinvestimentos.model.ContaCorrenteModel;


public class ContaCorrenteDAO {

	
	private List<ContaCorrenteModel> ContasCorrentes;
	
	public ContaCorrenteDAO() {
		ContasCorrentes = new ArrayList<>();
	}
	
	
	 // Listar todos as contas correntes
    public List<ContaCorrenteModel> listarContasCorrentes() {
        return ContasCorrentes;
    }

  	
	
	
	
}
