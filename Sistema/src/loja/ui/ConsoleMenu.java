package loja.ui;

import java.math.BigDecimal;
import java.time.LocalDate;

import loja.model.cliente.PessoaFisica;
import loja.model.cliente.PessoaJuridica;
import loja.model.produto.Produto;
import loja.model.produto.ProdutoDigital;
import loja.model.produto.ProdutoFisico;
import loja.model.produto.ProdutoPerecivel;


public class ConsoleMenu {
    private static Produto[] produtos = new Produto[100]; // Array para armazenar os produtos
    private static int quantidadeProdutos = 0; // Contador de produtos cadastrados


    public static void exibirMenu() {
        
        int opcao;

        do {
            System.out.println("\n===== Menu Principal =====");
            System.out.println("1. Cadastrar Produto");
            System.out.println("2. Alterar Produto");
            System.out.println("3. Cadastrar Cliente");
            System.out.println("4. Alterar Cliente");
            System.out.println("5. Criar Nota de Compra");
            System.out.println("6. Listar Notas Emitidas");
            System.out.println("7. Listar Produtos");
            System.out.println("8. Listar Clientes");
            System.out.println("0. Sair");

            opcao = InputUtils.lerInt("Escolha uma opção");

            if (opcao == 1) {
                cadastrarProduto();
            } else if (opcao == 2) {
                alterarProduto();
            } else if (opcao == 3) {
                cadastrarCliente();
            } else if (opcao == 4) {
                alterarCliente();
            } else if (opcao == 5) {
                criarNotaDeCompra();
            } else if (opcao == 6) {
                listarNotasEmitidas();
            } else if (opcao == 7) {
                 listarProdutos();
            } else if (opcao == 8) {
                listarClientes();
            } else if (opcao == 0) {
                System.out.println("Saindo do sistema.");
            } else {
                System.out.println("Opcao invalida. Tente novamente.");
            }

        } while (opcao != 0);

    }

    // FUNCIONALIDADES DO SISTEMA

    private static void cadastrarProduto(){
        System.out.println("\n=== Cadastro de Produto ===");
        String codigo = InputUtils.lerString("Digite o código único do produto");
        String nome = InputUtils.lerString("Digite o nome do produto");
        BigDecimal precoBase = InputUtils.lerBigDecimal("Digite o preço base do produto");
        System.out.println("Qual o tipo de produto?");
        System.out.println("1. Produto Físico");
        System.out.println("2. Produto Digital");
        System.out.println("3. Produto Perecivel");
        int tipo = InputUtils.lerInt("Escolha o tipo");

        Produto novoProduto = null;

        if(tipo == 1){
            int estoque = InputUtils.lerInt("Digite a quantidade em estoque deste produto");
            novoProduto = new ProdutoFisico(codigo, nome, precoBase, estoque);        
        } else if (tipo == 2){
            double tamanhoDownload = InputUtils.lerBigDecimal("Digite o tamanho do download em MB").doubleValue();
            novoProduto = new ProdutoDigital(codigo, nome, precoBase, tamanhoDownload);
        } else if (tipo == 3){
            LocalDate dataValidade = InputUtils.lerLocalDate("Digite a data de validade");
            novoProduto = new ProdutoPerecivel(codigo, nome, precoBase, dataValidade);
        } else {
            System.out.println("Tipo de produto inválido");
            return;

        }
        // Armazena no array, se ainda houver espaço
        if (quantidadeProdutos < produtos.length) {
            produtos[quantidadeProdutos] = novoProduto;
            quantidadeProdutos++;
            System.out.println("Produto cadastrado com sucesso.");
        } else {
            System.out.println("Erro: limite de produtos atingido.");
        }
        
    }

    
    private static void alterarProduto(){
        System.out.println("/n=== Alterar Produto ===");
        String codigo = InputUtils.lerString("Digite o código do produto a ser alterado");

        Produto produtoEncontrado = null;
        for(int i = 0; i < quantidadeProdutos; i++){
            if(produtos[i] != null && produtos[i].getCodigo().equals(codigo)){
                produtoEncontrado = produtos[i];
                break;
            }
        }
        if(produtoEncontrado ==  null){
            System.out.println("Produto não encontrado!");
            return;
        }

        System.out.println("produto encontrado.");
        System.out.println("O que deseja alterar?");
        System.out.println("1.Nome");
        System.out.println("2.Preço");
        if(produtoEncontrado instanceof ProdutoFisico){
            System.out.println("3. Estoque");
        if(produtoEncontrado instanceof ProdutoDigital){
            System.out.println"3. tamanho do download em MB");
        if(produtoEncontrado instanceof ProdutoPerecivel){
            System.out.println("3. Data de validade");
        }

        int opcaoAlteracao = InputUtils.lerInt("Escolha a opção");

        if(opcaoAlteracao == 1){
            String novoNome = InputUtils.lerString("Novo nome: ");
            produtoEncontrado.setNome(novoNome);
            System.out.println("Nome alterado com sucesso!");
        }else if(opcaoAlteracao == 2){
            BigDecimal novoPreco = InputUtils.lerBigDecimal("Digite o novo preço");
            produtoEncontrado.setPrecoBase(novoPreco);
            System.out.println("Preço alterado com sucesso!");
        }else if(opcaoAlteracao == 3 && produtoEncontrado instanceof ProdutoFisico){
            int novoEstoque = InputUtils.lerInt("Novo estoque: ");
            produtoEncontrado.setEstoque(novoEstoque);
            System.out.println("Estoque alterado com sucesso!");
        }else if(opcaoAlteracao == 3 && produtoEncontrado instanceof ProdutoDigital){
            Double novoDownload = InputUtils.lerDouble("Novo tamanho de download em MB: ");
            produtoEncontrado.setTamanhoMB(novoDownload);
            System.out.println("Tamanho de download alterado com sucesso!");
        }else if(opcaoAlteracao == 3 && produtoEncontrado instanceof ProdutoPerecivel){
            LocalDate novoValidade = InputUtils.lerLocalDate("Nova validade: ");
            produtoEncontrado.setValidade(novoValidade);
            System.out.println("Validade alterada com sucesso!");
        }else{
            System.out.println("Opção inválida.");
        }
    }
    

    private static void listarProdutos(){
        System.out.println("\n=== Lista de produtos ===");

        if(quantidadeProdutos == 0){
            System.out.println("Nenhum produto cadastrado.");
            return;
        }

        for(int i = 0; i < quantidadeProdutos; i++){
            Produto k = produtos[i];

            if(k != null){
                System.out.println("Id: " + k.getCodigo());
                System.out.println("Nome: " + k.getNome());
                System.out.println("Preço base: " + k.getPrecoBase());

                if (k instanceof ProdutoFisico){
                    ProdutoFisico kf = (ProdutoFisico) k;
                    System.out.println("Estoque: " + kf.getEstoque());
                } else if (k instanceof ProdutoDigital){
                    ProdutoFisico kd = (ProdutoFisico) k;
                    System.out.println("Tamanho de download: " + kd.getTamanhoMB());
                } else if (k instanceof ProdutoPerecivel){
                    ProdutoFisico kp = (ProdutoFisico) k;
                    System.out.println("Validade " + kp.getValidade());
                }
            }
        }
    }

}
