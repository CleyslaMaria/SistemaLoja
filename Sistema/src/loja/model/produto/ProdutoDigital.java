package loja.model.produto;
import java.math.BigDecimal;

public class ProdutoDigital extends Produto { 
    private double tamanhoMB; 

    // Construtor
    public ProdutoDigital(String codigo, String nome, BigDecimal precoBase, double tamanhoMB) {
        super(codigo, nome, precoBase);
        this.tamanhoMB = tamanhoMB;
    }

    public double getTamanhoMB() {
        return tamanhoMB;
    }

    public void setTamanhoDownloadMB(double tamanhoMB) {
        this.tamanhoMB = tamanhoMB;
    }
}