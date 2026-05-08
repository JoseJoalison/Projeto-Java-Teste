package br.com.musica.web.service;

import br.com.musica.web.model.Curso;
import br.com.musica.web.repository.CursoRepository;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class CursoService {

    private final CursoRepository cursoRepository;

    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    public List<Curso> listar() {
        return cursoRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    public Curso buscarPorId(Long id) {
        return cursoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Curso nao encontrado: " + id));
    }

    public Curso salvar(Curso curso) {
        return cursoRepository.save(curso);
    }

    public void remover(Long id) {
        cursoRepository.deleteById(id);
    }
}
