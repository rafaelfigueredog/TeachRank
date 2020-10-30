#include <string>
#include <vector>

class Disciplina {

    private:
        int codigo; 
        int cargaHoraria; 
        int creditos; 
        int periodo; 
        int numAlunos; 
        std::string nome; 
        std::vector<int> prerequisitos; 

    public:


        Disciplina(std::string nome, int codigo, int numAlunos, int cargaHoraria, int periodo, std::vector<int> prerequisitos) {
            this->nome = nome; 
            this->cargaHoraria = cargaHoraria; 
            this->periodo = periodo; 
            this->prerequisitos = prerequisitos; 
            this->codigo = codigo; 
            this->numAlunos = numAlunos; 
        }

        Disciplina(std::string nome, int codigo, int numAlunos, int cargaHoraria, int periodo) {
            this->nome = nome; 
            this->cargaHoraria = cargaHoraria; 
            this->periodo = periodo; 
            this->codigo = codigo; 
            this->numAlunos = numAlunos; 
        }




}; 