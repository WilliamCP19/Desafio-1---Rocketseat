package com.william.desafio1.exception;

public class CursoNotFoundException extends RuntimeException {
    public CursoNotFoundException() {
        super("Curso não existe!");
    }
    
}
