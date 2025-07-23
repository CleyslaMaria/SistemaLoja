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
import loja.model.nota.Nota;
import loja.model.nota.ItemNota;
import loja.ui.InputUtils;

public class ConsoleMenu {
    private static Produto[] produtos = new Produto[100]; 
    private static int quantidadeProdutos = 0; 
    private static Cliente[] clientes = new Cliente[100]; 
    private static int quantidadeClientes = 0; 
    private static Nota[] notas = new Nota[100]; 
    private static int quantidadeNotas = 0; 


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

            opcao = InputUtils.lerInt("Escolha uma opção: ");

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

    // OPÇÃO 1 - CADASTRAR PRODUTO
    private static void cadastrarProduto() {
        System.out.println("\n=== Cadastro de Produto ===");
        System.out.println("=== Produtos Físicos ===");
        System.out.println("1 - Batom Líquido Matte");
        System.out.println("2 - Kit de Pincéis de Maquiagem");
        System.out.println("3 - Chapinha Elétrica");
        System.out.println("4 - Escova de Cabelo Profissional");

        System.out.println("=== Produtos Perecíveis ===");
        System.out.println("5 - Creme Hidratante");
        System.out.println("6 - Tônico Facial Natural");
        System.out.println("7 - Shampoo Anticaspa");
        System.out.println("8 - Máscara de Argila");

        System.out.println("=== Produtos Digitais ===");
        System.out.println("9 - Voucher de Spa Facial");
        System.out.println("10 - Curso de Automaquiagem Online");
        System.out.println("11 - Ebook de Cuidados com a Pele");
        System.out.println("12 - Assinatura de App de Beleza");

        int opcaoProduto = InputUtils.lerInt("Escolha o produto: ");

        Produto novoProduto = null;

        if (opcaoProduto == 1){
            novoProduto = new ProdutoFisico("LY01", "Batom Líquido Matte"
            ,new BigDecimal("29.99"), 80);
        }else if (opcaoProduto == 2){
            novoProduto = new ProdutoFisico("LY02", "Kit de Pincéis de Maquiagem", new BigDecimal("200.00"), 30);
        }else if (opcaoProduto == 3){
            novoProduto = new ProdutoFisico("LY03", "Chapinha Elétrica", new BigDecimal("159.90"), 20);
        }else if (opcaoProduto == 4){
            novoProduto = new ProdutoFisico("LY04", "Escova de Cabelo Profissional", new BigDecimal("79.90"), 50);
        
        }else if (opcaoProduto == 5){
            novoProduto = new ProdutoPerecivel("NV01", "Creme Hidratante", new BigDecimal("39.90"), LocalDate.of(2026,12,31) );
        }else if (opcaoProduto == 6){
            novoProduto = new ProdutoPerecivel("NV02", "Tônico Facial Natural", new BigDecimal("50.00"), LocalDate.of(2026,11,27));
        }else if (opcaoProduto == 7){
            novoProduto = new ProdutoPerecivel("NV03", "Shampoo Anticaspa", new BigDecimal("24.90"), LocalDate.of(2026,10,15));
        }else if (opcaoProduto == 8){
            novoProduto = new ProdutoPerecivel("NV04", "Máscara de Argila", new BigDecimal("34.90"), LocalDate.of(2026,9,21));

        }else if (opcaoProduto == 9){
            novoProduto = new ProdutoDigital("PO01", "Voucher de Spa Facial", new BigDecimal("100.00"), 50.0);
        }else if (opcaoProduto == 10){
            novoProduto = new ProdutoDigital("PO02", "Curso de Automaquiagem Online", new BigDecimal("45.00"), 750.0);
        }else if (opcaoProduto == 11){
            novoProduto = new ProdutoDigital("PO03", "Ebook de Cuidados com a Pele", new BigDecimal("14.90"), 120.0);
        }else if (opcaoProduto == 12){
            novoProduto = new ProdutoDigital("PO04", "Assinatura de App de Beleza", new BigDecimal("16.90"), 5.0);
        }else{
            System.out.println("Opção inválida.");
        }

        if (novoProduto != null) {
            if (quantidadeProdutos < produtos.length) {
                produtos[quantidadeProdutos] = novoProduto;
                quantidadeProdutos++;
                System.out.println("\nProduto cadastrado com sucesso: " + novoProduto.getNome());
            } else {
                System.out.println("Não é possível cadastrar mais produtos. Limite atingido.");
            }
        }

    }

    // OPÇÃO 2 - ALTERAR PRODUTO
    private static void alterarProduto() {
        if (quantidadeProdutos == 0) {
            System.out.println("Nenhum produto cadastrado.");
            return;
        }
        System.out.println("=== Produtos Físicos ===");
        boolean temFisico = false;
        for (int i = 0; i < quantidadeProdutos; i++) {
            if (produtos[i] instanceof ProdutoFisico) {
                System.out.println(produtos[i].getCodigo() + " - " + produtos[i].getNome());
            temFisico = true;
            }
        }
        if(!temFisico){
            System.out.println("Nenhum produto cadastrado.");
        }
        
        System.out.println("\n=== Produtos Perecíveis ===");
        boolean temPerecivel = false;
        for (int i = 0; i < quantidadeProdutos; i++) {
            if (produtos[i] instanceof ProdutoPerecivel) {
                System.out.println(produtos[i].getCodigo() + " - " + produtos[i].getNome());
            temPerecivel = true;
            }
        }
        if(!temPerecivel){
            System.out.println("Nenhum produto cadastrado.");
        }

        System.out.println("\n=== Produtos Digitais ===");
        boolean temDigital = false;
        for (int i = 0; i < quantidadeProdutos; i++) {
            if (produtos[i] instanceof ProdutoDigital) {
                System.out.println(produtos[i].getCodigo() + " - " + produtos[i].getNome());
            }
        }
        if(!temDigital){
            System.out.println("Nenhum produto encontrado.");
        }

        String codigo = InputUtils.lerString("Digite o código do produto a ser alterado:");

        Produto produtoEncontrado = null;
        for(int i = 0; i < quantidadeProdutos; i++){
            if(produtos[i] != null && produtos[i].getCodigo().equals(codigo)){
                produtoEncontrado = produtos[i];
                break;
            }
        }

        if(produtoEncontrado ==  null){
            System.out.println("\nProduto não encontrado!");
            return;
        }

        System.out.println("\nProduto encontrado!");
        System.out.println("Código: " + produtoEncontrado.getCodigo());
        System.out.println("Nome: " + produtoEncontrado.getNome());
        System.out.println("Preço: R$ " + produtoEncontrado.getPrecoBase());

        if (produtoEncontrado instanceof ProdutoFisico) {
            ProdutoFisico pf = (ProdutoFisico) produtoEncontrado;
            System.out.println("Estoque: " + pf.getEstoque());
        } else if (produtoEncontrado instanceof ProdutoDigital) {
            ProdutoDigital pd = (ProdutoDigital) produtoEncontrado;
            System.out.println("Tamanho do download: " + pd.getTamanhoMB() + " MB");
        } else if (produtoEncontrado instanceof ProdutoPerecivel) {
            ProdutoPerecivel pp = (ProdutoPerecivel) produtoEncontrado;
            System.out.println("Validade: " + pp.getValidade());
        }
        System.out.println("\nO que deseja alterar?");
        System.out.println("1.Nome");
        System.out.println("2.Preço");
        if(produtoEncontrado instanceof ProdutoFisico){
            System.out.println("3. Estoque");
        } else if(produtoEncontrado instanceof ProdutoDigital){
            System.out.println("3. tamanho do download em MB");
        } else if(produtoEncontrado instanceof ProdutoPerecivel){
            System.out.println("3. Data de validade");
        }

        int opcaoAlteracao = InputUtils.lerInt("\nEscolha a opção: ");

        if(opcaoAlteracao == 1){
            String novoNome = InputUtils.lerString("Novo nome: ");
            produtoEncontrado.setNome(novoNome);
            System.out.println("Nome alterado com sucesso!");
        }else if(opcaoAlteracao == 2){
            BigDecimal novoPreco = InputUtils.lerBigDecimal("Digite o novo preço: ");
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
    
    // OPÇÃO 3 - CADASTRAR CLIENTE
    private static void cadastrarCliente(){
            System.out.println("\n=== Cadastro de Cliente ===");
            System.out.println("=== Pessoa Física ===");
            System.out.println("1 - Cleysla Maria");
            System.out.println("2 - José Gabriel");
            System.out.println("3 - Maria Aparecida");
            System.out.println("=== Pessoa Juridica ===");
            System.out.println("4 - Empresa Y");
            System.out.println("5 - Empresa X");
            System.out.println("6 - Empresa z");
            int opcaoCliente = InputUtils.lerInt("Escolha o cliente:");

            Cliente novoCliente = null;

            if(opcaoCliente == 1){
                novoCliente = new PessoaFisica("CLI001", "Cleysla Maria", "Rua A, 26, Bairro Inacio", "(79) 98888-1234", "111.222.333-44");        
            } else if(opcaoCliente == 2){
                novoCliente = new PessoaFisica("CLI002", "José Gabriel", "Rua B, 57, Bairro Centro","(79) 99988-1432", "555.666.777-88");
            }else if(opcaoCliente == 3){
                novoCliente = new PessoaFisica("CLI003", "Maria Aparecida", "Rua C, 127, Bairro Centro", "(79) 99978-3857", "999.888.777-66");
            }else if(opcaoCliente == 4){
                novoCliente = new PessoaJuridica("EMP001", "Empresa Y", "(79) 3300-9999", "Av. Principal, 456, Bairro Industrial", "12.345.678/0001-90");
            }else if(opcaoCliente == 5){
                novoCliente = new PessoaJuridica("EMP002", "Empresa X", "(79) 3555-8765", "Av. Etelvino, 89, Bairro Centro", "12.345.678/0001-90");
            }else if(opcaoCliente == 6){
                novoCliente = new PessoaJuridica("EMP003", "Empresa z", "(79) 3987-6543", "Av. Principal, 77, Bairro Industrial", "12.345.678/0001-90");
            } else{
                System.out.println("Opção inválida");
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

    // OPÇÃO 4 - ALTERAR CLIENTE
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

    // OPÇÃO 5 - CRIAR NOTA DE COMPRA
    public static void criarNota() {
            System.out.println("\n======= Criar Nota =======");

            if (quantidadeClientes == 0) {
                System.out.println("Nenhum cliente cadastrado");
                return;
            }

            // Lista de clientes
            System.out.println("===== Clientes Cadastrados =====");
            for (int i = 0; i < quantidadeClientes; i++) {
                System.out.println((i + 1) + " - " + clientes[i].getNome() + " - ID: " + clientes[i].getId());
            }

            int opcaoCliente = InputUtils.lerInt("Escolha o número do cliente: ");
            if (opcaoCliente < 1 || opcaoCliente > quantidadeClientes) {
                System.out.println("Cliente inválido");
                return;
            }

            Cliente clienteSelecionado = clientes[opcaoCliente - 1];
            Nota nota = new Nota(clienteSelecionado);

            while (true) {
                listarProdutos();

                String cod = InputUtils.lerString("Digite o código do produto (ou 'fim' para encerrar): ");
                if (cod.equalsIgnoreCase("fim")) {
                    break;
                }

                Produto produtoSelecionado = null;
                for (int i = 0; i < quantidadeProdutos; i++) {
                    if (produtos[i].getCodigo().equalsIgnoreCase(cod)) {
                        produtoSelecionado = produtos[i];
                        break;
                    }
                }

                if (produtoSelecionado == null) {
                    System.out.println("Produto não encontrado!");
                    continue;
                }

                int qtd = InputUtils.lerInt("Digite a quantidade: ");
                if (qtd <= 0) {
                System.out.println("Quantidade inválida.");
                continue;
            }

            nota.adicionarItem(produtoSelecionado.getNome(), qtd, produtoSelecionado.getPrecoBase());
            System.out.println("Produto adicionado");

            nota.resumoNota();
            }
    }


    // CRIAR NOTA FISCAL

    private static void criarNotaDeCompra() {
        System.out.println("\n=== Criar Nota ===");

        if (quantidadeClientes == 0 || quantidadeProdutos == 0) {
            System.out.println("É necessario ter ao menos um cliente e um produto cadastrados");
            return;
        }

        System.out.println("\nClientes cadastrados:");
        for (int i = 0; i < quantidadeClientes; i++) {
            System.out.println(i + " - " + clientes[i].getNome() + " (ID: " + clientes[i].getId() + ")");
        }
        int idxCli = InputUtils.lerInt("Escolha o indice do cliente: ");
        if (idxCli < 0 || idxCli >= quantidadeClientes) {
            System.out.println("Indice invalido");
            return;
        }

        Cliente clienteEscolhido = clientes[idxCli];
        Nota nota = new Nota(clienteEscolhido);

        boolean continuar = true;
        while (continuar) {
            listarProdutos();
            String cod = InputUtils.lerString("Codigo do produto (ou fim para encerrar): ");
            if (cod.equalsIgnoreCase("fim")) break;

            Produto pEscolhido = null;
            for (int i = 0; i < quantidadeProdutos; i++) {
                if (produtos[i].getCodigo().equals(cod)) {
                    pEscolhido = produtos[i];
                    break;
                }
            }
            if (pEscolhido == null) {
                System.out.println("Produto nao encontrado");
                continue;
            }

            int qtd = InputUtils.lerInt("Quantidade: ");
            if (qtd <= 0) {
                System.out.println("Quantidade invalida");
                continue;
            }

            nota.adicionarItem(pEscolhido.getNome(), qtd, pEscolhido.getPrecoBase());
            System.out.println("Item adicionado");

            String resp = InputUtils.lerString("Adicionar mais itens? (s/n): ");
            if (!resp.equalsIgnoreCase("s")) continuar = false;
        }

        if (quantidadeNotas < notas.length) {
            notas[quantidadeNotas++] = nota;
        }

        nota.resumoNota();
    }

    // OPÇÃO 6 - LISTAR NOTAS EMITIDAS
    
    private static void listarNotasEmitidas() {
        System.out.println("\n=== Notas Emitidas ===");
        if (quantidadeNotas == 0) {
            System.out.println("Nenhuma nota emitida");
            return;
        }
        for (int i = 0; i < quantidadeNotas; i++) {
            notas[i].resumoNota();
        }
    }

    // OPÇÃO 7 - LISTAR PRODUTOS
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

    // OPÇÃO 8 - LISTAR CLIENTES
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
