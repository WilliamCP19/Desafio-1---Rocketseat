package com.william.desafio1.dto;

import com.william.desafio1.entities.Curso;
import com.william.desafio1.entities.Status;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CursoDTO {
    private String nome;
    private String categoria;

    @Enumerated(EnumType.STRING)
    private Status status;
    private Long id;

    public CursoDTO (Curso curso) {
        this.nome = curso.getNome();
        this.categoria = curso.getCategoria();
        this.id = curso.getId();
        this.status = curso.getStatus() ? Status.ATIVO : Status.DESATIVADO;
    }
}
