package br.edu.ifpb;
import java.io.*;
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

    public static void main(String[] args) throws IOException {

        int P, D;
        int CHM, CHC, CHG;
        Scanner input = new Scanner(System.in);

        D = input.nextInt();
        P = input.nextInt();
        CHM = input.nextInt();
        CHC = input.nextInt();
        CHG = input.nextInt();

        AcademicControl aControl = new AcademicControl(CHM, CHG, CHC,  D, P );

        for (int i = 0; i < D; i++) {
            input.nextLine(); // Proxima Linha
            String nome = input.nextLine();
            int c  = Integer.parseInt( input.next() );
            int a  = Integer.parseInt( input.next() );
            int ir = Integer.parseInt( input.next() );
            aControl.addDisciplina(new Disciplina(nome, i, c, a, ir));
        }

        ArrayList<Integer> experience;
        Professor professor = null;
        for (int i = 0; i < P; i++) {
            // String nome = input.next();
            // boolean g = convertToBoolean(input.next());
            // boolean c = convertToBoolean(input.next());
            experience = new ArrayList<Integer>();
            for (int j = 0; j < D; j++) {
                experience.add( Integer.parseInt( input.next() ) );
            }
            professor = new Professor(i, experience);
            aControl.addProfessor(professor);
        }

        aControl.defineCargaHoraria(); // Define carga horária de acordo com cargo administrativo
        aControl.contAptosPorDisciplina(); // Define conta o número de professores aptos e com carga horária disponível para cada disciplina
        aControl.showMatch();
        aControl.alocarDiciplinas();
        aControl.showResults();



    }


}
