// Nota
package loja.model.nota;
import loja.model.cliente.Cliente;
import java.time.LocalDateTime;
import java.util.ArrayList;  // Para armazenar os itens
import java.util.List; 
import java.util.UUID;      // Gera um ID único para a nota
import java.math.BigDecimal;

public class NotaCompra {
    private String idNota;
    private LocalDateTimeing data;
    private Cliente cliente;                
    private List <ItemNota> itens; itens;  // Lista de produtos comprados

    public NotaCompra(Cliente cliente) {
        this.idNota = UUID.randomUUID().toString();
        this.data = LocalDateTime.now();
        this.cliente = cliente;
        this.itens = new ArrayList<>();   
    }

       // Adiciona um item à nota
    public void adicionarItem(String nomeProduto, int quantidade, BigDecimal precoUnidade) {
        ItemNota item = new ItemNota(nomeProduto, quantidade, precoUnidade);
        itens.add(item);
    }

      // Soma os subtotais de todos os itens
    public BigDecimal calcularTotal() {
        BigDecimal total = BigDecimal.ZERO;
        for (ItemNota : itens) {
            total = total.add(item.getSubtotal());
        }
        return total;
    }

    // Exibe um resumo da nota
    public void resumoNota() (
        System.out.println("===== NOTA DE COMPRA =====");
        System.out.println("ID: " + idNota);
        System.out.println("Data: " + data);
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("Endereço: " + cliente.getEndereco());
        System.out.println("Telefone: " + cliente.getTelefone());
        System.out.println("===========================");
        for (ItemNota item : itens) {
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
