package Entities;

import java.util.ArrayList;

public class Turma {

	private int id;
	private ArrayList<Estudante> nomeAluno = new ArrayList<Estudante>();
	private ArrayList<Professor> nomeProfessor = new ArrayList<Professor>();
	private String nomeCurso;
	private String nomeTurma;
	
	public Turma(String nomeTurma,ArrayList nomeAluno, ArrayList nomeProfessor ,
			int id, String nomeCurso)//Mudar!!
	{   
		this.id = id;
		this.nomeAluno = nomeAluno;
		this.nomeProfessor = nomeProfessor; 
		this.nomeCurso = nomeCurso;
		this.nomeTurma = nomeTurma;
	}
	//---------------------GETTER---------------------
	public int getId() {
		return id;}
	public ArrayList<Estudante> getNomeAluno() {
		return nomeAluno;}
	public ArrayList<Professor> getNomeProfessor() {
		return nomeProfessor;}
	public String getNomeCurso() {
		return nomeCurso;}
	public String getNomeTurma() {
		return nomeTurma;}
	
	//----------------------SETTERS(ADD)-----------------------
	
	public void setId(int id) {
		this.id = id;}
	public void setNomeProfessor(ArrayList<Professor> nomeProfessor) {
		this.nomeProfessor = nomeProfessor;}
	public void setNomeAluno(ArrayList<Estudante> nomeAluno) {
		this.nomeAluno = nomeAluno;}
	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;}
	public void setNomeTurma(String nomeTurma) {
		this.nomeTurma = nomeTurma;}


}

