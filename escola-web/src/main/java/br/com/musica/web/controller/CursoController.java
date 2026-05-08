package br.com.musica.web.controller;

import br.com.musica.web.model.Curso;
import br.com.musica.web.service.CursoService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CursoController {

    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @GetMapping("/")
    public String home() {
        return "redirect:/cursos";
    }

    @GetMapping("/cursos")
    public String listar(Model model) {
        model.addAttribute("cursos", cursoService.listar());
        return "cursos/list";
    }

    @GetMapping("/cursos/novo")
    public String novo(Model model) {
        model.addAttribute("curso", new Curso());
        model.addAttribute("titulo", "Novo curso");
        return "cursos/form";
    }

    @PostMapping("/cursos")
    public String criar(@Valid @ModelAttribute("curso") Curso curso, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("titulo", "Novo curso");
            return "cursos/form";
        }
        cursoService.salvar(curso);
        return "redirect:/cursos";
    }

    @GetMapping("/cursos/{id}")
    public String ver(@PathVariable Long id, Model model) {
        model.addAttribute("curso", cursoService.buscarPorId(id));
        return "cursos/view";
    }

    @GetMapping("/cursos/{id}/editar")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("curso", cursoService.buscarPorId(id));
        model.addAttribute("titulo", "Editar curso");
        return "cursos/form";
    }

    @PostMapping("/cursos/{id}")
    public String atualizar(@PathVariable Long id, @Valid @ModelAttribute("curso") Curso curso,
                            BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("titulo", "Editar curso");
            return "cursos/form";
        }
        curso.setId(id);
        cursoService.salvar(curso);
        return "redirect:/cursos";
    }

    @PostMapping("/cursos/{id}/remover")
    public String remover(@PathVariable Long id) {
        cursoService.remover(id);
        return "redirect:/cursos";
    }
}
