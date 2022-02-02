package Entities;



public class Cadastro  {
	
	private String nome;
	private String email;
	private int id;
	private int tell;
	private String curso;
	private String senha;
	
	public Cadastro(String nome,String email,int id,int tell,String curso, String senha) 
	{
		this.nome = nome;
		this.email = email;
		this.id = id;
		this.tell = tell;
		this.curso = curso;
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTell() {
		return tell;
	}

	public void setTell(int tell) {
		this.tell = tell;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
}

