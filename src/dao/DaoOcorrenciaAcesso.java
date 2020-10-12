package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import beans.OcorrenciaAcesso;
import connection.SingleConnection;


public class DaoOcorrenciaAcesso {
	
	private Connection connection;

	public DaoOcorrenciaAcesso() {
		connection = SingleConnection.getConnection();
	}
	
	public void salvarOcorrenciaAcesso(OcorrenciaAcesso ocorrenciaAcesso ) {

		String sql = "insert into ocorrencia_acesso(nome_maquina, ip_maquina, login, data_acesso "
				+ ",hora_acesso) values (?,?,?,?,?)";
		PreparedStatement insert;
		try {
			// id_recuperado = usuario.getId();
			insert = connection.prepareStatement(sql);
			insert.setString(1, ocorrenciaAcesso.getNomeDaMaquina().toUpperCase());
			insert.setString(2, ocorrenciaAcesso.getIpDaMaquina());
			insert.setString(3, ocorrenciaAcesso.getLogin().toUpperCase());
			insert.setDate(4, new java.sql.Date(ocorrenciaAcesso.GetDataatual().getTime()));
			insert.setTime(5, new java.sql.Time(ocorrenciaAcesso.GetHoraatual().getTime()));
			
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

}
