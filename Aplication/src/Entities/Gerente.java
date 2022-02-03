package Entities;

public class Gerente {
    private String nome;
    private String senha;


    public Gerente(){
        this.nome = "TEMPO";
        this.senha = "TEMPO";
    }
    // ---------------- GETTERS -------------------
    public String getNome() {return nome;}

    public String getSenha() {return senha;}
    // --------------- SETTERS --------------------
    public void setNome(String nome) {this.nome = nome;}

    public void setSenha(String senha) {this.senha = senha;}
}
