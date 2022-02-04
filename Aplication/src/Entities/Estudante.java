package Entities;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Estudante extends Cadastro {
	Scanner input = new Scanner(System.in);
	private double nota1;
	private double nota2;
	private double nota3;
	private boolean pagemento;
	private boolean temSala;

	public Estudante(String nome, String email, int id, String tell, String curso, String senha) {
		super(nome, email, id, tell, curso, senha);
		this.nota1 = 0;
		this.nota2 = 0;
		this.nota3 = 0;
		this.pagemento = false;
		this.temSala = false;
	}

	public void receberNota(){
		boolean keep = true;
		do{
			System.out.print("\n\t\t\tQual mês você que dar nota?\n\t\t\t 1-Primeiro\n\t\t\t 2-Segundo\n\t\t\t 3-Terceito\n\t\t\tEscolha: ");
			String escolha = input.next();
			try{
				System.out.print("\n\t\t\tQual nota você deseja colocar para esse aluno: ");//InputMismatchException
				double nota = input.nextDouble();
				switch (escolha) {
					case "1":
						this.nota1 = nota;
						keep = false;
						break;
					case "2":
						this.nota2 = nota;
						keep = false;
						break;
					case "3":
						this.nota3 = nota;
						keep = false;
						break;
					default:
						System.out.println("\t\t\tOpção invalida! ");
				}

			}catch (InputMismatchException errors){
				System.out.println("\t\t\tTente com dessa forma: '0,0' .");
			}finally {
				System.out.println("\t\t\tCarregando....");
			}
		}while (keep);
	}
	public boolean verificarPagamento(){
		return pagemento;
	}
	public void mudePagamento(){
		this.pagemento = !pagemento;
	}
	public void verificarNota(){
		System.out.print("\n\t\t\tPrimeiro mês: "+this.nota1+"\n\t\t\tSegundo Mês: "+this.nota2+"\n\t\t\tTerceira: "+this.nota3);
	}
	public boolean getTemSala(){
		return temSala;
	}
}
