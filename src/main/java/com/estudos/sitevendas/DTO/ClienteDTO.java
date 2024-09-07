package com.estudos.sitevendas.DTO;


import com.estudos.sitevendas.Enum.TipoCliente;
import com.estudos.sitevendas.model.Cliente;

public class ClienteDTO {


    private Integer id;
    private String nome;
    private String email;
    private Integer idCidade;
    private TipoCliente tipoCliente;
    private String cpfOuCnpj;

    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cep;

    public ClienteDTO(Integer id, String nome, String email, Integer idCidade, TipoCliente tipoCliente, String cpfOuCnpj, String logradouro, String numero, String complemento, String bairro, String cep) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.idCidade = idCidade;
        this.tipoCliente = tipoCliente;
        this.cpfOuCnpj = cpfOuCnpj;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cep = cep;
    }

    public ClienteDTO(Cliente cliente){

        this.id = cliente.getId();
        this.email = cliente.getEmail();
        this.nome = cliente.getNome();

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(TipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public Integer getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(Integer idCidade) {
        this.idCidade = idCidade;
    }

    public String getCpfOuCnpj() {
        return cpfOuCnpj;
    }

    public void setCpfOuCnpj(String cpfOuCnpj) {
        this.cpfOuCnpj = cpfOuCnpj;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}
