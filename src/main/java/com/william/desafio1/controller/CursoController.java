package com.william.desafio1.controller;

import org.springframework.web.bind.annotation.RestController;

import com.william.desafio1.entities.Curso;
import com.william.desafio1.services.CursoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
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
}
