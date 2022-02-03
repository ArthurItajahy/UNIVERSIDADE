package Entities;

import java.util.Scanner;

public class Curso {
	private String nome;
	private int id;
	private String duracao;
	private String descricao;
	
	Scanner sc = new Scanner(System.in);
	
	public Curso(int id, String nome, String duracao) {
		this.nome = nome;
		this.id = id;
		this.duracao = duracao;
	}

	public void descreva() {
		descricao = sc.nextLine();
	}
	
	public String getNome() {
		return nome;
	}

	public int getId() {
		return id;
	}

	public String getDuracao() {return duracao;}

	public String getDescricao() {
		return descricao;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
