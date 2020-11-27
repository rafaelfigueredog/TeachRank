#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>



struct Disciplina { 

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
        Disciplina(std::string _nome, int _codigo, int _numAlunos, int _cargaHoraria, int _periodo, int _numPrerequisitos):  
            nome(_nome), 
            codigo(_codigo),
            cargaHoraria(_cargaHoraria), 
            periodo(_periodo), 
            prerequisitos(_numPrerequisitos)
        {};  

        Disciplina(std::string _nome, int _codigo, int _numAlunos, int _cargaHoraria, int _periodo):  
            nome(_nome), 
            codigo(_codigo),
            cargaHoraria(_cargaHoraria), 
            periodo(_periodo)
        {}; 

        std::string getNome() {
            return this->nome; 
        }
        int getCodigo() {
            return this->codigo; 
        }

        void addPrerequisitos(int p){
            this->prerequisitos.push_back(p); 
        } 
};

struct Professor {

    private: 
        int matricula; 
        int cargaHorariaAulas; 
        int cargaHorariaMax; 
        bool gestor; 
        bool coordenador; 
        std::string nome; 


    public:
        

        Professor() {
            this->cargaHorariaAulas = 0; 
            this->cargaHorariaMax = 16; 
            this->gestor = false; 
            this->coordenador = false; 
        }

        Professor(std::string nome, int matricula,  bool cordenador, bool gestor, int cargaHorariaMax){
            this->nome = nome; 
            this->cargaHorariaAulas = 0; 
            this->matricula = matricula; 
            this->cargaHorariaMax = cargaHorariaMax; 
            this->coordenador = cordenador == 1? true: false ;
            this->gestor = gestor == 1? true : false; 
            
        }


        std::string getNome() {
            return this->nome; 
        }

        int getCargaHorariaMax() {
            return this->cargaHorariaMax; 
        }


}; 
