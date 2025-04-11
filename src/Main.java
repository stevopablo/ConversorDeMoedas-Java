import ExChanceRate.Conversor;
import ExChanceRate.Menu;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Conversor conversor = new Conversor();
        Menu menu = new Menu();
        Scanner scanner = new Scanner(System.in);


        menu.mostrarOpcoes();
        int opcao = scanner.nextInt();
        System.out.println(conversor.converterMoeda(4,1));
    }
}