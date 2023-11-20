package br.com.upinvestimentos.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoOracle {

  public static Connection realizarConexao() throws SQLException{
    
	  Connection conexaoDB = null;
	  
	  try {
      //Registra o Driver
      Class.forName("oracle.jdbc.driver.OracleDriver");

      //Abre uma conexão
      conexaoDB = DriverManager.getConnection(
          "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl", "RM551344", "260297");
      conexaoDB.setAutoCommit(false);
      System.out.println("Conectado!");
      	
      //Fecha a conexão
//      conexaoDB.close();
      
    //Tratamento de erro  
    }	catch (ClassNotFoundException e) {
		throw new SQLException("Driver Oracle JDBC não encontrado", e);
		// Exceção de SQL
	} catch (SQLException e) {
		if (e.getErrorCode() == 1017) {
			throw new SQLException("Senha incorreta!", e);
		}

	} catch (Exception e) {
		System.err.println("Erro ao conectar o banco de dados!");
		e.printStackTrace();
	}
	return conexaoDB;
  }
}


