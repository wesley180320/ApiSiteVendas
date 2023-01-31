package com.estudos.sitevendas.DTO;

import com.estudos.sitevendas.model.Categoria;

import javax.persistence.Column;

public class CategoriaDTO {

    private Integer id;

    @Column(nullable = false, length = 70)
    private String nome;

    public CategoriaDTO(String nome, Integer id) {
        this.nome = nome;
        this.id = id;
    }

    public CategoriaDTO(Categoria obj){

        id = obj.getId();
        nome = obj.getNome();

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
