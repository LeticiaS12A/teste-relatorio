package com.relatorio.relatorio.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Report {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 
// Identificador único do relatório, gerado automaticamente.
    private String title; 
// Título do relatório.
    private String content; 
// Conteúdo do relatório.

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
}
