package br.edu.ifpb.domain;
import java.util.HashMap;

public class AcademicControl {

    // HashMap1: K: MatriculaProfessor V: HashMap2
    // HashMap2: K: ID da disciplina V: Competencia

    private HashMap controle;

    public AcademicControl() {
        this.controle = new HashMap<Integer, HashMap<Integer, Integer>>();
    }

    public HashMap getControle(){
        return controle;
    }
}
