package loja.ui;

import java.math.BigDecimal;
import java.time.LocalDate;

import loja.model.cliente.Cliente;
import loja.model.cliente.PessoaFisica;
import loja.model.cliente.PessoaJuridica;
import loja.model.produto.Produto;
import loja.model.produto.ProdutoDigital;
import loja.model.produto.ProdutoFisico;
import loja.model.produto.ProdutoPerecivel;
import loja.ui.InputUtils;


public class ConsoleMenu {
    private static Produto[] produtos = new Produto[100]; // Array para armazenar os produtos
    private static int quantidadeProdutos = 0; // Contador de produtos cadastrados
    private static Cliente[] clientes = new Cliente[100]; // Array para armazenar os clientes
    private static int quantidadeClientes = 0; // Contador de clientes cadastrados


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

    private static void cadastrarProduto() {
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

    
    private static void alterarProduto() {
        System.out.println("\n=== Alterar Produto ===");
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

        System.out.println("Produto encontrado.");
        System.out.println("O que deseja alterar?");
        System.out.println("1.Nome");
        System.out.println("2.Preço");
        if(produtoEncontrado instanceof ProdutoFisico){
            System.out.println("3. Estoque");
        } else if(produtoEncontrado instanceof ProdutoDigital){
            System.out.println("3. tamanho do download em MB");
        } else if(produtoEncontrado instanceof ProdutoPerecivel){
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
            ((ProdutoFisico)produtoEncontrado).setEstoque(novoEstoque);
            System.out.println("Estoque alterado com sucesso!");
        }else if(opcaoAlteracao == 3 && produtoEncontrado instanceof ProdutoDigital){
            double novoDownload = InputUtils.lerDouble("Novo tamanho de download em MB: ");
            ((ProdutoDigital)produtoEncontrado).setTamanhoMB(novoDownload);
            System.out.println("Tamanho de download alterado com sucesso!");
        }else if(opcaoAlteracao == 3 && produtoEncontrado instanceof ProdutoPerecivel){
            LocalDate novoValidade = InputUtils.lerLocalDate("Nova validade: ");
            ((ProdutoPerecivel)produtoEncontrado).setValidade(novoValidade);
            System.out.println("Validade alterada com sucesso!");
        }else{
            System.out.println("Opção inválida.");
        }
    }
    

    private static void listarProdutos(){
        System.out.println("\n=== Lista de Produtos ===");

        if(quantidadeProdutos == 0){
            System.out.println("Nenhum produto cadastrado.");
            return;
        }

        for(int i = 0; i < quantidadeProdutos; i++){
            Produto k = produtos[i];

            if(k != null){
                System.out.println("Código: " + k.getCodigo());
                System.out.println("Nome: " + k.getNome());
                System.out.println("Preço base: " + k.getPrecoBase());

                if (k instanceof ProdutoFisico){
                    ProdutoFisico kf = (ProdutoFisico) k;
                    System.out.println("Estoque: " + kf.getEstoque());
                } else if (k instanceof ProdutoDigital){
                    ProdutoDigital kd = (ProdutoDigital) k;
                    System.out.println("Tamanho de download: " + kd.getTamanhoMB());
                } else if (k instanceof ProdutoPerecivel){
                    ProdutoPerecivel kp = (ProdutoPerecivel) k;
                    System.out.println("Validade " + kp.getValidade());
                }
            }
        }
    }


    private static void cadastrarCliente(){
        System.out.println("\n=== Cadastro de Cliente ===");
        String id = InputUtils.lerString("Digite o ID do cliente");
        String nomeCliente = InputUtils.lerString("Digite o nome do cliente");
        String endereco = InputUtils.lerString("Digite o endereço do cliente");
        String telefone = InputUtils.lerString("Digite o telefone do cliente");


        System.out.println("Qual o tipo de cliente?");
        System.out.println("1. Pessoa Física");
        System.out.println("2. Pessoa Jurídica");
        int tipoCliente = InputUtils.lerInt("Escolha o tipo");

        Cliente novoCliente = null;

        if(tipoCliente == 1){
            String fisica = InputUtils.lerString("Digite o CPF do cliente");
            novoCliente = new PessoaFisica(id, nomeCliente, endereco, telefone, fisica);        
        } else if (tipoCliente == 2){
            String juridica = InputUtils.lerString("Digite o CNPJ do cliente");
            novoCliente = new PessoaJuridica(id, nomeCliente, telefone, endereco, juridica);
        } else {
            System.out.println("Tipo de cliente inválido");
            return;
        }

        // Armazena no array, se ainda houver espaço
        if (quantidadeClientes < clientes.length) {
            clientes[quantidadeClientes] = novoCliente;
            quantidadeClientes++;
            System.out.println("Cliente cadastrado com sucesso.");
        } else {
            System.out.println("Erro: limite de clientes atingido.");
        }
        
    }


    private static void alterarCliente() {
        System.out.println("\n=== Alterar Cliente ===");
        String id = InputUtils.lerString("Digite o ID od cliente a ser alterado");

        Cliente clienteEncontrado = null;
                        
        for(int i = 0; i < quantidadeClientes; i++){
            if(clientes[i] != null && clientes[i].getId().equals(id)){
                clienteEncontrado = clientes[i];
                break;
            }
        }

        if(clienteEncontrado ==  null){
            System.out.println("Cliente não encontrado!");
            return;
        }

        System.out.println("Cliente encontrado.");
        System.out.println("O que deseja alterar?");
        System.out.println("1.ID");
        System.out.println("2.Nome");
        System.out.println("3.Endereço");
        System.out.println("4.Telefone");
        if(clienteEncontrado instanceof PessoaFisica){
            System.out.println("5. CPF");
        } else if(clienteEncontrado instanceof PessoaJuridica){
            System.out.println("5. CNPJ");
        }

        int alteracao = InputUtils.lerInt("Escolha a opção");

        if(alteracao == 1){
            String novoId = InputUtils.lerString("Novo ID: ");
            clienteEncontrado.setId(novoId);
            System.out.println("ID alterado com sucesso!");
        }else if(alteracao == 2){
            String novoNome = InputUtils.lerString("Digite o novo nome");
            clienteEncontrado.setNome(novoNome);
            System.out.println("Nome alterado com sucesso!");
        }else if(alteracao == 3){
            String novoEndereco = InputUtils.lerString("Digite o novo endereço");
            clienteEncontrado.setEndereco(novoEndereco);
            System.out.println("Endereço alterado com sucesso!");
        }else if(alteracao == 4){
            String novoTelefone = InputUtils.lerString("Digite o novo telefone");
            clienteEncontrado.setTelefone(novoTelefone);
            System.out.println("Telefone alterado com sucesso!");
        }else if(alteracao == 5 && clienteEncontrado instanceof PessoaFisica){
            String novoCpf = InputUtils.lerString("Novo CPF: ");
            ((PessoaFisica)clienteEncontrado).setCpf(novoCpf);
            System.out.println("CPF alterado com sucesso!");
        }else if(alteracao == 5 && clienteEncontrado instanceof PessoaJuridica){
            String novoCnpj = InputUtils.lerString("Novo CNPJ: ");
            ((PessoaJuridica)clienteEncontrado).setCnpj(novoCnpj);
            System.out.println("CNPJ alterado com sucesso!");
        }else{
            System.out.println("Opção inválida.");
        }
    }
    

    private static void listarClientes(){
        System.out.println("\n=== Lista de Clientes ===");

        if(quantidadeClientes == 0){
            System.out.println("Nenhum cliente cadastrado.");
            return;
        }

        for(int i = 0; i < quantidadeClientes; i++){
            Cliente p = clientes[i];

            if(p != null){
                System.out.println("ID: " + p.getId());
                System.out.println("Nome: " + p.getNome());
                System.out.println("Endereço: " + p.getEndereco());
                System.out.println("Telefone: " + p.getTelefone());

                if (p instanceof PessoaFisica){
                    PessoaFisica pf = (PessoaFisica) p;
                    System.out.println("CPF: " + pf.getCpf());
                } else if (p instanceof PessoaJuridica){
                    PessoaJuridica pj = (PessoaJuridica) p;
                    System.out.println("CNPJ: " + pj.getCnpj());
                }

            }
        }
    }
}
