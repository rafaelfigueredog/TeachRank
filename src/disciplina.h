#include <string>
#include <vector>
#include <stack>

class Disciplina {

    private:
        int codigo; 
        int cargaHoraria; 
        int creditos; 
        int periodo; 
        int numAlunos; 
        int numPrerequisitos;
         
        std::string nome; 
        std::vector<int> prerequisitos; 

    public:
        int nivelDificuldade; 

        Disciplina(std::string nome, int codigo, int numAlunos, int cargaHoraria, int periodo, int numPrerequisitos) {
            this->nome = nome; 
            this->cargaHoraria = cargaHoraria; 
            this->periodo = periodo; 
            this->numPrerequisitos = numPrerequisitos; 
            this->codigo = codigo; 
            this->numAlunos = numAlunos; 
            this->nivelDificuldade = (cargaHoraria / numAlunos) + (prerequisitos.size()*periodo); 
        }   

        Disciplina(std::string nome, int codigo, int numAlunos, int cargaHoraria, int periodo) {
            this->nome = nome; 
            this->cargaHoraria = cargaHoraria; 
            this->periodo = periodo; 
            this->codigo = codigo; 
            this->numAlunos = numAlunos; 
        }


        void addPrerequisitos(int p) {
            this->prerequisitos.push_back(p);
        }

        std::string getNome() {
            return this->nome; 
        }

        int getCodigo() {
            return this->codigo; 
        }

        int getDificuldade() {
            return this->nivelDificuldade;  
        }

        

        
}; 