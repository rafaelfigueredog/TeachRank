package br.edu.ifpb.domain;

public class Professor {
    private String matricula; 
    private String nome;
    private Integer cargaHorariaMax;
    private Boolean cargaHoraria;
    private Boolean gestor;
    private Boolean cordenador;

    public Professor(String matricula, String nome, Integer cargaHorariaMax, Boolean cargaHoraria, Boolean gestor, Boolean cordenador) {
        this.matricula = matricula;
        this.nome = nome;
        this.cargaHorariaMax = cargaHorariaMax;
        this.cargaHoraria = cargaHoraria;
        this.gestor = gestor;
        this.cordenador = cordenador;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getCargaHorariaMax() {
        return cargaHorariaMax;
    }

    public void setCargaHorariaMax(Integer cargaHorariaMax) {
        this.cargaHorariaMax = cargaHorariaMax;
    }

    public Boolean getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(Boolean cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public Boolean getGestor() {
        return gestor;
    }

    public void setGestor(Boolean gestor) {
        this.gestor = gestor;
    }

    public Boolean getCordenador() {
        return cordenador;
    }

    public void setCordenador(Boolean cordenador) {
        this.cordenador = cordenador;
    }
}
