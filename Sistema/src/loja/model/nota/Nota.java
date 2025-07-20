// Nota
package loja.model.nota;
import loja.model.cliente.Cliente;
import java.time.LocalDateTime;
import java.math.BigDecimal;

public class NotaCompra {
    private static int gerarId = 1;
    private String idNota;
    private LocalDateTimeing data;
    private Cliente cliente;                
    private ItemNota[] itens;  
    private int quantidadeItens;

    public NotaCompra(Cliente cliente) {
        this.idNota = "x" + gerarId++;
        this.data = LocalDateTime.now();
        this.cliente = cliente;
        this.itens = new ItemNota[100];
        this.quantidadeItens = 0;
    }

       // Adiciona um item
    public void adicionarItem(String nomeProduto, int quantidade, BigDecimal precoUnidade) {
        if (quantidadeItens < itens.length) {
            itens[quantidadeItens] = new ItemNota(nomeProduto, quantidade, precoUnidade);
            quantidadeItens++;
        } 

    }

      // Soma os subtotais de todos os itens
    public BigDecimal calcularTotal() {
        BigDecimal total = BigDecimal.ZERO;
        for (int i = 0; i < quantidadeItens; i++) {
            total = total.add(itens[1].getSubtotal());
        }
        return total;
    }

    // Mostra o resumo da nota
    public void resumoNota() (
        System.out.println("===== NOTA DE COMPRA =====");
        System.out.println("ID: " + idNota);
        System.out.println("Data: " + data);
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("Endereço: " + cliente.getEndereco());
        System.out.println("Telefone: " + cliente.getTelefone());
        System.out.println("===========================");
        for (int i = 0; i < quantidadeItens; i++) {
            System.out.printf("Produto: %-15s Qtd: %d | Unit: R$ %.2f | Subtotal: R$ %.2f%n",
                item.getNomeProduto(),
                item.getQuantidade(),
                item.getPrecoUnidade(),
                item.getSubtotal());

        }

        System.out.println("=========================");
        System.out.printf("TOTAL: R$ %.2f%n", calcularTotal());
        System.out.println("==========================");
    )
}
