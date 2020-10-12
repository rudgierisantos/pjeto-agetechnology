package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.Dashboard;
import connection.SingleConnection;

public class DaoDashboard {
	
	private Connection connection;

	public DaoDashboard() {
		connection = SingleConnection.getConnection();
	}
	
	public List<Dashboard> listarPacientes() throws Exception {
		List<Dashboard> listarPacientes = new ArrayList<Dashboard>();

		String sql = "select count(nome) as qtd_paciente "
				+ " from paciente " ;

		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();
		while (resultSet.next()) {
			Dashboard dashboard = new Dashboard();
			dashboard.setTotal_pacientes(resultSet.getString("qtd_paciente"));
			
			listarPacientes.add(dashboard);

		}
		return listarPacientes;
	}
	
	public List<Dashboard> listarExames() throws Exception {
		List<Dashboard> listarExames = new ArrayList<Dashboard>();

		String sql = "select count(nome_exame) as qtd_exame "
				+ " from exame " ;

		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();
		while (resultSet.next()) {
			Dashboard dashboard = new Dashboard();
			dashboard.setTotal_exames(resultSet.getString("qtd_exame"));
			
			listarExames.add(dashboard);

		}
		return listarExames;
	}

}
