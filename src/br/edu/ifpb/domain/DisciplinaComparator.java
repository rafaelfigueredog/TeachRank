package br.edu.ifpb.domain;

import java.util.Comparator;

public class DisciplinaComparator implements Comparator<Disciplina> {

    @Override
    public int compare(Disciplina disciplina, Disciplina other) {
        if (disciplina.getCargaDeTrabalho() == other.getCargaDeTrabalho())
            return 0;
        return disciplina.getCargaDeTrabalho() > other.getCargaDeTrabalho()? -1: 1;
    }
}
