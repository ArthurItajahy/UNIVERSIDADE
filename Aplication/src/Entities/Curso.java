package Entities;

import java.util.Scanner;

public class Curso {
	private String nome;
	private int id;
	private String tipo;
	private int duracao;
	private String descricao;
	
	Scanner sc = new Scanner(System.in);
	
	public Curso(int id, String nome, String tipo, int duracao) {
		this.nome = nome;
		this.id = id;
		this.tipo = tipo;
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
	
	public String getTipo() {
		return tipo;
	}

	public int getDuracao() {
		return duracao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	

}
