package br.edu.ifpb.domain;

import java.util.Comparator;

public class ProfessorComparator implements Comparator<Professor> {

    public int disciplina;

    public ProfessorComparator(int disciplina) {
        this.disciplina = disciplina;
    }

    @Override
    public int compare(Professor professor, Professor other) {

        int E1 = professor.getExperience().get(disciplina);
        int cH1 = professor.getCargaHoraria();
        int cT1 = professor.getCargaDeTrabalho();
        int E2 = other.getExperience().get(disciplina);
        int cH2 = other.getCargaHoraria();
        int cT2 = other.getCargaDeTrabalho();

        if (E1 == E2) {
            if (cH1 ==  cH2) {
              if (cT1 == cT2) return 0;
              return (cT1 > cT2) ? -1 : 1;
            }
            return cH1 > cH2?  1 :  -1;
        }
        return cT1 > cT2? 1 : -1;
    }
}
