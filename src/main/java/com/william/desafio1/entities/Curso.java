package com.william.desafio1.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Curso {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    //@NotBlank(message = "Deve-se inserir o nome!")
    private String nome;
    
    //@NotBlank(message = "A categoria é obrigatória")
    private String categoria;
    private Boolean status;

    @CreationTimestamp
    private LocalDateTime created_at;

    @UpdateTimestamp
    private LocalDateTime updated_at;
}
