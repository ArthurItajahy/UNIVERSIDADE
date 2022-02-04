package Aplication;

import Entities.BancoDados;
import Entities.Curso;
import Entities.Estudante;
import Entities.Professor;

import java.util.Objects;
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
			System.out.println("=============  SEJA BEM-VINDO A UNIVERSIDADE "+uni.getNome()+" ============================");
			System.out.println("-----------PAGINA PRINCIPAL----------");
			System.out.print("\n\t\t\t1 - LOGIN \n\t\t\t2 - CADASTRO\n\t\t\t3 - Exit\n\t\t\tEscolha(1/2/3): ");
			String escolha = input.next();
			switch (escolha) {
				//--------------INICIA MENU LOGIN OU CADASTRO--------------------
				case "1":
					do {
						System.out.println("-----------PAGINA LOGIN----------");
						System.out.print("\n\t\t\t1 - Estudante \n\t\t\t2 - Professor\n\t\t\t3 - Gerente\n\t\t\t4 - Exit\n\t\t\tEscolha(1/2/3/4): ");
						String escolha2 = input.next();
						switch (escolha2) {
							case "1":
								boolean continua = true;
								boolean cont = true;
								//login estudante
								while (continua){
									boolean achou = false;
									int mid = uni.procurarEstudande();
									if (mid >= 0){
										achou = true;
										System.out.println("-----------PAGINA DO ESTUDANTE----------");
										System.out.println("\t\t\tSEJA BEM-VINDO: " + uni.getEstudantes().get(mid).getNome());
										//--> Aluno terá que pagar mensalidade.
										//--> Poderá ver sua nota.
										while (cont){
											System.out.print("\n\t\t\t1 - Pagar Mensalidade\n\t\t\t2 - Ver notas\n\t\t\t3 - Deslogar\n\t\t\tEscolha: ");
											String escolhendo = input.next();
											switch (escolhendo){
													case "1":
														if(uni.pagarMensalidade(uni.getEstudantes().get(mid))){
															System.out.println("\t\t\tPago com Sucesso.");
														}
														break;
													case "2":
														uni.getEstudantes().get(mid).verificarNota();
														break;
													case "3":
														cont = false;
														continua = false;
														break;
													default:
														System.out.println("\t\t\tEscolha Invalida.");
												}
											}
										}
									if(!achou){
										// Não encontre perguntar se quer sair.
										System.out.println("\t\t\tNão encontrado.");
										System.out.print("\n\t\t\tDeseja sair?\n\t\t\t1 - Sim\n\t\t\t2 - Não\n\t\t\tEscolha: ");
										String choice = input.next();
										if(Objects.equals(choice, "1")){
											continua = false;
										}else{
											System.out.println("\t\t\tCarregando...");
										}
									}
								}
								break;
							case "2":
								//login professor
								continua = true;
								cont = true;
								while (continua){
									boolean achou = false;
									int mid = uni.procurarProfessor();
									if (mid >= 0){
										achou = true;
										System.out.println("-----------PAGINA DO PROFESSOR----------");
										System.out.println("\t\t\tSEJA BEM-VINDO: " + uni.getProfessors().get(mid).getNome());
										// --> O Professor pode ver se o status se o salario dele foi pago.
										// --> O PROFESSO PODERÁ DAR NOTAS.
										while (cont){
											System.out.print("\n\t\t\t1 - Ver status do salario\n\t\t\t2 - Dar nota\n\t\t\t3 - Deslogar\n\t\t\tEscolha: ");
											String escolhendo = input.next();
											switch (escolhendo){
												case "1":
													if(!uni.getProfessors().get(mid).getStatusSalario()){
														System.out.println("\t\t\tStatus do Salario: Não pago.");
													}else{

														System.out.println("\t\t\tSalario atual: Pago");
													}
													break;
												case "2":
													if(uni.getProfessors().get(mid).getQuantidadeTurma() > 0){
														System.out.print("\n\t\t\tDigite id da turma: ");
														int idTurma = input.nextInt();
														System.out.print("\n\t\t\tDigite id do aluno: ");
														int idAluno = input.nextInt();
														uni.buscaAlunoTurma(idTurma, idAluno);
													}else{
														System.out.println("========= Você ainda não está dando aula em nenhuma classe.===============");
													}
													break;
												case "3":
													cont = false;
													continua = false;
													break;
												default:
													System.out.println("\t\t\tEscolha Invalida.");
											}
										}
									}
									if(!achou){
										// Não encontrou! Perguntar se quer sair.
										System.out.println("\t\t\tNão encontrado.");
										System.out.print("\n\t\t\tDeseja sair?\n\t\t\t1 - Sim\n\t\t\t2 - Não\n\t\t\tEscolha: ");
										String choice = input.next();
										if(Objects.equals(choice, "1")){
											continua = false;
										}else{
											System.out.println("\t\t\tCarregando...");
										}
									}
								}
								break;
							case "3":
								// --> LOGIN GERENTE
								cont = true;
								continua = true;
								//Gerente...
								while(continua){
									System.out.println("============ LOGIN GERENTE ==================");
                                    System.out.print("\n\t\t\tEntre como seu nome: ");
                                    String nomeGerente = input.next();
                                    System.out.print("\n\t\t\tEntre com a sua senha: ");
                                    String senhaGerente = input.next();
									boolean achou = false;
									if (Objects.equals(nomeGerente, uni.getManager().getNome()) && Objects.equals(senhaGerente, uni.getManager().getSenha())){
										achou = true;
										System.out.println("=============== SEJA BEM-VINDO: " + uni.getManager().getNome()+"=========================");
										while (cont){
											System.out.println("================ PAGINA DO GERENTE ==================");
											System.out.print("\n\t\t\t1 - Criar turmas\n\t\t\t2 - VER INFORMAÇÃOS SOBRE A UNIVERSIDADE\n\t\t\t3 - Criar Tudo automatico\n\t\t\t4 - Criar Cursos\n\t\t\t5 - Pagar professor\n\t\t\t6 - Sair\n\t\t\tEscolha: ");
											String escolhendo = input.next();
											switch (escolhendo){
												case "1":
													// --> AS TURMAS SERÃO CRIADAS PELO DIRETOR
													System.out.println("============== CRIANDO NOVA TURMA =====================");
													uni.criarTurmas();
													break;
												case "2":
													// --> TODAS AS INFORMAÇÕES
													System.out.println("============== INFORMAÇÕES =================");
													System.out.println("\t\t\tTOTAL DE TURMAS: "+uni.getTurmas().size());
													System.out.println("\t\t\tTOTAL DE CURSOS: "+uni.getCursos().size());
													System.out.println("\t\t\tTOTAL DE PROFESSORES: "+uni.getProfessors().size());
													System.out.println("\t\t\tTOTAL DE ALUNOS: "+uni.getEstudantes().size());
													System.out.println("\t\t\tSALDO NO CAIXA: "+uni.pegarValorCaixa());
													System.out.println("\t\t\tSALDO DE DIVIDA:  "+uni.pegarValorDivida());

													break;
												case "3":
													// --> Saldo na conta da Universidade.
													System.out.println("============== CRIAR TUDO AUTOMATICO ======================");
													Curso primeiro = new Curso(1,"Ciência da Computação.","5 anos");
													uni.addCursos(primeiro);
													Estudante aluno = new Estudante("Emmett", "emmett@gmail.com",1,"999999999","Ciência da Computação.","1234");
													uni.addEstudantes(aluno);
													Estudante aluno1 = new Estudante("Brown", "brown@gmail.com",2,"999999999","Ciência da Computação.","1234");
													uni.addEstudantes(aluno1);
													Estudante aluno2 = new Estudante("arthur", "arthur@gmail.com",3,"999999999","Ciência da Computação.","1234");
													uni.addEstudantes(aluno2);
													Estudante aluno3 = new Estudante("luiz", "luiz@gmail.com",4,"999999999","Ciência da Computação.","1234");
													uni.addEstudantes(aluno3);
													Estudante aluno4 = new Estudante("amanda", "amanda@gmail.com",5,"999999999","Ciência da Computação.","1234");
													uni.addEstudantes(aluno4);
													Estudante aluno5 = new Estudante("esther", "esther@gmail.com",6,"999999999","Ciência da Computação.","1234");
													uni.addEstudantes(aluno5);
													Professor professors = new Professor("Paulo","paulo@gmail.com",1,"999999999","Ciência da Computação.","1234");
													uni.addProfessors(professors);
													Professor professors1 = new Professor("james","james@gmail.com",2,"999999999","Ciência da Computação.","1234");
													uni.addProfessors(professors1);
													System.out.println("============== CRIADO COM SUCESSO ======================");
													break;
												case "4":
													// --> Vai poder Criar os Cursos.
													uni.criarCursos();
													break;
												case "5":
													// --> Pagar professor
													if(uni.getTurmas().size() > 0) {
														if(uni.pegarValorCaixa() >= uni.pegarValorDivida()){
														System.out.print("\n\t\t\tDigite o id da turma: ");
														int idTurma = input.nextInt();
														System.out.print("\n\t\t\tDigite o id do Professor: ");
														int idProfessor = input.nextInt();
														if(uni.buscaProfessorTurma(idTurma,idProfessor)){
															System.out.println("\t\t\tPagamento fetuado com sucesso!!");
														}else {
															System.out.println("\t\t\tVocê já pagou esse professor!!");
														}
														}else {
															System.out.println("Você não tem caixa para pagar os professores.");
														}
													}else {
														System.out.println("Você não tem nenhuma turma criada. ");
													}
													break;
												case "6":
													// --> Sair.
													cont = false;
													continua = false;
													break;
												default:
													System.out.println("\t\t\tEscolha Invalida.");
											}
										}
									}
									if(!achou){
										// Não encontrou! Perguntar se quer sair.
										System.out.println("\t\t\tNão encontrado.");
										System.out.print("\n\t\t\tDeseja sair?\n\t\t\t1 - Sim\n\t\t\t2 - Não\n\t\t\tEscolha: ");
										String choice = input.next();
										if(Objects.equals(choice, "1")){
											continua = false;
										}else{
											System.out.println("\t\t\tCarregando...");
										}
									}
								}
								break;
							case "4":
								//Exit
								keep = false;
								break;
							default:
								System.out.println("\t\t\tEscolha invalido!!");

						}
					}while(keep);
					break;
				case "2":
					do {
						System.out.println("-----------PAGINA CADASTRO----------");
						System.out.print("\n\t\t\t1 - Estudante \n\t\t\t2 - Professor\n\t\t\t3 - Exit\n\t\t\tEscolha(1/2/3): ");
						String escolha2 = input.next();
						switch (escolha2){
							case "1":
								//CRIA ALUNO
								if(uni.getCursos().size()  > 0){
									uni.criaEstudante();
								}else{
									System.out.println("\t\t\tNão tem curso para se inscrever.");
								}
								break;
							case "2":
								//CRIA PROFESSOR
								if(uni.getCursos().size() > 0){
									uni.criaProfessor();
								}else{
									System.out.println("\t\t\tNão tem curso para dar aula.");
								}
								break;
							case "3":
								//Exit
								keep = false;
								break;
							default:
								System.out.println("\t\t\tEscolha invalido!!");
						}
					}while(keep);
					break;
				case "3":
					forward = false;
					break;
				default:
					System.out.println("\t\t\tOpção invalida.");
			}
			//--------------ENCERRA MENU LOGIN OU CADASTRO-----------------------
		}
		//------------------ENCERRA MENU PRINCIPAL------------------------
		input.close();
	}

}
