package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import beans.Permissao;
import beans.Usuario;
import connection.SingleConnection;

public class DaoLogin {

	private Connection connection;

	public DaoLogin() {
		connection = SingleConnection.getConnection();
	}
	

	public Usuario validarLogin(String login) throws Exception {
		String sql = "select * from usuario where login = '" + login
				+ "' ";
		PreparedStatement preaStatement = connection.prepareStatement(sql);
		ResultSet resultSet = preaStatement.executeQuery();
		if (resultSet.next()) {
			Usuario usuario = new Usuario();
			usuario.setLogin(resultSet.getString("login"));
			usuario.setSenha(resultSet.getString("senha"));

			return usuario;
		}
		return null;

	}
	

	public Permissao consultarPermissao(String login) throws Exception {
		String sql = "select u.id ,p.descricao from usuario u "
				+ "inner join permissao p on p.id = u.id_permissao "
				+ " where login = '" + login + "'";

		PreparedStatement preaStatement = connection.prepareStatement(sql);
		ResultSet resultSet = preaStatement.executeQuery();
		if (resultSet.next()) {
			Permissao permissao = new Permissao();
			permissao.setId_user(resultSet.getLong("id"));
			permissao.setDescricao(resultSet.getString("descricao"));

			return permissao;
		}
		return null;

	}
}
