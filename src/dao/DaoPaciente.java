package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Paciente;
import connection.SingleConnection;

public class DaoPaciente {

	private Connection connection;

	public DaoPaciente() {
		connection = SingleConnection.getConnection();
	}

	public List<Paciente> listar() throws Exception {
		List<Paciente> listar = new ArrayList<Paciente>();

		String sql = "select c.id,c.nome, c.cpf, c.telcel from paciente c "
				+ " order by c.nome asc";

		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();
		while (resultSet.next()) {
			Paciente cliente = new Paciente();
			cliente.setId(resultSet.getLong("id"));
			cliente.setNome(resultSet.getString("nome"));
			cliente.setCpf(resultSet.getString("cpf"));
			cliente.setTelcel(resultSet.getString("telcel"));

			listar.add(cliente);

		}
		return listar;
	}
	

	public boolean validarCPF(String cpf) throws Exception {
		String sql = "select count(1) as qtd from paciente where cpf = '" + cpf
				+ "'";

		PreparedStatement preStatement = connection.prepareStatement(sql);
		ResultSet resultSet = preStatement.executeQuery();
		if (resultSet.next()) {
			return resultSet.getInt("qtd") <= 0;
		}
		return false;

	}

	public void salvar(Paciente paciente) {

		String sql = "insert into paciente(nome, cpf, cep, rua, bairro, cidade, estado,"
				+ "rg, telfixo, telcel, email,"
				+ "numero ,usuario_alteracao "
				+ ") values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement insert;
		try {
			// id_recuperado = usuario.getId();
			insert = connection.prepareStatement(sql);
			insert.setString(1, paciente.getNome().toUpperCase());
			insert.setString(2, paciente.getCpf());
			insert.setString(3, paciente.getCep());
			insert.setString(4, paciente.getRua().toUpperCase());
			insert.setString(5, paciente.getBairro().toUpperCase());
			insert.setString(6, paciente.getCidade().toUpperCase());
			insert.setString(7, paciente.getEstado().toUpperCase());
			insert.setString(8, paciente.getRg());
			insert.setString(9, paciente.getTelfixo());
			insert.setString(10, paciente.getTelcel());
			insert.setString(11, paciente.getEmail().toUpperCase());
			insert.setString(12, paciente.getNumero());
			insert.setLong(13, paciente.getUsuario_alteracao());
			insert.execute();
			connection.commit();

		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	
	public void atualizar(Paciente paciente) {
		try {
			String sql = " update paciente set  nome = ?, cpf = ?, cep = ?, rua = ?, bairro = ?, cidade = ?, estado = ? ,"
					+ " rg = ?,telfixo = ?, telcel = ?,"
					+ " email = ?, numero = ?, usuario_alteracao = ?  " 
				    + " where id = " + paciente.getId();

		    PreparedStatement preparedStatement;
		    preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, paciente.getNome().toUpperCase());
			preparedStatement.setString(2, paciente.getCpf());
			preparedStatement.setString(3, paciente.getCep());
			preparedStatement.setString(4, paciente.getRua().toUpperCase());
			preparedStatement.setString(5, paciente.getBairro().toUpperCase());
			preparedStatement.setString(6, paciente.getCidade().toUpperCase());
			preparedStatement.setString(7, paciente.getEstado().toUpperCase());
			preparedStatement.setString(8, paciente.getRg());
			preparedStatement.setString(9, paciente.getTelfixo());
			preparedStatement.setString(10, paciente.getTelcel());
			preparedStatement.setString(11, paciente.getEmail().toUpperCase());
			preparedStatement.setString(12, paciente.getNumero());
			preparedStatement.setLong(13, paciente.getUsuario_alteracao());
			
			
			preparedStatement.executeUpdate();
			connection.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	


	public Paciente consultar(String id) throws Exception {
		String sql = "select cli.id, cli.nome, cli.cpf, cli.cep, cli.rua, cli.bairro, cli.cidade,"
				+ " cli.estado,cli.rg,cli.telfixo, cli.telcel, cli.email, cli.numero"
				+ " from paciente cli "
				+ " where cli.id = " + id;

		PreparedStatement preaStatement = connection.prepareStatement(sql);
		ResultSet resultSet = preaStatement.executeQuery();
		if (resultSet.next()) {
			Paciente paciente = new Paciente();
			paciente.setId(resultSet.getLong("id"));
			paciente.setNome(resultSet.getString("nome"));
			paciente.setCpf(resultSet.getString("cpf"));
			paciente.setCep(resultSet.getString("cep"));
			paciente.setRua(resultSet.getString("rua"));
			paciente.setBairro(resultSet.getString("bairro"));
			paciente.setCidade(resultSet.getString("cidade"));
			paciente.setEstado(resultSet.getString("estado"));
			paciente.setRg(resultSet.getString("rg"));
			paciente.setTelcel(resultSet.getString("telcel"));
			paciente.setTelfixo(resultSet.getString("telfixo"));
			paciente.setEmail(resultSet.getString("email"));
			paciente.setNumero(resultSet.getString("numero"));

			return paciente;
		}
		return null;

	}
	

	public void delete(String id) {
		// id_deletado = id;
		// System.out.println(id_deletado );
		try {
			String sql = "delete from paciente where id = '" + id + "'";

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

}
