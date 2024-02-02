package com.william.desafio1.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
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

        return buildarDTO(curso);
    }

    public List<CursoDTO> listarCursos () {
        var lista = cursoRepository.findAll();
        return lista.stream().map(x -> new CursoDTO(x)).toList();
    }

    public CursoDTO atualizarCurso (Long id, Curso curso) {
        var aux = cursoRepository.findById(id)
        .orElseThrow(() -> {
            throw new CursoNotFoundException();
        });
        aux.setNome(curso.getNome());
        aux.setCategoria(curso.getCategoria());
        aux.setStatus(curso.getStatus());
        cursoRepository.save(aux);

        return buildarDTO(aux);
    }

    public void deletarCurso (Long id) {
        var curso = cursoRepository.findById(id)
        .orElseThrow(() -> {
            throw new CursoNotFoundException();
        });
        cursoRepository.deleteById(id);
    }

    public CursoDTO buildarDTO (Curso aux) {
        return CursoDTO.builder()
            .nome(aux.getNome())
            .categoria(aux.getCategoria())
            .status(aux.getStatus())
            .id(aux.getId())
            .build();
    }
}
