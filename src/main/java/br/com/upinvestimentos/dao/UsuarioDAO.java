package br.com.upinvestimentos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import br.com.upinvestimentos.model.UsuarioModel;

public class UsuarioDAO {
	Connection conexao = null;
	
	UsuarioModel usuarioModel = new UsuarioModel();
	
	public void UsuarioModel(int cdUsuario, String nomeUsuario, String numeroCPF, Date dataNasc, String descricaoEmail) {
		
	}

    public UsuarioDAO(int cdUsuario, String nomeUsuario, String numeroCPF, Date dataNasc, String descricaoEmail) {
    	
	}

	public UsuarioDAO() {
		
	}

	public void cadastrarUsuario(UsuarioModel usuario) throws Exception {
        
        PreparedStatement stmt = null;
		
		
//CADASTRAR USUÁRIO
        try {
            conexao = ConexaoOracle.realizarConexao();
            String sql = "INSERT INTO T_USER (cd_user, nm_user, nr_CPF, dt_nasc, ds_email) VALUES (?,?,?,?,?)";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, usuario.getCdUsuario());
            stmt.setString(2, usuario.getNomeUsuario());
            stmt.setString(3, usuario.getNumeroCPF());
            java.sql.Date dataNascimentoSql = new java.sql.Date(new java.util.Date().getTime());
            stmt.setDate(4, dataNascimentoSql);
            stmt.setString(5, usuario.getDescricaoEmail());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Erro ao cadastrar usuário.");
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
	
//REMOVER USUARIO
		public void delUsuario(UsuarioModel usuario) throws SQLException {
			PreparedStatement stmt = null;

			try {
				conexao = ConexaoOracle.realizarConexao();
				String sql = "DELETE FROM T_USER WHERE cd_user = ?";
				stmt = conexao.prepareStatement(sql);
				stmt.setInt(1, usuario.getCdUsuario()); // Primeiro parâmetro (T_USUARIO_ID_USUARIO)

				stmt.execute();

				conexao.commit(); // Confirma as alterações

			} catch (SQLException e) {
				// dar rollback em caso de exceção
				conexao.rollback();
				e.printStackTrace();
			} finally {
				try {
					stmt.close();
					conexao.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		
	////ATUALIZAR USUÁRIO
		
	public void atualizarUsuario(UsuarioModel usuario) throws SQLException {
		PreparedStatement stmt = null;
		boolean transacaoAtiva = false;
		try {
			transacaoAtiva = true;
			conexao = ConexaoOracle.realizarConexao();
			String sql = "UPDATE T_USER SET nm_user = ?, nr_CPF = ?, dt_nasc = ?, ds_email = ? WHERE cd_user = ?";
			stmt = conexao.prepareStatement(sql);

			stmt.setString(1, usuario.getNomeUsuario());
			stmt.setString(2, usuario.getNumeroCPF());
			java.sql.Date data = new java.sql.Date(new java.util.Date().getTime());
			stmt.setDate(3, data);
			stmt.setString(4, usuario.getDescricaoEmail());
			stmt.setInt(5, usuario.getCdUsuario());

			int linhasAfetadas = stmt.executeUpdate();
			if (linhasAfetadas > 0) {
	            conexao.commit();
	        } else {
	            // Caso nenhuma linha seja afetada, pode ser útil fazer um rollback
	            conexao.rollback();
	        }
		} catch (SQLException e) {
			if (transacaoAtiva) {
				conexao.rollback();
			}
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (conexao != null) {
					conexao.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
//LISTAR TODOS OS USUARIOS
	public void listarUsuarios(UsuarioModel usuario) throws SQLException {
	}
	public List<UsuarioModel> listarUsuarios() throws SQLException {
	    PreparedStatement stmt = null;
	    ResultSet resultSet = null;
	    List<UsuarioModel> usuarios = new ArrayList<>();
	    
	    try {
	        conexao = ConexaoOracle.realizarConexao();
	        String sql = "SELECT * FROM T_USER";
	        stmt = conexao.prepareStatement(sql);

	        resultSet = stmt.executeQuery();
	        
	        while (resultSet.next()) {
	            UsuarioModel usuario = new UsuarioModel();
	            usuario.setNomeUsuario(resultSet.getString("nm_user"));
	            usuario.setNumeroCPF(resultSet.getString("nr_CPF"));
	            usuario.setDescricaoEmail(resultSet.getString("ds_email"));
	            usuario.setDataNasc(resultSet.getDate("dt_nasc"));
	            usuario.setCdUser(resultSet.getInt("cd_user"));
	            	           
	            usuarios.add(usuario);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (resultSet != null) {
	                resultSet.close();
	            }
	            if (stmt != null) {
	                stmt.close();
	            }
	            if (conexao != null) {
	                conexao.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    
	    return usuarios;
	}

//LISTAR USUARIO POR ID
	public List<UsuarioModel> listarUsuariosPorCdUser(int cdUser) throws SQLException {
	    PreparedStatement stmt = null;
	    ResultSet resultSet = null;
	    List<UsuarioModel> usuarios = new ArrayList<>();
	    
	    try {
	        conexao = ConexaoOracle.realizarConexao();
	        String sql = "SELECT * FROM T_USER WHERE cd_user = ?";
	        stmt = conexao.prepareStatement(sql);
	        stmt.setInt(1, cdUser); // Define o valor do parâmetro

	        resultSet = stmt.executeQuery();
	        
	        while (resultSet.next()) {
	            UsuarioModel usuario = new UsuarioModel();
	            usuario.setNomeUsuario(resultSet.getString("nm_user"));
	            usuario.setNumeroCPF(resultSet.getString("nr_CPF"));
	            usuario.setDescricaoEmail(resultSet.getString("ds_email"));
	            usuario.setDataNasc(resultSet.getDate("dt_nasc"));
	            usuario.setCdUser(resultSet.getInt("cd_user"));
	            
	            usuarios.add(usuario);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (resultSet != null) {
	                resultSet.close();
	            }
	            if (stmt != null) {
	                stmt.close();
	            }
	            if (conexao != null) {
	                conexao.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    
	    return usuarios;
	}
	
	
	
	// Método para autenticar o usuário com base no login e senha
		public boolean autenticarUsuario(String emailUsuario, String senha) {
			PreparedStatement stmt = null;
			ResultSet resultSet = null;

			try {
				conexao = ConexaoOracle.realizarConexao();
				String sql = "SELECT * FROM T_USER WHERE nm_user = ? AND senha = ?"; // Adaptar para a tabela caso os nomes
																						// não batam!!!
				stmt = conexao.prepareStatement(sql);
				stmt.setString(1, emailUsuario);
				stmt.setString(2, senha);

				resultSet = stmt.executeQuery();

				// Se estiver correto será validado!!!!
				return resultSet.next();
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			} finally {
				try {
					if (resultSet != null) {
						resultSet.close();
					}
					if (stmt != null) {
						stmt.close();
					}
					if (conexao != null) {
						conexao.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	

}
