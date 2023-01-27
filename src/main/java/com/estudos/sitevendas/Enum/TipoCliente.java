package com.estudos.sitevendas.Enum;

public enum TipoCliente {

    PESSOAFISICA(1, "Pessoa Fisica"),
    PESSOAJURIDICA(2, "Pessoa Juridica");


    private int cod;
    private String descricao;

    TipoCliente(int cod, String descricao) {

        this.cod = cod;
        this.descricao = descricao;

    }

    public int getCod() {
        return cod;
    }

    public String getDescricao() {
        return descricao;
    }

    public static TipoCliente toEnum(Integer cod) {

        if (cod == null) {

            return null;
        }

        for (TipoCliente x : TipoCliente.values()) {

            if (cod.equals(x.getCod())) {

                return x;
            }

        }
        throw new IllegalArgumentException("Id inválido" + cod);
    }

}