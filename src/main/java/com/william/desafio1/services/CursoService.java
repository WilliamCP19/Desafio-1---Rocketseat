package com.william.desafio1.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.william.desafio1.dto.CursoDTO;
import com.william.desafio1.entities.Curso;
import com.william.desafio1.exception.CursoFoundException;
import com.william.desafio1.exception.CursoNotFoundException;
import com.william.desafio1.repository.CursoRepository;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public CursoDTO adicionarCurso (Curso curso) {
        cursoRepository.findByNome(curso.getNome())
        .ifPresent((user) -> {
            throw new CursoFoundException();
        });
        cursoRepository.save(curso);

        var cursoDTO = CursoDTO.builder()
            .nome(curso.getNome())
            .categoria(curso.getCategoria())
            .status(curso.getStatus())
            .id(curso.getId())
            .build();
        return cursoDTO;
    }

    public List<CursoDTO> listarCursos () {
        var lista = cursoRepository.findAll();
        return lista.stream().map(x -> new CursoDTO(x)).toList();
    }

    public void deletarCurso (UUID id) {
        var curso = cursoRepository.findById(id)
        .orElseThrow(() -> {
            throw new CursoNotFoundException();
        });
        cursoRepository.deleteById(id);
    }
}
