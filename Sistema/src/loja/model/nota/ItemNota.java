package loja.model.nota;
import java.math.BigDecimal;
// Emissão de Nota de Compra
// Classe ItemNota (produto + quantidade)

public class ItemNota {
    private String nomeProduto;
    private int quantidade;
    private BigDecimal precoUnidade;

    public ItemNota(String nomeProduto, int quantidade, BigDecimal precoUnidade) {
        this.nomeProduto = nomeProduto;
        this.quantidade = quantidade;
        this.precoUnidade = precoUnidade;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public int getQuantidade() {
        return quantidade;
    }
    
    public BigDecimal getPrecoUnidade() {
        return precoUnidade;
    }

    public BigDecimal getSubtotal() {
        return precoUnidade.multiply(BigDecimal.valueOf(quantidade));
    }

}
