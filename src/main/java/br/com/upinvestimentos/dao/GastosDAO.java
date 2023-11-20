package br.com.upinvestimentos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.upinvestimentos.model.ControleGastoGeralModel;

public class GastosDAO {
	private Connection conexaoDB;
	private int cdTransacao; // Código da transação
	private Double valorSaldo; // Saldo atual
	private int idUser;

	// List para receber valores da nova transacao
	private List<ControleGastoGeralModel> listNovaTransacao;

	public GastosDAO(int cdTransacao, Double valorSaldo, int idUser) {
		this.cdTransacao = cdTransacao;
		this.valorSaldo = valorSaldo;
		this.idUser = idUser;
	}

	public GastosDAO() {
	}

	public List<GastosDAO> getAll() {
		List<GastosDAO> lista = new ArrayList<GastosDAO>();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conexaoDB = ConexaoOracle.realizarConexao();
			stmt = conexaoDB.prepareStatement("SELECT * FROM T_CTRL_GASTO"); // CD_TRANSACAO, VL_CRTL_SALDO, CD_USER
			rs = stmt.executeQuery();

			// Percorre todos os registros encontrados
			while (rs.next()) {
				int numTransacoes = rs.getInt("CD_TRANSACAO");
				Double valorTransacoes = rs.getDouble("VL_CRTL_SALDO");
				int idUser = rs.getInt("CD_USER");

				// Cria um objeto novoUsuario com as informações encontradas
				GastosDAO novoGasto = new GastosDAO(numTransacoes, valorTransacoes, idUser);
				lista.add(novoGasto);

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
				conexaoDB.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return lista;
	}

	public int getCdTransacao() {
		// TODO Auto-generated method stub
		return cdTransacao;
	}

	public int getIdUser() {
		// TODO Auto-generated method stub
		return idUser;
	}

	public Double getValorSaldo() {
		// TODO Auto-generated method stub
		return valorSaldo;
	}

	/*
	 * // Inserir um nova trasacao public void
	 * inserirTransacao(ControleGastoGeralModel novaEntrada) { int novoCdTransacao =
	 * listNovaTransacao.size() + 1; novaEntrada.setCdTransacao(novoCdTransacao);
	 * listNovaTransacao.add(novaEntrada); }
	 */

	public void inserirGasto(ControleGastoGeralModel newInsertGeral) throws Exception {
		PreparedStatement stmt = null;

		try {
			conexaoDB = ConexaoOracle.realizarConexao();
			String sql = "INSERT INTO T_CTRL_GASTO (CD_TRANSACAO, VL_CRTL_SALDO, CD_USER) VALUES (?, ?, ?)";
			stmt = conexaoDB.prepareStatement(sql);

			stmt.setInt(1, newInsertGeral.getCdTransacao());
			stmt.setDouble(2, newInsertGeral.getValorSaldo());
			stmt.setInt(3, newInsertGeral.getItUser());

			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("Erro ao cadastrar gasto.");
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (conexaoDB != null) {
					conexaoDB.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public List<ControleGastoGeralModel> getListNovaTransacao() {
		return listNovaTransacao;
	}

	public void setListNovaTransacao(List<ControleGastoGeralModel> listNovaTransacao) {
		this.listNovaTransacao = listNovaTransacao;
	}

} // end Routine