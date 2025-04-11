import ExChanceRate.Conversor;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Hello, World!");
        Conversor conversor = new Conversor();

        System.out.println(conversor.pegarCotacao(3, 200.0));
    }
}