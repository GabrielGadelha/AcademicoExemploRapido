package br.edu.ufersa.academicoExemploDidativo.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "estudantes")
public class Estudante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome do estudante é obrigatório")
    private String nome;

    @NotBlank(message = "A turma/disciplina é obrigatória")
    private String turma;

    public Estudante() {
    }

    public Estudante(String nome, String turma) {
        this.nome = nome;
        this.turma = turma;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }
}