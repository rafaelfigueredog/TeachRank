#include <string> 

class Professor {

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