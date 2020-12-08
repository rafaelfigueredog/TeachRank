package br.edu.ifpb.domain;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicReference;

public class AcademicControl {

    private Integer cHMax;
    private Integer cHGestao;
    private Integer cHCordenacao;
    private ArrayList<Professor> professors;
    private ArrayList<Disciplina> disciplinas;
    private int[][] matriz;

    public AcademicControl(Integer cHMax, Integer cHGestao, Integer cHCordenacao) {
        this.cHMax = cHMax;
        this.cHGestao = cHGestao;
        this.cHCordenacao = cHCordenacao;
        this.professors = new ArrayList<Professor>();
        this.disciplinas = new ArrayList<Disciplina>();
    }

    public void addProfessor(Professor professor) {
        this.professors.add(professor);
    }
    public void addDisciplina(Disciplina disciplina) {
        this.disciplinas.add(disciplina);
    }

    public ArrayList<Professor> getProfessors() {
        return professors;
    }

    public ArrayList<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void defineCargaHoraria() {
        Professor professor;
        for ( int i = 0; i < professors.size(); i++ ) {
            professor = professors.get(i);
            if (professor.isCordenador()) {
                Integer ch = this.cHMax - this.cHCordenacao;
                professor.setCargaHoraria(ch);
            }

            else if (professor.isGestor()) {
                Integer ch = this.cHMax - this.cHGestao;
                professor.setCargaHoraria(ch);
            }

            else {
                professor.setCargaHoraria(cHMax);
            }


            professors.set(i, professor);

        }
    }

    private void swap( int i, int j, int k) {
        int aux = matriz[k][i];
        matriz[k][i] = matriz[k][j];
        matriz[k][j] = aux;
    }
    /*
    private void permutation(int l, int h, int P) {
        if (l == h) {
            show(matriz, P+1, h+1);
        } else {
            for (int i = l; i <= h; i++) {
                swap(i, l, P);
                permutation(l+1, h, P);
                swap(i, l, P);
            }
        }
    }

    private void permutationsHelperFunction(int P, int D) {
        for (int p = 0; p < P; p++) {
            permutation(0,D-1, p);
        }                
    }
    */
    private void show(int[][] matrix, int P, int D) {
        for (int i = 0; i < P; i++) {
            for (int j = 0; j < D; j++) {
                System.out.printf("%d ", matrix[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
    /*
    public void alocarDisciplinas() {
        int P = professors.size();
        int D = disciplinas.size();

        matriz = new int[P][D];

        Professor professor;
        for (int i = 0; i < professors.size(); i++) {
            professor = professors.get(i);
            for (int j = 0; j < professor.getExperience().size(); j++) {
                matriz[i][j] = professor.getExperience().get(j);
            }
        }

        show(matriz, P, D);
        permutationsHelperFunction(P, D);

    }
    */

    public void alocarDiciplinas(int P, int D) {

        PriorityQueue<Professor> professorPQ = new PriorityQueue<Professor>();
        PriorityQueue<Disciplina> DisciplinaPQ; new PriorityQueue<Disciplina>()


    }

}
