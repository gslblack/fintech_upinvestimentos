package br.com.upinvestimentos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.upinvestimentos.model.ControleGastosEntradasModel;

public class GastosEntradasDAO {
	private Connection conexao = null;
	private int cdTransacao;// Código da transação
	private double valorEntrada;// Valor da entrada
	private String descricaoEntrada; // Descrição da entrada de valores

	// List para receber valores da nova transacao
	private List<ControleGastosEntradasModel> listNovaTransacao;

	public GastosEntradasDAO(int cdTransacao, Double valorEntrada, String descricaoEntrada) {
		this.cdTransacao = cdTransacao;
		this.valorEntrada = valorEntrada;
		this.setDescricaoEntrada(descricaoEntrada);
	}

	public GastosEntradasDAO() {

	}

	public List<GastosEntradasDAO> getAll() {
		List<GastosEntradasDAO> lista = new ArrayList<GastosEntradasDAO>();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conexao = ConexaoOracle.realizarConexao();
			stmt = conexao.prepareStatement("SELECT * FROM T_CTRL_GASTO_ENTRADA"); // CD_TRANSACAO, VL_CRTL_SALDO,
																						// CD_USER
			rs = stmt.executeQuery();

			// Percorre todos os registros encontrados
			while (rs.next()) {
				int numTransacoes = rs.getInt("CD_TRANSACAO");
				Double valorEntradas = rs.getDouble("VL_VL_ENTRADA");
				String descricaoEntradas = rs.getString("DS_ENTRADA");

				// Cria um objeto novoEntrasa com as informações encontradas
				GastosEntradasDAO novoEntrada = new GastosEntradasDAO(numTransacoes, valorEntradas, descricaoEntradas);
				lista.add(novoEntrada);

			}
		} catch (SQLException e) {
			if (e.getErrorCode() == 942) {
				System.out.printf("Tabela inexistente!", e);
			}
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				rs.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return lista;
	}

	/*
	 * // Inserir um novo produto public void
	 * inserirEntradaGastos(ControleGastosEntradasModel entradaGastos) {
	 * entradaGastos.setValorEntrada (valorEntradas);
	 * entradaGastos.setDescricaoEntrada(descricaoEntradas);
	 * entradaGastos.setValorEntrada(ControleGastosServlet.des);
	 * entradaGastos.set;//(novoId); listNovaTransacao.add(entradaGastos); }
	 */

	// Método para adicionar uma entrada de gasto (receita)
    public void inserirEntradaGasto(ControleGastosEntradasModel entrada) throws SQLException {
        PreparedStatement stmt = null;
        try {
            conexao = ConexaoOracle.realizarConexao();
            String sql = "INSERT INTO tabela_entradas (descricao, valor) VALUES (?, ?)";
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, entrada.getDescricaoEntrada());
            stmt.setDouble(2, entrada.getValorEntrada());
            // Defina outros parâmetros, se necessário
            
            stmt.executeUpdate();
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            if (conexao != null) {
                conexao.close();
            }
        }
    }
    
 // Método para listar todas as entradas de gastos (receitas)
    public List<ControleGastosEntradasModel> listarEntradas() throws SQLException {
        List<ControleGastosEntradasModel> entradas = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            conexao = ConexaoOracle.realizarConexao();
            String sql = "SELECT * FROM tabela_entradas";
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
            	ControleGastosEntradasModel entrada = new ControleGastosEntradasModel();
               // entrada.setId(rs.getInt("id"));
                entrada.setDescricaoEntrada(rs.getString("descricao"));
                entrada.setValorEntrada(rs.getDouble("valor"));
                // Defina outros atributos, se necessário
                
                entradas.add(entrada);
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conexao != null) {
                conexao.close();
            }
        }
        
        return entradas;
    }
    
    
	public int getCdTransacao() {
		// TODO Auto-generated method stub
		return cdTransacao;
	}

	public Double getValorEntrada() {
		// TODO Auto-generated method stub
		return valorEntrada;
	}

	public String getDescricaoEntrada() {
		return descricaoEntrada;
	}

	public void setDescricaoEntrada(String descricaoEntrada) {
		this.descricaoEntrada = descricaoEntrada;
	}

	public List<ControleGastosEntradasModel> getListNovaTransacao() {
		return listNovaTransacao;
	}

	public void setListNovaTransacao(List<ControleGastosEntradasModel> listNovaTransacao) {
		this.listNovaTransacao = listNovaTransacao;
	}

}
