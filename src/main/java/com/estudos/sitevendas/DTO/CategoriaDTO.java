package com.estudos.sitevendas.DTO;

import com.estudos.sitevendas.model.Categoria;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;

public class CategoriaDTO {

    private Integer id;

    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(min = 5, max = 80, message = "O tamanho deve ser entre 5 e 80 caracteres")
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
