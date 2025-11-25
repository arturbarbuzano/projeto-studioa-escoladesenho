package com.projeto_studioa.projeto_studioa.model;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlunoService {


    @Autowired
    AlunoDAO alunoDAO;

    public void inserirAluno(Aluno aluno) {
        alunoDAO.inserirAluno(aluno);
    }

    public ArrayList<Aluno> listarAlunos()
    {
        return alunoDAO.listar();
    }
}
