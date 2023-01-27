package com.estudos.sitevendas.model;

import com.estudos.sitevendas.Enum.EstadoPagamento;

import javax.persistence.Entity;

@Entity
public class PagamentoComCartao extends Pagamento{

    private Integer numerodeparcelas;


    public PagamentoComCartao() {

    }

    public PagamentoComCartao(Integer id, EstadoPagamento estadoPagamento, Pedido pedido, Integer numerodeparcelas) {
        super(id, estadoPagamento, pedido);
        this.numerodeparcelas = numerodeparcelas;
    }

    public Integer getNumerodeparcelas() {
        return numerodeparcelas;
    }

    public void setNumerodeparcelas(Integer numerodeparcelas) {
        this.numerodeparcelas = numerodeparcelas;
    }
}
