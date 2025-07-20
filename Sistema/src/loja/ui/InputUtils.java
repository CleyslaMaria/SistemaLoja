package loja.ui;

import java.util.Scanner;

public class InputUtils {
    private static final Scanner scanner = new Scanner(System.in);

    public static int lerInt(String mensagem) {
        System.out.print(mensagem);
        while (!scanner.hasNextInt()) {
            System.out.println("Digite um numero valido: ");
            scanner.next(); 
        }
        return scanner.nextInt();
    }

    public static String lerString(String mensagem) {
        System.out.print(mensagem);
        return scanner.next();
    }

   
}
