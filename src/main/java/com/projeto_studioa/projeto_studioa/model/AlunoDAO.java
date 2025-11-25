package com.projeto_studioa.projeto_studioa.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;

@Repository
public class AlunoDAO {

    @Autowired
    DataSource dataSource;
    
    JdbcTemplate jdbc;

    @PostConstruct
    private void initialize() {
        jdbc = new JdbcTemplate(dataSource);
    }

    public void inserirAluno(Aluno aluno) {
        String sql = "INSERT INTO Aluno(nome, cpf, tecnica) VALUES (?, ?, ?)";
        Object[] obj = new Object[3];
        obj[0] = aluno.getNome();
        obj[1] = aluno.getCpf();
        obj[2] = aluno.getTecnica();
        jdbc.update(sql, obj);
    }

    public ArrayList<Aluno> listar()
    {
        String sql = "SELECT * FROM Aluno;";

        List<Map<String,Object>> mapa =  jdbc.queryForList(sql);

        return Conversao.converterAlunos(mapa);
    }
}
