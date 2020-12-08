package br.edu.ifpb.domain;

import java.util.ArrayList;

public class Professor {

    private String  nome;
    private Integer matricula;
    private Boolean gestor;
    private Boolean cordenador;
    private Integer cargaHoraria;
    private ArrayList<Integer> experience;

    public ArrayList<Integer> getExperience() {
        return experience;
    }

    public void setExperience(ArrayList<Integer> experience) {
        this.experience = experience;
    }

    public Professor(Integer matricula, String nome, Boolean gestor, Boolean cordenador, int maxCH) {
        this.matricula = matricula;
        this.nome = nome;
        this.gestor = gestor;
        this.cordenador = cordenador;
        setCargaHoraria(maxCH);
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    private void setCargaHoraria(int cargaHorariaMax) {
        if (!cordenador && !gestor ) {
            this.cargaHoraria = cargaHorariaMax;
        } else if ( cordenador && !gestor ) {
            this.cargaHoraria = cargaHorariaMax - 8;
        } else {
            this.cargaHoraria = 0;
        }
    }

    public Integer getMatricula() {
        return matricula;
    }

    public Integer getCargaHoraria() {
        return cargaHoraria;
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

    @Override
    public String toString() {
        return this.nome;
    }
}
