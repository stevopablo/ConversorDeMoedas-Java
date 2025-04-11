package ExChanceRate;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Conversor {
    private final String API = "https://v6.exchangerate-api.com/v6/5f1d82b04f491ec8ec1faa45/latest/USD";
    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public Moeda converterMoeda(int opcao, double valor) throws IOException, InterruptedException {
      try {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        JsonObject json = gson.fromJson(response.body(), JsonObject.class);
        JsonObject taxas = json.getAsJsonObject("conversion_rates");

        String origem = "";
        String destino = "";

        switch (opcao) {
            case 1 -> { origem = "USD"; destino = "ARS"; }
            case 2 -> { origem = "ARS"; destino = "USD"; }
            case 3 -> { origem = "USD"; destino = "BRL"; }
            case 4 -> { origem = "BRL"; destino = "USD"; }
            case 5 -> { origem = "USD"; destino = "COP"; }
            case 6 -> { origem = "COP"; destino = "USD"; }
            default -> {
                throw new ConversaoException("Opção inválida! Escolha um número entre 1 e 6");
            }
        }
        double taxaOrigem = taxas.get(origem).getAsDouble();
        double taxaDestino = taxas.get(destino).getAsDouble();

        double valorEmUSD = valor / taxaOrigem;
        double valorConvertido = valorEmUSD * taxaDestino;

        return new Moeda(origem, destino, valor, valorConvertido);
      }catch (ConversaoException | IOException | InterruptedException e){
          System.out.println(e.getMessage());
          return new Moeda("Erro", "Erro",0.0,00);
      }
    }
}
