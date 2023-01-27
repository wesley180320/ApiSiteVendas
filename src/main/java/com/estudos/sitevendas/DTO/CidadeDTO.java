package com.estudos.sitevendas.DTO;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

public class CidadeDTO {


    @Column(nullable = false,length = 70)
    private String nome;

    @Column(nullable = false,length = 70)
    private String estado;


    public CidadeDTO(String nome, String estado) {
        this.nome = nome;
        this.estado = estado;
    }

    public CidadeDTO() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
