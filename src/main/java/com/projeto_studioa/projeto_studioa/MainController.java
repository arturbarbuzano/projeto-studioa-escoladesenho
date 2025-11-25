package com.projeto_studioa.projeto_studioa;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.projeto_studioa.projeto_studioa.model.Aluno;
import com.projeto_studioa.projeto_studioa.model.AlunoService;


@Controller
public class MainController {

    @Autowired
    private ApplicationContext context;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/cartoon")
    public String cartoon() {
        return "cartoon";
    }

    @GetMapping("/manga")
    public String manga() {
        return "manga";
    }

    @GetMapping("/realismo")
    public String realismo() {
        return "realismo";
    }

    @GetMapping("/arearestrita")
    public String arearestrita() {
        return "arearestrita";
    }

    @GetMapping("/inscricao")
    public String aluno(Model model){
        model.addAttribute("aluno", new Aluno());
        return "inscricao";
        
    }

    @PostMapping("/inscricao")
    public String aluno(Model model, @ModelAttribute Aluno aluno){
        AlunoService alunoService = context.getBean(AlunoService.class);
        alunoService.inserirAluno(aluno);
        return "sucesso";

    }

    @GetMapping("/listar")
    public String listar(Model model){
        AlunoService alunoService = context.getBean(AlunoService.class);
        ArrayList<Aluno> alunos = alunoService.listarAlunos();
        model.addAttribute("alunos", alunos);
        return "listarAluno";

    }
}