package br.edu.ufersa.academicoExemploDidativo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import br.edu.ufersa.academicoExemploDidativo.model.Estudante;
import br.edu.ufersa.academicoExemploDidativo.repository.EstudanteRepository;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AcademicoExemploDidativoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AcademicoExemploDidativoApplication.class, args);
	}

	@Bean
    CommandLineRunner carregarDadosIniciais(EstudanteRepository repository) {
		return args -> {
			if (repository.count() == 0) {
				repository.saveAll(List.of(
						new Estudante("Dudu", "Programação Web"),
						new Estudante("Paty", "Análise de Algoritmos"),
						new Estudante("Clébio", "Programação Orientada a Objetos"),
						new Estudante("Ju", "Engenharia de Requisitos")
				));
			}
		};
	}
}

