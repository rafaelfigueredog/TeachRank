package br.edu.ifpb.domain;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class AcademicControl {

    private Integer cHMax;
    private Integer cHGestao;
    private Integer cHCordenacao;
    private Integer P; // quantidade de professores;
    private Integer D; // quantidade de disciplinas;
    private ArrayList<Professor> professors;
    private ArrayList<Disciplina> disciplinas;
    private HashMap<Professor, ArrayList<Disciplina>> gestaoDeEnsino;
    private ArrayList<ArrayList<Integer>> match;
    private ArrayList<Pair<Integer, Integer>> PD; // prioridade das disciplinas


    public AcademicControl(Integer cHMax, Integer cHGestao,  Integer cHCordenacao, int D, int P) {
        this.cHMax = cHMax;
        this.cHGestao = cHGestao;
        this.cHCordenacao = cHCordenacao;
        this.P = P;
        this.D = D;
        this.professors = new ArrayList<Professor>();
        this.disciplinas = new ArrayList<Disciplina>();
        this.gestaoDeEnsino = new HashMap<Professor, ArrayList<Disciplina>>();
        this.match = new ArrayList<ArrayList<Integer>>(D);
        this.PD = new ArrayList<Pair<Integer, Integer>>(D);

        for (int i = 0; i < D; i++) {
            PD.add(new Pair<>(i, 0));
        }

    }

    public void addProfessor(Professor professor) {
        this.professors.add(professor);
        for (int i = 0; i < professor.getExperience().size(); i++) {
            if (professor.getExperience().get(i) > 3 ) {
                match.get(i).add(professor.getMatricula());
                PD.set(i, new Pair<>(PD.get(i).getKey(), PD.get(i).getValue()+1));
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

    public void vizualizarProfessoresAptosPorDisciplina() {
        List<Pair<Integer, Integer>> sortPD =
        Collections.sort(sortPD);


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
            System.out.println(professors.get(i).getCargaHoraria());
        }
    }

    public void alocarDiciplinas(int P, int D) {

    }





}
