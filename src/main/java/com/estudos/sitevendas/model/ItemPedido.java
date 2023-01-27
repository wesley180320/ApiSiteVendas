package com.estudos.sitevendas.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.util.Date;

@Entity
public class ItemPedido {


    @EmbeddedId
    private ItemPedidoPk itemPedidoPk = new ItemPedidoPk();

    private Double desconto;
    private Integer quantidade;
    private Double preco;


    public ItemPedido() {
    }

    public ItemPedido(Pedido pedido, Produto produto, Double desconto, Integer quantidade, Double preco) {
        itemPedidoPk.setProduto(produto);
        itemPedidoPk.setPedido(pedido);
        this.desconto = desconto;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    @JsonIgnore
    public Pedido getPedido(){

        return itemPedidoPk.getPedido();
    }


    public Produto getProduto(){

        return itemPedidoPk.getProduto();
    }

    public ItemPedidoPk getItemPedidoPk() {
        return itemPedidoPk;
    }

    public void setItemPedidoPk(ItemPedidoPk itemPedidoPk) {
        this.itemPedidoPk = itemPedidoPk;
    }

    public Double getDesconto() {
        return desconto;
    }

    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}
