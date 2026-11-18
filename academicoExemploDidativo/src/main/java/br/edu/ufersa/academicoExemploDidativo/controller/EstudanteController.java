package br.edu.ufersa.academicoExemploDidativo.controller;

import br.edu.ufersa.academicoExemploDidativo.model.Estudante;
import br.edu.ufersa.academicoExemploDidativo.repository.EstudanteRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estudantes")
public class EstudanteController {

    private final EstudanteRepository repository;

    public EstudanteController(EstudanteRepository repository) {
        this.repository = repository;
    }

    // GET /api/estudantes -> Lista todos os estudantes
    @GetMapping
    public ResponseEntity<List<Estudante>> listarTodos() {
        return ResponseEntity.ok(repository.findAll());
    }

    // POST /api/estudantes -> Cadastra um novo estudante e retorna 201 Created
    @PostMapping
    public ResponseEntity<Estudante> cadastrar(@Valid @RequestBody Estudante novoEstudante) {
        Estudante salvo = repository.save(novoEstudante);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    // DELETE /api/estudantes/{id} -> Remove um estudante pelo ID e retorna 204 No Content
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}