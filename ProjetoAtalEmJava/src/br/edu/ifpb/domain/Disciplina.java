package br.edu.ifpb.domain;

public class Disciplina {

    private Integer codigo;
    private Integer cargaHoraria;
    private Integer creditos;
    private Integer periodo;
    private Integer numAlunos;
    private Integer numPrerequisitos;
    private Integer indeceReprovacao;
    private Integer nivelDificuldade;

    public Disciplina(Integer codigo, Integer cargaHoraria, Integer creditos, Integer periodo, Integer numAlunos, Integer numPrerequisitos, Integer indeceReprovacao, Integer nivelDificuldade) {
        this.codigo = codigo;
        this.cargaHoraria = cargaHoraria;
        this.creditos = creditos;
        this.periodo = periodo;
        this.numAlunos = numAlunos;
        this.numPrerequisitos = numPrerequisitos;
        this.indeceReprovacao = indeceReprovacao;
        this.nivelDificuldade = nivelDificuldade;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(Integer cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public Integer getCreditos() {
        return creditos;
    }

    public void setCreditos(Integer creditos) {
        this.creditos = creditos;
    }

    public Integer getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Integer periodo) {
        this.periodo = periodo;
    }

    public Integer getNumAlunos() {
        return numAlunos;
    }

    public void setNumAlunos(Integer numAlunos) {
        this.numAlunos = numAlunos;
    }

    public Integer getNumPrerequisitos() {
        return numPrerequisitos;
    }

    public void setNumPrerequisitos(Integer numPrerequisitos) {
        this.numPrerequisitos = numPrerequisitos;
    }

    public Integer getIndeceReprovacao() {
        return indeceReprovacao;
    }

    public void setIndeceReprovacao(Integer indeceReprovacao) {
        this.indeceReprovacao = indeceReprovacao;
    }

    public Integer getNivelDificuldade() {
        return nivelDificuldade;
    }

    public void setNivelDificuldade(Integer nivelDificuldade) {
        this.nivelDificuldade = nivelDificuldade;
    }
}
