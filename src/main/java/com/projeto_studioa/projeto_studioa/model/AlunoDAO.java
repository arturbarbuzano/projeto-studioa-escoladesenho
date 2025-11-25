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

    public void inserirAluno(Aluno aluno) 
    {
        try {
            String sql = "INSERT INTO Aluno(nome, cpf, tecnica) VALUES (?, ?, ?)";
            Object[] obj = { aluno.getNome(), aluno.getCpf(), aluno.getTecnica() };
            jdbc.update(sql, obj);
        } catch (Exception e) {
            throw new RuntimeException("CPF_DUPLICADO");
        }
    }

    public ArrayList<Aluno> listar()
    {
        String sql = "SELECT * FROM Aluno;";

        List<Map<String,Object>> mapa =  jdbc.queryForList(sql);

        return Conversao.converterAlunos(mapa);
    }

    public Aluno obterAluno(int id)
    {
        String sql ="SELECT * FROM Aluno where id=?";
        Map<String,Object> mapa = jdbc.queryForMap(sql, id);
        int idAluno = (Integer) mapa.get("id");
        String nome = (String) mapa.get("nome");
        String cpf = (String) mapa.get("cpf");
        String tecnica = (String) mapa.get("tecnica");
        Aluno aluno = new Aluno(idAluno,nome,cpf,tecnica);
        return aluno;
    }

    public void atualizarAluno(int id, Aluno aluno) {
    try {
        String sql = "UPDATE Aluno SET nome = ?, cpf = ?, tecnica = ? WHERE id = ?";
        Object[] obj = { aluno.getNome(), aluno.getCpf(), aluno.getTecnica(), id };
        jdbc.update(sql, obj);
    } catch (Exception e) {
        throw new RuntimeException("CPF_DUPLICADO");
    }
    }
}
