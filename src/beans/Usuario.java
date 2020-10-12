package beans;

public class Usuario {
	
	private String login;
	private String senha;
	private Long id;
	private String nome;
	private Long id_permissao;
	private Long usuario_alteracao;
	
	public void setUsuario_alteracao(Long usuario_alteracao) {
		this.usuario_alteracao = usuario_alteracao;
	}
	
	public Long getUsuario_alteracao() {
		return usuario_alteracao;
	}
	
	public void setId_permissao(Long id_permissao) {
		this.id_permissao = id_permissao;
	}
	
	public Long getId_permissao() {
		return id_permissao;
	}
		
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

}
