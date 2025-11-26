package com.projeto_studioa.projeto_studioa.model;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlunoService {


    @Autowired
    AlunoDAO alunoDAO;

    public void inserirAluno(Aluno aluno) 
    {
        try {
            alunoDAO.inserirAluno(aluno);
        } catch (RuntimeException e) {
            if (e.getMessage().equals("CPF_DUPLICADO")) {
            throw new RuntimeException("Este CPF já está inscrito!");
        }
        throw e;
        }
    }

    public void atualizarAluno(int id, Aluno aluno) {
        
        if (alunoDAO.cpfExisteParaOutroAluno(aluno.getCpf(), id)) {
            throw new RuntimeException("CPF_DUPLICADO");
        }

        alunoDAO.atualizarAluno(id, aluno);
    }

    public ArrayList<Aluno> listarAlunos()
    {
        return alunoDAO.listar();
    }

    public Aluno obterAluno(int id)
    {
        return alunoDAO.obterAluno(id);
    }

    public void deletar(int id)
    {
       alunoDAO.deletar(id);
    }
}
