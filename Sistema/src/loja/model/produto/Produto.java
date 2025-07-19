package loja.model.produto;

import java.math.BigDecimal;

public abstract class Produto{
    private String codigo;
    private String nome;
    private BigDecimal precoBase;

    public Produto(String codigo, String nome, BigDecimal precoBase) {
        this.codigo = codigo;
        this.nome = nome;
        //rever
        this.precoBase = (precoBase != null && precoBase.compareTo(BigDecimal.ZERO) >= 0) ? precoBase : BigDecimal.ZERO;
    }


    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getPrecoBase() { 
        return precoBase;
    }

    

    public void setCodigo(String codigo) { 
        this.codigo = codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPrecoBase(BigDecimal precoBase) {
        //rever
        this.precoBase = (precoBase != null && precoBase.compareTo(BigDecimal.ZERO) >= 0) ? precoBase : BigDecimal.ZERO;
    }
}

