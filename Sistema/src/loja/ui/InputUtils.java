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
    String entrada;
    do {
        System.out.print(mensagem);
        entrada = scanner.nextLine().trim();
        if (entrada.isEmpty()) {
            System.out.println("A entrada nao pode estar vazia. Tente novamente.");
        }
    } while (entrada.isEmpty());
    return entrada;
}

    public static BigDecimal lerBigDecimal(String mensagem) {
    System.out.print(mensagem);
    while (true) {
        String entrada = scanner.nextLine().trim().replace(",", ".");
        boolean valido = true;
        for (int i = 0; i < entrada.length(); i++) {
            char c = entrada.charAt(i);
            if (!Character.isDigit(c) && c != '.') {
                valido = false;
                break;
            }
        }
        if (valido && entrada.contains(".")) {
            return new BigDecimal(entrada);
        } else {
            System.out.println("Formato inválido. Exemplo: 19.99 ou 19,99");
            System.out.print(mensagem);
        }
    }
}


    public static LocalDate lerLocalDate(String mensagem) {
    System.out.print(mensagem + " (formato dd/MM/yyyy): ");
    while (true) {
        String entrada = scanner.nextLine().trim();
        if (entrada.length() == 10 && entrada.charAt(2) == '/' && entrada.charAt(5) == '/') {
            String diaStr = entrada.substring(0, 2);
            String mesStr = entrada.substring(3, 5);
            String anoStr = entrada.substring(6, 10);
            if (soNumeros(diaStr) && soNumeros(mesStr) && soNumeros(anoStr)) {
                int dia = Integer.parseInt(diaStr);
                int mes = Integer.parseInt(mesStr);
                int ano = Integer.parseInt(anoStr);
                if (dia >= 1 && dia <= 31 && mes >= 1 && mes <= 12) {
                    return LocalDate.of(ano, mes, dia);
                }
            }
        }
        System.out.println("Formato inválido. Exemplo: 16/05/2023");
        System.out.print(mensagem + " (formato dd/MM/yyyy): ");
    }
}


    public static LocalDateTime lerLocalDateTime(String mensagem) {
    System.out.print(mensagem + " (formato dd/MM/yyyy HH:mm): ");
    while (true) {
        String entrada = scanner.nextLine().trim();
        if (entrada.length() == 16 && entrada.charAt(2) == '/' && entrada.charAt(5) == '/' && entrada.charAt(10) == ' ' && entrada.charAt(13) == ':') {
            String diaStr = entrada.substring(0, 2);
            String mesStr = entrada.substring(3, 5);
            String anoStr = entrada.substring(6, 10);
            String horaStr = entrada.substring(11, 13);
            String minutoStr = entrada.substring(14, 16);
            if (soNumeros(diaStr) && soNumeros(mesStr) && soNumeros(anoStr) && soNumeros(horaStr) && soNumeros(minutoStr)) {
                int dia = Integer.parseInt(diaStr);
                int mes = Integer.parseInt(mesStr);
                int ano = Integer.parseInt(anoStr);
                int hora = Integer.parseInt(horaStr);
                int minuto = Integer.parseInt(minutoStr);
                if (dia >= 1 && dia <= 31 && mes >= 1 && mes <= 12 && hora >= 0 && hora <= 23 && minuto >= 0 && minuto <= 59) {
                    return LocalDateTime.of(ano, mes, dia, hora, minuto);
                }
            }
        }
        System.out.println("Formato inválido. Exemplo: 16/05/2023 14:30");
        System.out.print(mensagem + " (formato dd/MM/yyyy HH:mm): ");
    }
}


private static boolean soNumeros(String texto) {
    for (int i = 0; i < texto.length(); i++) {
        if (!Character.isDigit(texto.charAt(i))) {
            return false;
        }
    }
    return true;
}    

public static void fecharScanner() {
        scanner.close();
    }
}
