package Entities;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BancoDados {
    private final Scanner input = new Scanner(System.in);
    private final List<Professor> professors = new ArrayList<>();
    private final List<Curso> cursos = new ArrayList<>();
    private final List<Estudante> estudantes = new ArrayList<>();
    private final List<Turma> turmas = new ArrayList<>();
    private String nome;
    private double totalEmCaixa;
    private double totalEmDivida;


    public BancoDados(String nome){
        this.nome = nome;
        this.totalEmCaixa = 0;
        this.totalEmDivida = 0;

    }
    //---------------------GETTER---------------------
    public List<Professor> getProfessors() {
        return professors;
    }
    public List<Curso> getCursos() {
        return cursos;
    }
    public List<Turma> getTurmas() {
        return turmas;
    }

    public List<Estudante> getEstudantes() {
        return estudantes;
    }

    //----------------------SETTERS(ADD)-----------------------

    public void addCursos(Curso curso) {this.cursos.add(curso);}

    public void addEstudantes(Estudante estudante) {this.estudantes.add(estudante);}

    public void addTurmas(Turma turma) {this.turmas.add(turma);}

    public void addProfessors(Professor professors) {this.professors.add(professors);}
    //-------------------MANIPULATION DATA--------------------------
    //---------------------PROCURA ESTUDANTE-------------------------------

    public boolean procuraEstudantes(){

        System.out.println("Enter your Id: ");
        int id = input.nextInt();
        System.out.println("Enter you password: ");
        String password = input.next();
        int low = 0;
        int higher = this.estudantes.size() - 1;
        while(low <= higher){
            int mid = (low + higher) / 2;
            if(this.estudantes.get(mid).getId() == id && Objects.equals(this.estudantes.get(mid).getPassword(), password)){
                System.out.println("Element found: " + this.estudantes.get(mid).getId());
                return true;
            }
            if(this.estudantes.get(mid).getId() < id){
                low = mid + 1;
            }
            if(this.estudantes.get(mid).getId() > id){
                higher = mid - 1;
            }
        }
        return false;
    }
    //------------------------PROCURA PROFESSOR-----------------------------------
    public boolean procuraProfessor(){
        System.out.println("Enter your id: ");
        int id = input.nextInt();
        System.out.println("Enter your password: ");
        String password = input.next();
        int low = 0;
        int higher = this.professors.size() - 1;
        while(low <= higher){
            int mid = (low + higher)/ 2;
            if(this.professors.get(mid).getId() == id && Objects.equals(this.professors.get(mid).getPassword(), password)){
                return true;
            }
            if(this.professors.get(mid).getId()< id){
                low = mid + 1;
            }
            if(this.professors.get(mid).getId() > id){
                higher = mid - 1;
            }
        }
        return false;
    }
    // -----------------CRIA ESTUDANTE-----------------
    public void criaEstudante(){
        int id = getEstudantes().size();
        if(id > 0){
            id = getEstudantes().get(id-1).getId() + 1;
        }else{
            id = 1;
        }
        System.out.println("Esse é o Seu ID: " + id);
        System.out.print("\nEntre com o seu nome: ");
        String nome = input.next();
        System.out.print("\nEntre com seu Curso:");
        String curso = input.next();
        System.out.print("\nEntre com sua Senha: ");
        String senha = input.next();
        Estudante estudante = new Estudante(id, nome, senha, curso);
        System.out.println("--CONTA CRIADA COM SUCESSO---");
        System.out.print("\nEscreva 'Sair': ");
        boolean keep = true;
        while(keep){
            char enter = input.next().charAt(0);
            if(enter != ' '){
                keep = false;
                addEstudantes(estudante);
            }
        }
    }
    // -----------------CRIAR PROFESSSOR ----------------------
    public void criaProfessor(){
        int id;
        if(getProfessors().size()-1 > 0){
            id = getProfessors().size() - 1;
        }else{
            id = 1;
        }
        System.out.println("Esse é o seu ID: "+ id);
        System.out.println("Enter your Name: ");
        String nome = input.next();
        System.out.println("Enter your Salary: ");
        float salario = input.nextInt();
        System.out.println("Enter you password: ");
        String senha = input.next();
        Professor professor = new Professor(id,name,password,salario);
        addProfessors(professor);
    }
}
