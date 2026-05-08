package br.com.musica.web.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "cursos")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome e obrigatorio")
    @Column(nullable = false)
    private String nome;

    @Min(value = 1, message = "Duracao em meses deve ser >= 1")
    @Column(name = "duracao_meses", nullable = false)
    private Integer duracaoMeses;

    @Min(value = 1, message = "Numero de alunos deve ser >= 1")
    @Column(name = "numero_alunos", nullable = false)
    private Integer numeroAlunos;

    @NotBlank(message = "Professor e obrigatorio")
    @Column(nullable = false)
    private String professor;

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

    public Integer getDuracaoMeses() {
        return duracaoMeses;
    }

    public void setDuracaoMeses(Integer duracaoMeses) {
        this.duracaoMeses = duracaoMeses;
    }

    public Integer getNumeroAlunos() {
        return numeroAlunos;
    }

    public void setNumeroAlunos(Integer numeroAlunos) {
        this.numeroAlunos = numeroAlunos;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }
}
