package beans;

public class Permissao {
	
	private Long id;
	private String descricao;
	private Long id_user;
	
	public void setId_user(Long id_user) {
		this.id_user = id_user;
	}
	
	public Long getId_user() {
		return id_user;
	}
	
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
