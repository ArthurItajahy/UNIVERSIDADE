package Aplication;

import Entities.BancoDados;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Entre com o nome da faculdade: ");
		String nome = input.next();
		BancoDados uni = new BancoDados(nome);
		boolean forward = true;

		while(forward){
			//--------------INICIA MENU PRINCIPAL---------------------------
			boolean keep = true;
			System.out.println("-----------PAGINA PRINCIPAL----------");
			System.out.print("\n\t\t\t1 - LOGIN \n\t\t\t2 - CADASTRO\n\t\t\t3 - Exit\n\t\t\tEscolha(1/2/3): ");
			String escolha = input.next();
			switch (escolha) {
				//--------------INICIA MENU LOGIN OU CADASTRO--------------------
				case "1":
					do {
						System.out.println("-----------PAGINA LOGIN----------");
						System.out.print("\n\t\t\t1 - Estudante \n\t\t\t2 - Professor\n\t\t3 - Exit\n\t\t\tEscolha(1/2/3): ");
						String escolha2 = input.next();
						switch (escolha2){
							case "1":
								//login estudante
								if(uni.procuraEstudantes()){

								}
								break;
							case "2":
								//login professor
								if(uni.procuraProfessor()){

								}
								break;
							case "3":
								//Exit
								keep = false;
								break;
							default:
								System.out.println("Escolha invalido!!");
						}

					}while(keep);
					break;
				case "2":
					do {
						System.out.println("-----------PAGINA CADASTRO----------");
						System.out.print("\n\t\t\t1 - Estudante \n\t\t\t2 - Professor\n\t\t3 - Exit\n\t\t\tEscolha(1/2/3): ");
						String escolha2 = input.next();
						switch (escolha2){
							case "1":
								//CRIA ALUNO
								uni.criaEstudante();
								break;
							case "2":
								//CRIA PROFESSOR
								uni.criaProfessor();
								break;
							case "3":
								//Exit
								keep = false;
								break;
							default:
								System.out.println("Escolha invalido!!");
						}
					}while(keep);
					break;
				case "3":
					forward = false;
					break;
				default:
					System.out.println("Opção invalida.");
			}
			//--------------ENCERRA MENU LOGIN OU CADASTRO-----------------------
		}
		//------------------ENCERRA MENU PRINCIPAL------------------------
		input.close();
	}

}
