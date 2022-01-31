package Entities;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BancoDados {
    private Scanner input = new Scanner(System.in);
    private List<Professor> professors = new ArrayList<>();
    private List<Curso> cursos = new ArrayList<>();
    private List<Estudante> estudantes = new ArrayList<>();
    private List<Turma> turmas = new ArrayList<>();

    public BancoDados(){

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
}
