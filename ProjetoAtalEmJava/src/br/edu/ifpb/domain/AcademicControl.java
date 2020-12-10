package br.edu.ifpb.domain;
import java.util.*;

public class AcademicControl {

    private Integer CHM;
    private Integer CHG;
    private Integer CHC;

    private Integer P; // quantidade de professores;
    private Integer D; // quantidade de disciplinas;

    private ArrayList<Professor> professors;
    private ArrayList<Disciplina> disciplinas;
    private HashMap<Professor, ArrayList<Disciplina>> gestaoDeEnsino;
    private ArrayList<ArrayList<Integer>> match;
    private PriorityQueue<Pair> PD; // prioridade das disciplinas


    public AcademicControl(Integer CHM, Integer CHG,  Integer CHC, int D, int P) {
        this.P = P;
        this.D = D;

        this.CHM = CHM; // Carga Horaria Máxima
        this.CHG = CHG; // Carga Horária Gestão
        this.CHC = CHC; // Carga Horária Cordenação

        this.professors = new ArrayList<Professor>();
        this.disciplinas = new ArrayList<Disciplina>();
        this.gestaoDeEnsino = new HashMap<Professor, ArrayList<Disciplina>>();
        this.match = new ArrayList<ArrayList<Integer>>(D);
        this.PD = new PriorityQueue<Pair>(D, new PairComparator());

        for (int i = 0; i < D; i++) {
            match.add(new ArrayList<Integer>());
        }

    }

    public PriorityQueue<Pair> getPD() {
        return PD;
    }

    public void setPD(PriorityQueue<Pair> PD) {
        this.PD = PD;
    }

    public void addProfessor(Professor professor) {
        this.professors.add(professor);
        for (int i = 0; i < professor.getExperience().size(); i++) {
            if (professor.getExperience().get(i) > 3 ) {
                match.get(i).add( professor.getMatricula() );
            }
        }
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


    public void contAptosPorDisciplina() {
        for (int i = 0; i < match.size(); i++) {
            PD.add(new Pair(i, match.get(i).size()));
        }
    }

    public void showMatch() {
        for (int i = 0; i < match.size(); i++) {
            System.out.print(disciplinas.get(i) + ":\t");
            for (int j = 0; j < match.get(i).size(); j++) {
                System.out.printf("(%s, %d)\t", professors.get(match.get(i).get(j)).getNome(), professors.get(match.get(i).get(j)).getExperience().get(i) );
            }
            System.out.println();
        }
    }

    public void showPairs() {
        PriorityQueue<Pair> pquee = this.getPD();
        while (!pquee.isEmpty()) {
            System.out.println(pquee.peek());
            pquee.poll();
        }

    }

    public void defineCargaHoraria() {
        Professor professor;
        for ( int i = 0; i < professors.size(); i++ ) {
            professor = professors.get(i);
            if (professor.isCordenador()) {
                Integer ch = this.CHM - this.CHC;
                professor.setCargaHoraria(ch);
            }

            else if (professor.isGestor()) {
                Integer ch = this.CHM - this.CHG;
                professor.setCargaHoraria(ch);
            }

            else {
                professor.setCargaHoraria(CHM);
            }


            professors.set(i, professor);
            // System.out.println(professors.get(i).getNome() + " " + professors.get(i).getCargaHoraria());
        }
    }


    public void alocarDiciplinas() {

        PriorityQueue<Pair> pqueue = this->getPD();

        while (! pqueue.isEmpty() ) {
            // peguei a disciplina;
            Pair pair = pqueue.poll();

            for (int i = 0; i < match.get(pair.index).size(); i++) {

                if ( )

            }
        }
    }






}
