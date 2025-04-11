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

    public Moeda pegarCotacao(int opcao, Double valor) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        JsonObject json = gson.fromJson(response.body(), JsonObject.class);
        JsonObject taxas = json.getAsJsonObject("conversion_rates");

        return switch (opcao) {
            case 1 -> new Moeda("Real Brasileiro (BRL)", valor * taxas.get("BRL").getAsDouble());
            case 2 -> new Moeda("Dólar Americano (USD)", valor * taxas.get("USD").getAsDouble());
            case 3 -> new Moeda("Peso Argentino (ARS)", valor * taxas.get("ARS").getAsDouble());
            case 4 -> new Moeda("Peso Colombiano (COP)", valor * taxas.get("COP").getAsDouble());
            case 5 -> new Moeda("Euro (EUR)", valor * taxas.get("EUR").getAsDouble());
            default -> new Moeda("Moeda inválida", 0.0);
        };
    }
}
