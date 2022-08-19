package me.dio.academia.digital.controller;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AlunoForm;
import me.dio.academia.digital.entity.form.AlunoUpdateForm;
import me.dio.academia.digital.service.impl.AlunoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
    @Autowired
    private AlunoServiceImpl service;
    private Long idAluno;
    private AlunoUpdateForm form;

    @GetMapping
    public List<Aluno> listarAlunos(){
        return service.getAll();
    }

    @PostMapping
    public Aluno inserirAluno(@Valid @RequestBody AlunoForm form) {
        return service.create(form);
    }

    @PostMapping("/atualizar/{id}")
    public Aluno alterarAluno(@Valid @PathVariable Long idAluno, @RequestBody AlunoUpdateForm form) {
        return service.update(idAluno, form);
    }

    @GetMapping("/avaliacoes/{id}")
    public List<AvaliacaoFisica> getAllAvaliacaoFisicaPorAlunoId(@PathVariable Long alunoId){

        return service.getAllAvaliacaoFisicaPorAlunoId(alunoId);
    }

    @GetMapping("/filtro")
    public List<Aluno> filtrarAlunosPorDataDeAniversario(@RequestParam(value = "dataDeNascimento", required = true) String dataDeNascimento){
        return service.filtrarAlunosPorDataDeNascimento(dataDeNascimento);
    }

    @DeleteMapping("{id}")
    public void deleteAluno(@PathVariable Long id){
        service.delete(id);
    }
}
