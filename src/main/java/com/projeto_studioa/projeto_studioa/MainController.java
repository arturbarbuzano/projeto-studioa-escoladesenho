package com.projeto_studioa.projeto_studioa;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.projeto_studioa.projeto_studioa.model.Aluno;
import com.projeto_studioa.projeto_studioa.model.AlunoService;


@Controller
public class MainController {

    @Autowired
    private ApplicationContext context;

    @Autowired
    private AlunoService alunoService;

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
    try {
        alunoService.inserirAluno(aluno);
    } catch (RuntimeException e) {
        if (e.getMessage().contains("CPF")) {
            model.addAttribute("erro", "Este aluno já está inscrito e não pode se inscrever em mais de uma técnica!");
            return "inscricao"; 
        }
    }
    return "sucesso";
    }

    @GetMapping("/listar")
    public String listar(Model model){
        AlunoService alunoService = context.getBean(AlunoService.class);
        ArrayList<Aluno> alunos = alunoService.listarAlunos();
        model.addAttribute("alunos", alunos);
        return "listarAluno";

    }

    @GetMapping("/upd/inscricao/{id}")
    public String alunoUpd(Model model, @PathVariable int id){
        AlunoService alunoService = context.getBean(AlunoService.class);
        Aluno aluno = alunoService.obterAluno(id);
        model.addAttribute("aluno", aluno);
        model.addAttribute("id", id);
        return "mudarInscricao";
        
    }

    @PostMapping("/upd/inscricao/{id}")
    public String alunoUpd(
            Model model,
            @ModelAttribute Aluno aluno,
            @PathVariable int id) {

        try {
            alunoService.atualizarAluno(id, aluno);
        } catch (RuntimeException e) {

            if ("CPF_DUPLICADO".equals(e.getMessage())) {
                model.addAttribute("erro", "Este CPF já está cadastrado por outro aluno!");
                model.addAttribute("aluno", aluno);
                model.addAttribute("id", id);
                return "mudarInscricao";
            }
        }

        return "redirect:/listar";
    }

    @PostMapping("/del/inscricao/{id}")
    public String deletar(@PathVariable int id)
    {
        AlunoService alunoService = context.getBean(AlunoService.class);
        alunoService.deletar(id);
        return "redirect:/listar";
    }

}