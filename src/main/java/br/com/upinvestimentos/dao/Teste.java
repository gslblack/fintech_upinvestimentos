package br.com.upinvestimentos.dao;

import java.sql.SQLException;
import java.util.List;
import br.com.upinvestimentos.model.UsuarioModel;

public class Teste {

    public static void main(String[] args) {
        System.out.println("********************************");
        System.out.println("CONEXÃO COM O BANCO DE DADOS");

        try {
            UsuarioDAO usuarioDao = new UsuarioDAO();

            int cdUsuarioParaFiltrar = 3; // Substitua pelo ID desejado para filtrar os usuários
            List<UsuarioModel> listaUsuarios = usuarioDao.listarUsuariosPorCdUser(cdUsuarioParaFiltrar);

            for (UsuarioModel usuario : listaUsuarios) {
                System.out.println("ID: " + usuario.getCdUsuario());
                System.out.println("Nome: " + usuario.getNomeUsuario());
                System.out.println("CPF: " + usuario.getNumeroCPF());
                System.out.println("Email: " + usuario.getDescricaoEmail());
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar usuários por ID:");
            e.printStackTrace();
        }
    }
}
