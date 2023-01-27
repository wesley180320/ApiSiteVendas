package com.estudos.sitevendas.DTO;

import com.estudos.sitevendas.model.Cidade;

import javax.persistence.Column;
import java.util.ArrayList;
import java.util.List;

public class EstadoDTO {

    @Column(nullable = false,unique = true,length = 70)
    private String nome;

    @Column(nullable = false,length = 70)
    private List<Cidade> cidades = new ArrayList<>();

    public EstadoDTO(String nome) {
        this.nome = nome;
    }

    public EstadoDTO() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Cidade> getCidades() {
        return cidades;
    }

    public void setCidades(List<Cidade> cidades) {
        this.cidades = cidades;
    }
}
