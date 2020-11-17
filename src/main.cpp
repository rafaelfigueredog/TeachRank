#include <iostream>
#include <vector>
#include "professor.h"
#include "disciplina.h"
#include <queue>
#include <algorithm>

using namespace std; 

/* bool compare( const Disciplina* &a, const Disciplina* &b ) {
    return a->nivelDificuldade < b->nivelDificuldade; 
} */

int main () {
    
    // N - Quantidade de Professores
    // D - Quantidade de Disciplinas
    // K - Quantidade de Prerequisitos

    int N, D, K; 
    int CHG, CHC, CHM; // CHG - Carga Horaria Gestão
                       // CHC - Carga Horária Coordenação
                       // CHM - Carga Horária Máxima

    cin >> CHM >> CHC >> CHG; 

    cin >> N;  

    std::vector<Professor*> professores; 
    std::vector<Disciplina*> disciplinas; 

    string nome; 
    int g, c, cha; 

    for (int i = 1; i <= N; i++) { 
        cin >> nome >> g >> c;
        
        // Verifica a carga horaria máxima de aulas de cada professor;  
        if (g == 1) cha = CHM - CHG;  
        else if ( c == 1 ) cha = CHM - CHC;
        else cha = CHM; 

        professores.push_back( new Professor(nome, i, c, g, cha) ); 
        
    }


    cin >> D; 
    int alunos, ch, sem, p, pi; 
    for (int i = 1; i <= D; i++) {
        cin >> nome >> ch >> alunos >> sem >> p; 
        disciplinas.push_back(new Disciplina(nome, i, alunos, ch, sem, p));
        for (int j = 0; j < p; j++) {
            cin >> pi; // pre
            disciplinas[i-1]->addPrerequisitos(pi); 
        }
    }

    /* for (int i = 0; i < professores.size(); i++)
        cout << professores[i]->getNome() << " " << professores[i]->getCargaHorariaMax() << "\n";   */

    /* for (int i = 0; i < D; i++) {
        cout << disciplinas[i]->getCodigo() << " " << disciplinas[i]->getNome() << "\n"; 
    } */

    sort(disciplinas.begin(), disciplinas.end()); 

    for (int i = 0; i < disciplinas.size(); i++) {
        cout << disciplinas[i]->getDificuldade() << " " << disciplinas[i]->getNome() << endl; 
    }
}