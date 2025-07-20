package loja.model.produto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ProdutoPerecivel extends Produto { 
    private LocalDate validade; 

    
    public ProdutoPerecivel(String codigo, String nome, BigDecimal precoBase, LocalDate validade) {
        super(codigo, nome, precoBase);
        this.validade = validade;
    }

    public LocalDate getValidade() {
        return validade;
    }

    public void setValidade(LocalDate validade) {
        this.validade = validade;
    }

}
