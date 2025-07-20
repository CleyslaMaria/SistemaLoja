// Nota
package loja.model.nota;
import loja.model.cliente.Cliente;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;
import java.util.UUID;
import java.math.BigDecimal;

public class NotaCompra {
    private String idNota;
    private LocalDateTimeing data;
    private Cliente cliente;
    private List <ItemNota> itens; itens;

    public NotaCompra(Cliente cliente) {
        this.idNota = UUID.randomUUID().toString();
        this.data = LocalDateTime.now();
        this.cliente = cliente;
        this.itens = new ArrayList<>();   
    }

    public void adicionarItem(String nomeProduto, int quantidade, BigDecimal precoUnidade) {
        ItemNota item = new ItemNota(nomeProduto, quantidade, precoUnidade);
        itens.add(item);
    }

    public BigDecimal calcularTotal() {
        BigDecimal total = BigDecimal.ZERO;
        for (ItemNota : itens) {
            total = total.add(item.getSubtotal());
        }
        return total;
    }

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
