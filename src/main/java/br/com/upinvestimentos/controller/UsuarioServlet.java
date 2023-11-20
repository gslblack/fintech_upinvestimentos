package br.com.upinvestimentos.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.upinvestimentos.dao.UsuarioDAO;

/**
 * Servlet implementation class UsuarioServlet
 */
@WebServlet("/UsuarioServlet")
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private UsuarioDAO userDAO;
	
   
    public UsuarioServlet() {
        super();
  
        userDAO = new UsuarioDAO();
    }
        
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("login.jsp").forward(request, response);
    }
    
    // Realizar login de usuário - Parametros de entrada
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // 	String userEmail = Parsers.parseStringToDate(request.getParameter("Data"));
    	String userEmail = request.getParameter("Email de Usuário");
    	String userPassword = request.getParameter("Senha de Usuário");
    }

    
    
}
