package loja.ui;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class InputUtils {
    private static final Scanner scanner = new Scanner(System.in);

    public static int lerInt(String mensagem) {
        System.out.print(mensagem);
        while (!scanner.hasNextInt()) {
            System.out.println("Digite um inteiro valido: ");
            scanner.next();
        }
        int valor = scanner.nextInt();
        scanner.nextLine(); 
        return valor;
    }

     public static double lerDouble(String mensagem) {
        System.out.print(mensagem);
        while (!scanner.hasNextDouble()) {
            System.out.println("Digite um numero decimal valido: ");
            scanner.next();
        }
        double valor = scanner.nextDouble();
        scanner.nextLine();
        return valor;
    }

    public static String lerString(String mensagem) {
        System.out.print(mensagem);
        return scanner.nextLine();
    }

    public static BigDecimal lerBigDecimal(String mensagem) {
        System.out.print(mensagem);
        while (true) {
            String entrada = scanner.nextLine().trim().replace(",", ".");
            try {
                return new BigDecimal(entrada);
            } catch (NumberFormatException e) {
                System.out.println("Formato invalido. Exemplo: 19.99 ou 19,99");
            }
        }
    }

    public static LocalDateTime lerDataHora(String mensagem) {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        System.out.print(mensagem + " (formato dd/MM/yyyy HH:mm) "); //atentar aq
        while (true) {
            String entrada = scanner.nextLine().trim();
            try {
                return LocalDateTime.parse(entrada, formato);
            } catch (DateTimeParseException e) {
                System.out.println("Formato invalido. Exemplo: 16/05/1472 14:30");
                
            }
        }
    }

    public static LocalDate lerLocalDate(String mensagem) {
    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    System.out.print(mensagem + " (formato dd/MM/yyyy): ");
    while (true) {
        String entrada = scanner.nextLine().trim();
        try {
            return LocalDate.parse(entrada, formato);
        } catch (DateTimeParseException e) {
            System.out.println("Formato inválido. Exemplo: 16/05/1472");
        }
    }
}


    public static void fecharScanner() {
        scanner.close();
    }
}
