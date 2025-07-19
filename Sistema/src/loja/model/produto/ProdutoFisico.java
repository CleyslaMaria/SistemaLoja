package loja.model.produto;

import java.math.BigDecimal;

public class ProdutoFisico extends Produto { 
    private int estoque; 

    
    public ProdutoFisico(String codigo, String nome, BigDecimal precoBase, int estoque) {
        super(codigo, nome, precoBase);
        this.estoque = estoque;
    }

    // Getter e Setter para 'estoque'
    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

}