package loja.ui;

public class ConsoleMenu {

    public void exibirMenu() {
        Scanner scanner = new Scanner(System.in);
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
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    System.out.println("Cadastrar Produto");
                    break;
                case 2:
                    System.out.println("Alterar Produto");
                    break;
                case 3:
                    System.out.println("Cadastrar Cliente");
                    break;
                case 4:
                    System.out.println("Alterar Cliente");
                    break;
                case 5:
                    System.out.println("Criar Nota de Compra");
                    break;
                case 6:
                    System.out.println("Listar Notas Emitidas");
                    break;
                case 7:
                    System.out.println("Listar Produtos");
                    break;
                case 8:
                    System.out.println("Listar Clientes");
                    break;
                case 0:
                    System.out.println("Saindo");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }
}
