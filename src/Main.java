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

        boolean sair = false;
        while (!sair){

        menu.mostrarOpcoes();

        int opcao = scanner.nextInt();
        if (opcao == 7){
            sair = true;
            System.out.println("Até mais...");
            break;
        }
        if (opcao < 1 || opcao > 7){
            System.out.println(opcao+ " Não é opção válida");
            continue;
        }
        System.out.println("Dígite um valor que deseja converter: ");
        double valor = scanner.nextDouble();

        System.out.println(conversor.converterMoeda(opcao,valor));
        }
        scanner.close();

    }
}