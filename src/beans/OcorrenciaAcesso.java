package beans;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

public class OcorrenciaAcesso {
	
	private String login;
	private Date data_acesso;
	private Time hora_acesso;
	private String nomeDaMaquina;
	private String ipDaMaquina;
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}

	public Date GetDataatual() {
		Date dataAtual = new Date();
		return dataAtual;
	}
	
	public Time GetHoraatual() {
		Time horaAtual = new Time(0);
		return horaAtual;
	}
	
	
	public Date getData_acesso() {
		return data_acesso;
	}
	public void setData_acesso(Date data_acesso) {
		this.data_acesso = data_acesso;
	}
	public Time getHora_acesso() {
		return hora_acesso;
	}
	public void setHora_acesso(Time hora_acesso) {
		this.hora_acesso = hora_acesso;
	}
	public String getNomeDaMaquina() {
		return nomeDaMaquina;
	}
	public void setNomeDaMaquina(String nomeDaMaquina) {
		this.nomeDaMaquina = nomeDaMaquina;
	}
	public String getIpDaMaquina() {
		return ipDaMaquina;
	}
	public void setIpDaMaquina(String ipDaMaquina) {
		this.ipDaMaquina = ipDaMaquina;
	}
	
	
	

}
