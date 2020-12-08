package br.edu.ifpb;
import java.util.ArrayList;
import java.util.Scanner;
import br.edu.ifpb.domain.*;

public class Main {

    private static boolean convertToBoolean(String value) {
        boolean returnValue = false;
        if ("1".equalsIgnoreCase(value) || "yes".equalsIgnoreCase(value) ||
                "y".equalsIgnoreCase(value) || "S".equalsIgnoreCase(value))
            returnValue = true;
        return returnValue;
    }

    public static void main(String[] args) {

        int P, D;
        int maxCH = 20; // cargahoraria maxima configurável.

        Scanner input = new Scanner(System.in);
        AcademicControl aControl = new AcademicControl(18, 8, 8 );

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
            boolean g = convertToBoolean(input.next());
            boolean c = convertToBoolean(input.next());
            experience = new ArrayList<Integer>();
            for (int j = 0; j < D; j++) {
                experience.add( Integer.parseInt( input.next() ) );
            }
            professor = new Professor(i, nome, g, c);
            professor.setExperience(experience);
            aControl.addProfessor(professor);
        }

        aControl.defineCargaHoraria();
        aControl.alocarDisciplinas();

    }


}
