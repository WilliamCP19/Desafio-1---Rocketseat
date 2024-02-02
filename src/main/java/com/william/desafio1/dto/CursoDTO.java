package com.william.desafio1.dto;

import java.util.UUID;

import org.springframework.beans.BeanUtils;

import com.william.desafio1.entities.Curso;

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
    private String status;
    private UUID id;

    public CursoDTO (Curso curso) {
        BeanUtils.copyProperties(curso, this);
    }
}
