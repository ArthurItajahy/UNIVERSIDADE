package Entities;

import java.util.ArrayList;
import java.util.List;

public class Professor extends Cadastro{
	private boolean statusSalario;
	private double quantidadeTurma;
	private List<Integer> idTurmas = new ArrayList<>();
	public Professor(String nome, String email, int id,String tell,String curso,String senha){
		super(nome, email, id, tell, curso,senha);
		this.statusSalario = false;
		this.quantidadeTurma = 0;
	}
	// -------------- GETTER --------------------------
	public boolean getStatusSalario(){return this.statusSalario;}
	public double getQuantidadeTurma(){return this.quantidadeTurma;}

	// ----------------- SETTERS ----------------------
	public void recebeSalario() {
			this.statusSalario = true;
	}
	public void addQuantidadeTurma(){this.quantidadeTurma += 1;}

	public void addIdTurmas(int idTurma){idTurmas.add(idTurma);}



}
