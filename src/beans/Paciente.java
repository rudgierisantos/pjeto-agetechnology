package beans;

public class Paciente {
	
	private Long id;

	private String nome;
	
	private String cpf;

	private String cep;

	private String rua;

	private String bairro;

	private String cidade;

	private String estado;
	
	private String numero;
	
	private String rg;
	
	private String email;
	
	private String telfixo;
	
	private String telcel;
	

	
	private Long usuario_alteracao;
	
	public Long getUsuario_alteracao() {
		return usuario_alteracao;
	}
	
	public void setUsuario_alteracao(Long usuario_alteracao) {
		this.usuario_alteracao = usuario_alteracao;
	}
	
	
	
	
	
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelfixo() {
		return telfixo;
	}

	public void setTelfixo(String telfixo) {
		this.telfixo = telfixo;
	}

	public String getTelcel() {
		return telcel;
	}

	public void setTelcel(String telcel) {
		this.telcel = telcel;
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

		
	
}
