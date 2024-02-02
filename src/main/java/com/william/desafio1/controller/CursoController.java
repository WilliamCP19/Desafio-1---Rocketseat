package com.william.desafio1.controller;

import java.util.UUID;

import org.springframework.web.bind.annotation.RestController;

import com.william.desafio1.entities.Curso;
import com.william.desafio1.exception.CursoNotFoundException;
import com.william.desafio1.services.CursoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/")
public class CursoController {
    
    @Autowired CursoService cursoService;

    @PostMapping("cursos")
    public ResponseEntity<Object> criar (@RequestBody Curso curso) {
        try {
            var result = cursoService.adicionarCurso(curso);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("cursos")
    public ResponseEntity<Object> listar () {
        try {
            var result = cursoService.listarCursos();
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("cursos/{id}")
    public ResponseEntity<Object> deletar (@PathVariable UUID id) {
        try {
            cursoService.deletarCurso(id);
            return ResponseEntity.ok().body("Curso excluído com sucesso");
        } catch (CursoNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
