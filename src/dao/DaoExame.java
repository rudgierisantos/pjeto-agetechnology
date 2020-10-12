package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Exame;
import beans.Paciente;
import connection.SingleConnection;

public class DaoExame {

	private Connection connection;


	public DaoExame() {
		connection = SingleConnection.getConnection();
	}


	public List<Exame> listarExames() throws Exception {
		List<Exame> listar = new ArrayList<Exame>();

		String sql = "select e.id, p.nome as nome_paciente, e.nome_exame, e.data, e.observacao,e.examebase64,e.contenttypeexame  "
				+ " from exame e "
				+ " inner join paciente p on e.id_paciente = p.id "
				+ " order by p.nome, e.nome_exame asc";

		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();
		while (resultSet.next()) {
			Exame exame = new Exame();
			exame.setId(resultSet.getLong("id"));
			exame.setNome_paciente(resultSet.getString("nome_paciente"));
			exame.setNome_exame(resultSet.getString("nome_exame"));
			exame.setData(resultSet.getDate("data"));
			exame.setObservacao(resultSet.getString("observacao"));
			exame.setExameBase64(resultSet.getString("examebase64"));
			exame.setContentTypeExame(resultSet.getString("contenttypeexame"));
			

			listar.add(exame);

		}
		return listar;
	}

	
	public List<Paciente> listarPaciente() throws SQLException {
		List<Paciente> retorno = new ArrayList<Paciente>();
		String sql = " select id, nome as nome_paciente from paciente ";
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();
		while (resultSet.next()) {
			Paciente paciente = new Paciente();
			paciente.setId(resultSet.getLong("id"));
			paciente.setNome(resultSet.getString("nome_paciente"));
			retorno.add(paciente);

		}

		return retorno;

	}

	public void salvar(Exame exame) {

		String sql = " insert into exame(id_paciente ,nome_exame, data, observacao,examebase64, contenttypeexame) " 
				   + " values (?,?,?,?,?,?)";
		PreparedStatement insert;
		try {

			insert = connection.prepareStatement(sql);
			insert.setLong(1, exame.getId_paciente());
			insert.setString(2, exame.getNome_exame().toUpperCase());
			insert.setDate(3, new java.sql.Date(exame.getData()
					.getTime()));
			insert.setString(4, exame.getObservacao().toUpperCase());
			insert.setString(5, exame.getExameBase64());
			insert.setString(6, exame.getContentTypeExame());
			insert.execute();
			connection.commit();

		} catch (SQLException e) {
			try {
				e.printStackTrace();
				connection.rollback();
			} catch (Exception e2) {
			}
		}
	}

	public Exame consultarExame(String id_exame) throws Exception {
		String sql = "select e.id, e.id_paciente ,p.nome as nome_paciente, e.nome_exame, e.data, e.observacao, e.examebase64,e.contenttypeexame  "
				+ " from exame e "
				+ " inner join paciente p on e.id_paciente = p.id "
				+ " where e.id = " + id_exame;
		PreparedStatement preaStatement = connection.prepareStatement(sql);
		ResultSet resultSet = preaStatement.executeQuery();
		if (resultSet.next()) {
			Exame exame = new Exame();
			exame.setId(resultSet.getLong("id"));
			exame.setId_paciente(resultSet.getLong("id_paciente"));
			exame.setNome_paciente(resultSet.getString("nome_paciente"));
			exame.setNome_exame(resultSet.getString("nome_exame"));
			exame.setData(resultSet.getDate("data"));
			exame.setObservacao(resultSet.getString("observacao"));
			exame.setExameBase64(resultSet.getString("examebase64"));
			exame.setContentTypeExame(resultSet.getString("contenttypeexame"));

			return exame;

		}
		return null;

	}
	
	
	public void atualizarExame(Exame exame) {
		try {
			StringBuilder sql = new StringBuilder();
			sql.append(" update exame set id_paciente = ?, nome_exame = ?, data = ?, observacao = ?");

			if (exame.isAtualizarPdf()) {
				sql.append(" , examebase64 = ?, contenttypeexame = ?  ");
			}

			sql.append(" where id = " + exame.getId());

			PreparedStatement preparedStatement = connection
					.prepareStatement(sql.toString());

			preparedStatement.setLong(1, exame.getId_paciente());
			preparedStatement.setString(2, exame.getNome_exame().toUpperCase());
			preparedStatement.setDate(3, new java.sql.Date(exame
					.getData().getTime()));
			preparedStatement.setString(4, exame.getObservacao().toUpperCase());

			if (exame.isAtualizarPdf()) {
				preparedStatement.setString(5, exame.getExameBase64());
				preparedStatement.setString(6, exame.getContentTypeExame());
			}

			preparedStatement.executeUpdate();
			connection.commit();

		} catch (Exception e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}
	
	public boolean validarPaciente(String id_paciente) throws Exception {
		String sql = "select count(1) as qtd from exame where id_paciente = '" + id_paciente
				+ "'";

		PreparedStatement preStatement = connection.prepareStatement(sql);
		ResultSet resultSet = preStatement.executeQuery();
		if (resultSet.next()) {
			return resultSet.getInt("qtd") <= 0;
		}
		return false;

	}


		
	public void delete(String id_exame) {

		try {
			String sql = "delete from exame where id = '"
					+ id_exame + "'";

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
