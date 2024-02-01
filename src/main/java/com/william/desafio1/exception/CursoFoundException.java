package com.william.desafio1.exception;

public class CursoFoundException extends RuntimeException {
    public CursoFoundException () {
        super("Curso já existe");
    }
}
