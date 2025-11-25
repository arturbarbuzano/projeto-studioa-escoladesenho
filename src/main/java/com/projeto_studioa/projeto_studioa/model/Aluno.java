package com.projeto_studioa.projeto_studioa.model;

public class Aluno {

    private int id;
    private String nome, cpf, tecnica;

    //Formulario
    public Aluno() {

    }

    //Select
    public Aluno(int id, String nome, String cpf, String tecnica) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.tecnica = tecnica;
    }

    //Insert
    public Aluno (String nome, String cpf, String tecnica) {
        this.nome = nome;
        this.cpf = cpf;
        this.tecnica = tecnica;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCpf(){
        return cpf;
    }
    public void setCpf(String cpf)
    {
        this.cpf = cpf;
    }
    public String getTecnica() {
        return tecnica;
    }
    public void setTecnica(String tecnica) {
        this.tecnica = tecnica;
    }

}
