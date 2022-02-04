package Entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class BancoDados {
    private final Scanner input = new Scanner(System.in);
    private final List<Professor> professors = new ArrayList<>();
    private final List<Curso> cursos = new ArrayList<>();
    private final List<Estudante> estudantes = new ArrayList<>();
    private final List<Turma> turmas = new ArrayList<>();
    private final Gerente manager = new Gerente();
    private String nome;
    private static double totalEmCaixa;
    private static double totalEmDivida;

    public BancoDados(String nome) {
        this.nome = nome;
        this.totalEmCaixa = 0;
        this.totalEmDivida = 0;

    }

    //=================== GETTER ========================
    public List<Professor> getProfessors() {return professors;}

    public List<Curso> getCursos() {
        return cursos;
    }

    public List<Turma> getTurmas() {
        return turmas;
    }

    public List<Estudante> getEstudantes() {
        return estudantes;
    }

    public Gerente getManager() {
        return manager;
    }

    public double pegarValorCaixa() {
        return totalEmCaixa;
    }

    public double pegarValorDivida() {
        if(totalEmDivida != calcularTotaldivida()){
            return calcularTotaldivida();
        }
        return totalEmDivida;
    }

    //================= SETTERS(ADD) ======================
    public double calcularTotaldivida() {// Calcular total da divida.
        totalEmDivida = 0;
        for (Professor professor : professors) {
            double quantidadeTurma = professor.getQuantidadeTurma();
            totalEmDivida = totalEmDivida + (quantidadeTurma * 400);
        }
        return totalEmDivida;
    }

    public void addCursos(Curso curso) {
        this.cursos.add(curso);
    }

    public void addEstudantes(Estudante estudante) {
        this.estudantes.add(estudante);
    }

    public void addTurmas(Turma turma) {
        this.turmas.add(turma);
    }

    public void addProfessors(Professor professors) {
        this.professors.add(professors);
    }

    // =================== MANIPULAÇÃO DE DADOS ===============================
    // =================== PROCURA ESTUDANTE =============================
    public int procurarEstudande() {
        System.out.print("\n\t\t\tDigite seu id: ");
        int id = input.nextInt();
        System.out.print("\n\t\t\tDigite sua senha: ");
        String password = input.next();
        int low = 0;
        int higher = getEstudantes().size() - 1;
        while (low <= higher) {
            int mid = (low + higher) / 2;
            if (getEstudantes().get(mid).getId() == id && Objects.equals(getEstudantes().get(mid).getSenha(), password)) {

                return mid;
            }
            if (getEstudantes().get(mid).getId() < id) {
                low = mid + 1;
            }
            if (getEstudantes().get(mid).getId() > id) {
                higher = mid - 1;
            }
        }
        return -1;
    }

    // ======================= PROCURA PROFESSOR ======================================
    public int procurarProfessor() {
        System.out.print("\n\t\t\tDigite seus ID: ");
        int id = input.nextInt();
        System.out.print("\n\t\t\tDigite sua senha: ");
        String password = input.next();
        int low = 0;
        int higher = getProfessors().size() - 1;
        while (low <= higher) {
            int mid = (low + higher) / 2;
            if (getProfessors().get(mid).getId() == id && Objects.equals(getProfessors().get(mid).getSenha(), password)) {

                return mid;
            }
            if (getProfessors().get(mid).getId() < id) {
                low = mid + 1;
            }
            if (getProfessors().get(mid).getId() > id) {
                higher = mid - 1;
            }
        }
        return -1;
    }

    //======================= PROCURAR ALUNO NA TURMA ==================================
    public void buscaAlunoTurma(int idTurma, int idAluno) {
        // EU VOU PEGAR A LISTA TURMA, E VOU PUSHAR O CONJUNTO ALUNO DE UM ID ESPECIFICO.
            for(int j=0; j<turmas.size();j++){
                if(turmas.get(idTurma-1).getConjuntoAluno().get(j).getId() == idAluno){
                    turmas.get(idTurma-1).getConjuntoAluno().get(j).receberNota();
                }
        }

    }


    //================== CRIAR ESTUDANTE ======================
    public void criaEstudante() {
        int id = getEstudantes().size();
        if (id > 0) {
            id = getEstudantes().get(id - 1).getId() + 1;
        } else {
            id = 1;
        }
        System.out.println("\t\t\tEsse é o Seu ID: " + id);
        System.out.print("\n\t\t\tEntre com o seu nome: ");
        String nome = input.next();
        System.out.print("\n\t\t\tEntre com seu Curso:");
        String curso = listaCurso();
        System.out.print("\n\t\t\tEntre com seu telefone:");
        String tell = input.next();
        System.out.print("\n\t\t\tEntre com seu email: ");
        String email = input.next();
        System.out.print("\n\t\t\tEntre com sua Senha: ");
        String senha = input.next();
        Estudante estudante = new Estudante(nome, email, id, tell, curso, senha);
        System.out.println("========== CONTA CRIADA COM SUCESSO ============");
        System.out.print("\n\t\t\tEscreva 'Sair': ");
        boolean keep = true;
        while (keep) {
            char enter = input.next().charAt(0);
            if (enter != ' ') {
                keep = false;
                addEstudantes(estudante);
            }
        }
    }

    // =================== CRIAR PROFESSSOR ========================
    public void criaProfessor() {
        int id = getProfessors().size();
        if (id > 0) {
            id = getProfessors().get(id - 1).getId() + 1;
        } else {
            id = 1;
        }
        System.out.print("\n\t\t\tEsse é o seu ID: " + id);
        System.out.print("\n\t\t\tDigite seu nome: ");
        String nome = input.next();
        System.out.print("\n\t\t\tDigite seu curso: ");
        String curso = listaCurso();
        System.out.print("\n\t\t\tDigite seu telefone: ");
        String tell = input.next();
        System.out.print("\n\t\t\tDigite o seu email: ");
        String email = input.next();
        System.out.print("\n\t\t\tDigite sua senha: ");
        String senha = input.next();
        Professor professor = new Professor(nome, email, id, tell, curso, senha);
        System.out.println("========== CONTA CRIADA COM SUCESSO ============");
        System.out.print("\n\t\t\tEscreva 'Sair': ");
        boolean keep = true;
        while (keep) {
            char enter = input.next().charAt(0);
            if (enter != ' ') {
                keep = false;
                addProfessors(professor);
            }
        }
    }

    // ================== ESTUDANTE PAGAR ========================
    public boolean pagarMensalidade(Estudante estudante) {
        if (estudante.verificarPagamento()) {
            System.out.println("\t\t\tVocê já efetuou o pagamento. ");
            return false;
        }
        estudante.mudePagamento();
        totalEmCaixa += 800;
        return true;
    }

    // ================= PAGAR PROFESSOR =========================
    public void pagarProfessor(Professor professor) {
        totalEmDivida = totalEmDivida - (professor.getQuantidadeTurma() * 400);
    }

    // ================== COLOCAR NOTA =======================
    public void professorColocaNota(Estudante estudante) {
        estudante.receberNota();
    }

    // ==================== COMANDOS DO GERENTE ========================
    public void criarCursos() {
        int id = getCursos().size();
        if (id > 0) {
            id = getCursos().get(id - 1).getId() + 1;
        } else {
            id = 1;
        }
        boolean continua = true;
        System.out.println("\t\t\tID DO CURSO: " + id);
        System.out.print("\n\t\t\tDigite o Nome do curso: ");
        String nomeCurso = input.nextLine();
        System.out.print("\n\t\t\tDigite a duração: ");
        String duracao = input.nextLine();
        Curso criandoCursos = new Curso(id, nomeCurso, duracao);
        cursos.add(criandoCursos);
    }
    //==================== LISTA DE CURSOS ============================
    public String listaCurso(){
        for(Curso curso: cursos){
            System.out.print("\n\t\t\t"+curso.getId()+ " - "+ curso.getNome());
        }
        System.out.print("\n\t\t\tEscolha um curso: ");
        int escolha = input.nextInt();
        return cursos.get(escolha-1).getNome();
    }
    // =================== CRIAR TURMAS ==============================
    public void criarTurmas() {
        if(cursos.size() != 0 && professors.size() != 0 && estudantes.size() != 0){
            int id;
            if (getTurmas().size() - 1 > 0) {
                id = getTurmas().size() - 1;
            } else {
                id = 1;
            }

            String nomeCurso = listaCurso();
            Turma turma = new Turma(id, nomeCurso);
            if((estudantes.size() % 3) - turmas.size() * 3 > 0){
                int cont = 0;
                for(Estudante estudante: estudantes){
                    if(!estudante.getTemSala() && Objects.equals(estudante.getCurso(), nomeCurso)){
                        if(cont < 3){
                            turma.addEstudante(estudante);
                            cont++;
                        }else{
                            break;
                        }
                    }
                }
                cont = 0;
                for(Professor professor: professors){
                    if(Objects.equals(professor.getCurso(), nomeCurso) && professor.getQuantidadeTurma() == 0){
                        if(cont < 1){
                            turma.addProfessor(professor);
                            professor.addQuantidadeTurma();
                            cont++;
                        }else{
                            break;
                        }
                    }
                }
                turmas.add(turma);
                System.out.println("=========== TURMA CRIADA COM SUCESSO =============");
            }
        }
        else{
            System.out.println("===== Você tem poucos estudantes, professores e não definiu nenhum curso! ========");
        }
    }
}
