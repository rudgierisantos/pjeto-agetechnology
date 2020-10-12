package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Permissao;
import beans.Usuario;
import connection.SingleConnection;

public class DaoUsuario {
	DaoLogin daoLogin = new DaoLogin();

	private Connection connection;

	public DaoUsuario() {
		connection = SingleConnection.getConnection();
	}

	public List<Usuario> listar() throws Exception {
		List<Usuario> listar = new ArrayList<Usuario>();

		String sql = "select * from usuario order by nome asc";

		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();
		while (resultSet.next()) {
			Usuario usuario = new Usuario();
			usuario.setId(resultSet.getLong("id"));
			usuario.setLogin(resultSet.getString("login"));
			usuario.setNome(resultSet.getString("nome"));
			usuario.setSenha(resultSet.getString("senha"));
			listar.add(usuario);

		}
		return listar;
	}

	public List<Permissao> listarPermissao() throws Exception {
		List<Permissao> listarPermissao = new ArrayList<Permissao>();

		String sql = "select * from permissao order by descricao asc";

		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();
		while (resultSet.next()) {
			Permissao permissao = new Permissao();
			permissao.setId(resultSet.getLong("id"));
			permissao.setDescricao(resultSet.getString("descricao"));
			listarPermissao.add(permissao);

		}
		return listarPermissao;
	}

	public void salvar(Usuario usuario) {

		String sql = "insert into usuario(login, nome, senha, id_permissao,usuario_alteracao) "
				+ " values (?,?,?,?,?)";
		PreparedStatement insert;
		try {
			// id_recuperado = usuario.getId();
			insert = connection.prepareStatement(sql);
			insert.setString(1, usuario.getLogin());
			insert.setString(2, usuario.getNome().toUpperCase());
			insert.setString(3, usuario.getSenha());
			insert.setLong(4, usuario.getId_permissao());
			insert.setLong(5, usuario.getUsuario_alteracao());
			insert.execute();
			connection.commit();

		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (Exception e2) {
			}
		}

	}

	public void atualizar(Usuario usuario) {
		try {
			String sql = "update usuario set login = ?, nome = ?, senha = ?, id_permissao = ?,"
					+ " usuario_alteracao = ? "
					+ " where id = " + usuario.getId();
			PreparedStatement preparedStatement;
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, usuario.getLogin());
			preparedStatement.setString(2, usuario.getNome().toUpperCase());
			preparedStatement.setString(3, usuario.getSenha());
			preparedStatement.setLong(4, usuario.getId_permissao());
			preparedStatement.setLong(5, usuario.getUsuario_alteracao());
			preparedStatement.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (Exception e2) {
			}
		}
	}

	public void delete(String id) {
		// id_deletado = id;
		// System.out.println(id_deletado );
		try {
			String sql = "delete from usuario where id = '" + id + "'";

			PreparedStatement preparedStatement;
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.execute();
			connection.commit();
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (Exception e2) {
			}
			e.printStackTrace();
		}
	}

	public Usuario consultar(String id) throws Exception {
		String sql = "select * from usuario where id = '" + id + "'";

		PreparedStatement preaStatement = connection.prepareStatement(sql);
		ResultSet resultSet = preaStatement.executeQuery();
		if (resultSet.next()) {
			Usuario usuario = new Usuario();
			usuario.setId(resultSet.getLong("id"));
			usuario.setLogin(resultSet.getString("login"));
			usuario.setNome(resultSet.getString("nome"));
			usuario.setSenha(resultSet.getString("senha"));
			usuario.setId_permissao(resultSet.getLong("id_permissao"));

			return usuario;
		}
		return null;

	}
}
