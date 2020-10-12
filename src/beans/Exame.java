package beans;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Exame {
	
	private Long id;
	
	private Long id_paciente;
	
	private String nome_paciente;
	
	private String nome_exame;
	
	private Date data;
	
	private String observacao;
	
	private String exameBase64;
	
	private String contentTypeExame;
	
	private boolean atualizarPdf = true;
	
	public String getDateTime() { 
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
		Date date = new Date(); 
		return dateFormat.format(date); 
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getId_paciente() {
		return id_paciente;
	}
	
	public void setId_paciente(Long id_paciente) {
		this.id_paciente = id_paciente;
	}

	public String getNome_paciente() {
		return nome_paciente;
	}

	public void setNome_paciente(String nome_paciente) {
		this.nome_paciente = nome_paciente;
	}

	public String getNome_exame() {
		return nome_exame;
	}

	public void setNome_exame(String nome_exame) {
		this.nome_exame = nome_exame;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getExameBase64() {
		return exameBase64;
	}

	public void setExameBase64(String exameBase64) {
		this.exameBase64 = exameBase64;
	}

	public String getContentTypeExame() {
		return contentTypeExame;
	}

	public void setContentTypeExame(String contentTypeExame) {
		this.contentTypeExame = contentTypeExame;
	}

	public boolean isAtualizarPdf() {
		return atualizarPdf;
	}

	public void setAtualizarPdf(boolean atualizarPdf) {
		this.atualizarPdf = atualizarPdf;
	}
	
	
	

}
