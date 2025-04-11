import ExChanceRate.Conversor;
import ExChanceRate.Menu;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Conversor conversor = new Conversor();
        Menu menu = new Menu();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Scanner scanner = new Scanner(System.in);

        menu.mostrarOpcoes();

        int opcao = scanner.nextInt();
        System.out.println("Dígite um valor que deseja converter: ");
        double valor = scanner.nextDouble();

        System.out.println(conversor.converterMoeda(opcao,valor));

        scanner.close();
    }
}