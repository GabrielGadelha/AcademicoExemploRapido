package br.edu.ufersa.academicoExemploDidativo.repository;

import br.edu.ufersa.academicoExemploDidativo.model.Estudante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudanteRepository extends JpaRepository<Estudante, Long> {
}