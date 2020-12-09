package br.edu.ifpb.domain;

public class Disciplina {

    private String  nome;
    private Integer codigo;
    private int creditos;
    private int numAlunos;
    private int indiceReprovacao;
    private double  cargaDeTrabalho;

    public Disciplina(String nome, Integer codigo, int creditos, int numAlunos, int indiceReprovacao) {
        this.nome = nome;
        this.codigo = codigo;
        this.creditos = creditos;
        this.numAlunos = numAlunos;
        this.indiceReprovacao = indiceReprovacao;
        setCargaTrabalho(creditos, numAlunos, indiceReprovacao);
    }

    public void setCargaTrabalho(Integer C, Integer NA, Integer IR) {
        this.cargaDeTrabalho = (double) (C * 33 + NA * 33 + IR * 33) / 100;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
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
        return indiceReprovacao;
    }

    public void setIndeceReprovacao(Integer indeceReprovacao) {
        this.indiceReprovacao = indeceReprovacao;
    }

    public double getCargaDeTrabalho() {
        return cargaDeTrabalho;
    }


    @Override
    public String toString() {
        return nome;
    }
}
