package br.com.upinvestimentos.controller;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.upinvestimentos.dao.*;
import br.com.upinvestimentos.model.ControleGastoGeralModel;
import br.com.upinvestimentos.model.ControleGastosEntradasModel;
import br.com.upinvestimentos.model.ControleGastosSaidasModel;
import br.com.upinvestimentos.utils.Parsers;

@WebServlet("/ControleGastosServlet")
public class ControleGastosServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    private GastosDAO GastoDAO;
    private GastosEntradasDAO GastosEntradaDAO;
    private GastosSaidasDAO GastosSaidaDAO;
    
    public ControleGastosServlet() {
        super();
        GastoDAO = new GastosDAO();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("ControleFinanceiro.jsp").forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String TipoTransacao = request.getParameter("Tipo de transacao");
        String descricao = request.getParameter("Descricao");
        double valor = Parsers.parseBrazilianCurrency(request.getParameter("valor"));
        
        // Executa a inserção de dados
        if ("Entrada".equals(TipoTransacao)) {
            ControleGastosEntradasModel NewInsertEntradas = new ControleGastosEntradasModel(valor, descricao);
            try {
				GastosEntradaDAO.inserirEntradaGasto(NewInsertEntradas);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        } else if ("Saída".equals(TipoTransacao)) {
            ControleGastosSaidasModel NewInsertSaidas = new ControleGastosSaidasModel(valor, descricao);
            GastosSaidaDAO.inserirSaidaGastos(NewInsertSaidas);
        }
        
        ControleGastoGeralModel NewInsertGeral = new ControleGastoGeralModel(1, valor, 0);
        try {
			GastoDAO.inserirGasto(NewInsertGeral);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
