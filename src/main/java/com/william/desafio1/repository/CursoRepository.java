package com.william.desafio1.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.william.desafio1.entities.Curso;


@Repository
public interface CursoRepository extends JpaRepository<Curso, UUID> {
    Optional<Curso> findByNome (String nome);
}
