package org.com.programming.application.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_livros")
public class LivrosEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String name;

    public LivrosEntity(){}

    public LivrosEntity(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public LivrosEntity(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
