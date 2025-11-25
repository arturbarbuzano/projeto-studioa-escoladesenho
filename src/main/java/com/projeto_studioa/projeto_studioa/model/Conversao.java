package com.projeto_studioa.projeto_studioa.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Conversao {

    public static ArrayList<Aluno> converterAlunos(List<Map<String,Object>> mapa)
    {
        ArrayList<Aluno> alunos = new ArrayList<>();

        for(Map<String,Object> registro : mapa){
            int id = (Integer) registro.get("id");
            String nome = (String) registro.get("nome");
            String cpf = (String) registro.get("cpf");
            String tecnica = (String) registro.get("tecnica");
            alunos.add(new Aluno(id,nome,cpf,tecnica));
        }
        
        return alunos;

    }

}
