#include <iostream>
#include <vector>
#include "professor.h"
#include "disciplina.h"

using namespace std; 

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

    for (int i = 0; i < professores.size(); i++)
        cout << professores[i]->getNome() << " " << professores[i]->getCargaHorariaMax() << "\n";  



}