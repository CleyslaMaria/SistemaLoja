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
            System.out.print("Escolha uma opcao: ");

            opcao = scanner.nextInt();
            scanner.nextLine(); 

            if (opcao == 1) {
                System.out.println("Cadastrar Produto");
            } else if (opcao == 2) {
                System.out.println("Alterar Produto");
            } else if (opcao == 3) {
                System.out.println("Cadastrar Cliente");
            } else if (opcao == 4) {
                System.out.println("Alterar Cliente");
            } else if (opcao == 5) {
                System.out.println("Criar Nota de Compra");
            } else if (opcao == 6) {
                System.out.println("Listar Notas Emitidas");
            } else if (opcao == 7) {
                System.out.println("Listar Produtos");
            } else if (opcao == 8) {
                System.out.println("Listar Clientes");
            } else if (opcao == 0) {
                System.out.println("Saindo");
            } else {
                System.out.println("Opcao invalida. Tente novamente.");
            }

        } while (opcao != 0);

        scanner.close();
    }
}
