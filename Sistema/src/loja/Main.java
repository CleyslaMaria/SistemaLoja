package loja;

import loja.ui.ConsoleMenu;
import loja.ui.InputUtils;


public class Main {
    public static void main(String[] args) {
        System.out.println("Sistema iniciado!");

        ConsoleMenu.exibirMenu();

        InputUtils.fecharScanner();

        System.out.println("Programa encerrado.");
    }
}
