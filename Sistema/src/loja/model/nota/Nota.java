package loja.model.nota;

import loja.model.cliente.Cliente;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.math.BigDecimal;

public class Nota {
    private static int gerarId = 1;
    private String idNota;
    private LocalDateTime data;
    private Cliente cliente;                
    private ItemNota[] itens;  
    private int quantidadeItens;

    public Nota(Cliente cliente) {
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
            total = total.add(itens[i].getSubtotal());
        }
        return total;
    }

    // Resumo da nota
    public void resumoNota() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        System.out.println("===== NOTA DE COMPRA =====");
        System.out.println("ID: " + idNota);
        System.out.println("Data: " + data.format(formatter));
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("Endereço: " + cliente.getEndereco());
        System.out.println("Telefone: " + cliente.getTelefone());
        System.out.println("===========================");

        for (int i = 0; i < quantidadeItens; i++) {
            ItemNota item = itens[i];
            System.out.println(item.getNomeProduto() +
                               " | Qtd: " + item.getQuantidade() +
                               " | Unidade: R$ " + String.format("%.2f", item.getPrecoUnidade()) +
                               " | Subtotal: R$ " + String.format("%.2f", item.getSubtotal()));
        }

        System.out.println("========================");
        System.out.println("TOTAL: R$ " + String.format("%.2f", calcularTotal()));
        System.out.println("==========================");
    }
}
