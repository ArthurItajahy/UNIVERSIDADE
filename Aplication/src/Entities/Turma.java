package Entities;

public class Turma {

	private int id;
	private String nomeAluno;
	private String nomeProfessor;
	private String nomeCurso;
	private String nomeTurma;
	
	public Turma(String nomeTurma, String nomeAluno, String nomeProfessor,
			int id, String nomeCurso)
	{   
		this.id = id;
		this.nomeAluno = nomeAluno;
		this.nomeProfessor = nomeProfessor;
		this.nomeCurso = nomeCurso;
		this.nomeTurma = nomeTurma;
	}


	public int getId() {
		return id;
	}
	public String getNomeAluno() {
		return nomeAluno;
	}
	public String getNomeProfessor() {
		return nomeProfessor;
	}
	public String getNomeCurso() {
		return nomeCurso;
	}
	public String getNomeTurma() {
		return nomeTurma;
	}
	
	
	public void setId(int id) {
		this.id = id;}
	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}
	public void setNomeProfessor(String nomeProfessor) {
		this.nomeProfessor = nomeProfessor;
	}
	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}
	public void setNomeTurma(String nomeTurma) {
		this.nomeTurma = nomeTurma;
	}

	/*public String nomeTurma() {
       
    System.out.println(nomeTurma+"\t\t "+nomeCurso+"\tId: "+id);
	return nomeTurma;
	}*/
}
