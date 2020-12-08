package br.edu.ifpb.domain;

public class Disciplina {

    private String nome;
    private Integer creditos;
    private Integer numAlunos;
    private Integer indeceReprovacao;
    private Integer cargaDeTrabalho;

    public Disciplina(String nome, Integer creditos, Integer numAlunos, Integer indeceReprovacao, Integer cargaDeTrabalho) {
        this.nome = nome;
        this.creditos = creditos;
        this.numAlunos = numAlunos;
        this.indeceReprovacao = indeceReprovacao;
        this.cargaDeTrabalho = cargaDeTrabalho;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getCreditos() {
        return creditos;
    }

    public void setCreditos(Integer creditos) {
        this.creditos = creditos;
    }

    public Integer getNumAlunos() {
        return numAlunos;
    }

    public void setNumAlunos(Integer numAlunos) {
        this.numAlunos = numAlunos;
    }

    public Integer getIndeceReprovacao() {
        return indeceReprovacao;
    }

    public void setIndeceReprovacao(Integer indeceReprovacao) {
        this.indeceReprovacao = indeceReprovacao;
    }

    public Integer getCargaDeTrabalho() {
        return cargaDeTrabalho;
    }

    public void setCargaDeTrabalho(Integer cargaDeTrabalho) {
        this.cargaDeTrabalho = cargaDeTrabalho;
    }
}
