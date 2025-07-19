package loja.model.nota;
// Emissão de Nota de Compra
// Classe ItemNota (produto + quantidade)

public class ItemNota {
    private String nomeProduto;
    private int quantidade;
    private double precoUnidade;

    public ItemNota(String nomeProduto, int quantidade, double precoUnidade) {
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
    
    public double getPrecoUnidade() {
        return precoUnidade;
    }

    public double getSubtotal() {
        return quantidade * precoUnidade
    }

}
