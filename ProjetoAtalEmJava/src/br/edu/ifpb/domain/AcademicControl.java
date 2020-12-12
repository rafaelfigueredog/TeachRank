package br.edu.ifpb.domain;
import java.util.*;

public class AcademicControl {
    // Variáveis de Controle
    private Integer CHM; // Carga Horária Máxima
    private Integer CHG; // Garga Horária Gestão
    private Integer CHC; // Garga Horária Coordenaçao
    private Integer THCA; // Total de horas nos usadas nos cargos administrativos
    private Integer THPD; // Total de horas disponível para disciplinas
    private Integer THND; // Total de horas total necessárias p/ Disciplinas
    private Integer P; // quantidade de professores;
    private Integer D; // quantidade de disciplinas;
    private ArrayList<Professor> professors;
    private ArrayList<Disciplina> disciplinas;
    private ArrayList<ArrayList<Integer>> alocaçãoDeProfessores;
    private ArrayList<ArrayList<Integer>> match;
    private PriorityQueue<Pair> PD; // prioridade das disciplinas
    private ArrayList<Integer> disciplinaSemProfessores;

    public ArrayList<ArrayList<Integer>> getAlocaçãoDeProfessores() {
        return alocaçãoDeProfessores;
    }

    public AcademicControl(Integer CHM, Integer CHG,  Integer CHC, int D, int P) {
        this.P = P;
        this.D = D;

        this.CHM = CHM; // Carga Horaria Máxima
        this.CHG = CHG; // Carga Horária Gestão
        this.CHC = CHC; // Carga Horária Cordenação

        // Variáveis de Controle
        THCA = 0;
        THPD = 0;
        THND = 0;

        this.professors = new ArrayList<Professor>();
        this.disciplinas = new ArrayList<Disciplina>();
        this.alocaçãoDeProfessores = new ArrayList<ArrayList<Integer>>();
        this.match = new ArrayList<ArrayList<Integer>>(D);
        this.PD = new PriorityQueue<Pair>(D, new PairComparator());
        this.disciplinaSemProfessores = new ArrayList<Integer>();

        for (int i = 0; i < D; i++) {
            match.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < P; i++) {
            alocaçãoDeProfessores.add(new ArrayList<Integer>());
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
            if (professor.getExperience().get(i) >= 3 ) {
                match.get(i).add( professor.getMatricula() );
            }
        }
        this.THPD += 20;
    }
    public void addDisciplina(Disciplina disciplina) {
        this.disciplinas.add(disciplina);
        THND += disciplina.getCreditos();
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
                System.out.printf("(%s, %d)\t", professors.get(match.get(i).get(j)).getMatricula(), professors.get(match.get(i).get(j)).getExperience().get(i) );
            }
            System.out.println();
        }
    }


    public void defineCargaHoraria() {
        Professor professor;
        for ( int i = 0; i < professors.size(); i++ ) {
            professor = professors.get(i);
            if (professor.isCordenador()) {
                THCA += this.CHC;
                THPD -= this.CHC;
                Integer ch = this.CHM - this.CHC;
                professor.setCargaHoraria(ch);
                professor.setCargaDeTrabalho(20.0);
            }

            else if (professor.isGestor()) {
                THCA += this.CHG;
                THPD -= this.CHG;
                Integer ch = this.CHM - this.CHG;
                professor.setCargaHoraria(ch);
                professor.setCargaDeTrabalho(50.0);
            }

            else {
                professor.setCargaHoraria(CHM);
            }


            professors.set(i, professor);
            // System.out.println(professors.get(i).getNome() + " " + professors.get(i).getCargaHoraria());
        }
    }


    public void showResults( ) {
        System.out.println("\n\t-  Results -\t\n");
        ArrayList<Integer> arr;
        for(int i = 0; i < alocaçãoDeProfessores.size(); i++ ) {
            Professor p = professors.get(i);
            System.out.printf("Prof. %d:\tCH: %d\tCT: %.2f\n", p.getMatricula(), p.getCargaHoraria(), p.getCargaDeTrabalho());

            for (Integer id : arr = alocaçãoDeProfessores.get(i)) {
                System.out.printf("A: %d\t\t%s\n", professors.get(i).getExperience().get(id),  disciplinas.get(id));
            }
            System.out.println();
        }

        if (!disciplinaSemProfessores.isEmpty()) {
            System.out.println("\nAlgumas disciplinas em professores:\n");
            for (Integer d: disciplinaSemProfessores) {
                System.out.println(disciplinas.get(d));
            }
        }
    }

    private void showPriority(PriorityQueue<Professor> pqueue, int index) {
        System.out.println("\n" + disciplinas.get(index));
        while (!pqueue.isEmpty()) {
            Professor p = pqueue.poll();
            System.out.printf("Prof:\t%d\t\tCH:\t%d\t\tA:\t%d\t\tCT:\t%.2f\n",
                    p.getMatricula(),
                    p.getCargaHoraria(),
                    p.getExperience().get(index),
                    p.getCargaDeTrabalho());
        }
        System.out.println();
    }

    public void alocarDiciplinas() {
        

        if ( THPD == 0 )  {
            System.out.println(" Impossível! Contrate professores. ");
            return;
        }

        if ( THND > THPD ) {
            System.out.println( "Vamos nos esforçar...\n " +
                                "Mas será necessário contratar mais professores, \n" +
                                "para cobrir todas as disciplinas.");
        }


        PriorityQueue<Pair> pqueue = this.getPD();
        Pair pair;
        PriorityQueue<Professor> pqueueProfessor;
        while (!pqueue.isEmpty() || !(THPD >= THND) ) {
            // peguei a disciplina;
            pair = pqueue.poll();
            pqueueProfessor = new PriorityQueue<Professor>(new ProfessorComparator(pair.index));
            if ( pair.value == professors.size() + 1 ) {
                for (int i = 0; i < match.get(pair.index).size(); i++) {
                    Professor p = professors.get(match.get(pair.index).get(i));
                    // só entra na fila de prioridade se
                    // o professor tiver o mínimo de carga horária
                    if ( p.getCargaHoraria() >= disciplinas.get(pair.index).getCreditos())
                        if (p.getExperience().get(pair.index) >= 2)
                            pqueueProfessor.add(p);

                }

            } else {
                for (int i = 0; i < professors.size(); i++) {
                    Professor p = professors.get(i);
                    // só entra na fila de prioridade se
                    // o professor tiver o mínimo de carga horária
                    if ( p.getCargaHoraria() >= disciplinas.get(pair.index).getCreditos())
                        pqueueProfessor.add(p);
                }
            }
            // Na lista match nenhum professor tinha carga horária suficiente.
            // A disciplina volta para o final da fila.
            if (pqueueProfessor.isEmpty()) {
                // se a pesquisa foi feita apenas na lista match;
                if (pair.value != professors.size()) {
                    pair.value  = professors.size() + 1;
                    pqueue.add(pair);
                }
                else {
                    disciplinaSemProfessores.add(pair.index); 
                }
            }

            else {
                assert pqueueProfessor.peek() != null;
                Professor p = pqueueProfessor.peek();

                System.out.println("CH Professores: " + THPD);
                System.out.println("CH Disciplinas Restantes: " + THND);
                showPriority(pqueueProfessor, pair.index);

                ArrayList<Integer> arr = alocaçãoDeProfessores.get(p.getMatricula());
                arr.add(pair.index);
                alocaçãoDeProfessores.set(p.getMatricula(), arr);

                // ajustes no controle;

                Disciplina d = this.disciplinas.get(pair.index);
                this.THPD -= d.getCreditos();
                this.THND -= d.getCreditos();
                p.setAlunos(p.getAlunos() + d.getNumAlunos());
                p.setCargaHoraria((p.getCargaHoraria() - d.getCreditos()));
                p.setCargaDeTrabalho((p.getCargaDeTrabalho() + d.getCargaDeTrabalho()));
                professors.set(p.getMatricula(), p);



            }

            pqueueProfessor.clear();

        }

    }






}
