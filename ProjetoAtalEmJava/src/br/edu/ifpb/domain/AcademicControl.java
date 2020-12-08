package br.edu.ifpb.domain;
import java.util.ArrayList;

public class AcademicControl {

    private ArrayList<Professor> professors;
    private ArrayList<Disciplina> disciplinas;

    public AcademicControl() {
        this.disciplinas = new ArrayList<Disciplina>();
        this.professors = new ArrayList<Professor>();
    }

    public void addProfessor(Professor professor) {
        this.professors.add(professor);
    }
    public void addDisciplina(Disciplina disciplina) {
        this.disciplinas.add(disciplina);
    }

}
