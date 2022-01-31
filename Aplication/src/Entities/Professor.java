package Aplication;

public class Professor {
	private static int geraId=0;
	private int id;
	private String name;
	private int idade;
	private String email;
	private String telefone;
	private Turma turma;
	public Curso curso;
	
	{
		geraId++;
		id = geraId;
	}
	
	public Professor(String name, int idade, String email, String telefone, Curso curso, Turma turma){
		this.name = name;
		this.curso = curso;
		this.turma = turma;
	}
	
	public Professor() {
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	public static int getGeraId() {
		return geraId;
	}

	public static void setGeraId(int geraId) {
		Professor.geraId = geraId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	@Override
	public String toString() {
		return ("ID: " + id + ", profª " + name );
	}

}
