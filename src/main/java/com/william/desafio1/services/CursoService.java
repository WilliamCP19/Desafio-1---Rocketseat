package com.william.desafio1.services;

import java.util.List;

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

        return new CursoDTO(curso);
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

        return new CursoDTO(aux);
    }

    public CursoDTO atulizarStatus (Long id) {
        var aux = cursoRepository.findById(id)
        .orElseThrow (() -> {
            throw new CursoFoundException();
        });
        aux.setStatus(!aux.getStatus());
        cursoRepository.save(aux);
        return new CursoDTO(aux);
    }

    public void deletarCurso (Long id) {
        var curso = cursoRepository.findById(id)
        .orElseThrow(() -> {
            throw new CursoNotFoundException();
        });
        cursoRepository.deleteById(id);
    }
}
