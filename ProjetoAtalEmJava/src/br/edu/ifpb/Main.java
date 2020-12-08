package br.edu.ifpb;
import java.io.IOException;
import java.util.Vector;
import java.util.Scanner;
import br.edu.ifpb.domain.*;

public class Main {

    private static Scanner input = new Scanner(System.in);
    private Vector<Disciplina> vetorDisciplinas = new Vector<Disciplina>();
    
    public static void main(String[] args) throws IOException {
        Main sistema = new Main();
        
        int nDisciplinas;
        nDisciplinas = input.nextInt();
        
        for (int i=0; i < nDisciplinas; i++)
        {
            String nome = input.next();
            int C = input.nextInt();
            int NA = input.nextInt();
            int IR = input.nextInt();

            sistema.vetorDisciplinas.add(new Disciplina(nome, i+1, C, NA, IR));
        }

        for (int i=0; i < nDisciplinas; i++)
        {
            System.out.print("Nome: " + sistema.vetorDisciplinas.get(i).getNome() );
            System.out.print(" Codigo: " + sistema.vetorDisciplinas.get(i).getCodigo() );
            System.out.print(" Creditos: " + sistema.vetorDisciplinas.get(i).getCreditos() );
            System.out.print(" Num Alunos: " + sistema.vetorDisciplinas.get(i).getNumAlunos() );
            System.out.print(" Ind Reprovacao: " + sistema.vetorDisciplinas.get(i).getIndeceReprovacao() );
            System.out.println(" ===== " + sistema.vetorDisciplinas.get(i).getCargaDeTrabalho() );
        }
    }
}
