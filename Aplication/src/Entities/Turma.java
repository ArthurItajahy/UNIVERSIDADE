package Entities;

import java.util.ArrayList;
import java.util.List;

public class Turma {

	private int id;
	private List<Estudante> conjuntoEstudante = new ArrayList<>();
	private List<Professor> conjuntoProfessor = new ArrayList<>();
	private String nomeCurso;
	
	public Turma(int id, String nomeCursom)
	{   
		this.id = id;
		this.nomeCurso = nomeCurso;
	}
	//---------------------GETTER---------------------//
	public int getId() {return id;}
	public List<Estudante> getConjuntoAluno() {
		return conjuntoEstudante;}
	public List<Professor> getConjuntoProfessor() {
		return conjuntoProfessor;}
	public String getNomeCurso() {
		return nomeCurso;}
	
	//----------------------SETTERS(ADD)-----------------------//
	
	public void setId(int id) {
		this.id = id;}
	public void addProfessor(Professor professors) {conjuntoProfessor.add(professors);}
	public void addEstudante(Estudante estudantes) {conjuntoEstudante.add(estudantes);}
	public void setNomeCurso(String nomeCurso) {this.nomeCurso = nomeCurso;}

}

