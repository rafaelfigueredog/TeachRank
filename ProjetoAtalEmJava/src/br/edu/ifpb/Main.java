package br.edu.ifpb;
import java.util.ArrayList;
import java.util.Scanner;
import br.edu.ifpb.domain.*;

public class Main {



    public static void main(String[] args) {

        int P, D;
        int maxCH = 20; // cargahoraria maxima configurável.

        Scanner input = new Scanner(System.in);
        AcademicControl aControl = new AcademicControl();

        D = Integer.parseInt( input.next() );
        P = Integer.parseInt( input.next() );


        for (int i = 0; i < D; i++) {
            String nome = input.next();
            int c  = Integer.parseInt( input.next() );
            int a  = Integer.parseInt( input.next() );
            int ir = Integer.parseInt( input.next() );
            aControl.addDisciplina(new Disciplina(nome, i, c, a, ir));
        }

        ArrayList<Integer> experience;
        Professor professor = null;
        for (int i = 0; i < P; i++) {
            String nome = input.next();
            Boolean g = Boolean.parseBoolean(input.next());
            Boolean c = Boolean.parseBoolean(input.next());
            experience = new ArrayList<Integer>();
            for (int j = 0; j < D; j++) {
                experience.add( Integer.parseInt( input.next() ) );
            }
            professor = new Professor(i, nome, g, c, maxCH);
            professor.setExperience(experience);
            aControl.addProfessor(professor);
        }


        for (Professor p :
                aControl.getProfessors()) {
            System.out.println(p.getNome() + "\t" + p.getCargaHoraria());
        }

        for (Disciplina d :
                aControl.getDisciplinas()) {
            System.out.println(d.getNome() + "\t" + d.getCargaDeTrabalho());
        }

    }
}
