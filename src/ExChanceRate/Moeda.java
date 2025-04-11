package ExChanceRate;

import java.time.LocalDateTime;

public class Moeda {
    private String origem;
    private String destino;
    private double valor;
    private double valorConvertido;
    private LocalDateTime hora;

    public Moeda(String origem, String destino, double valor, double valorConvertido) {
        this.origem = origem;
        this.destino = destino;
        this.valor = valor;
        this.valorConvertido = valorConvertido;
        this.hora = LocalDateTime.now();
    }

    public LocalDateTime getHora() {
        return hora;
    }

    public String getOrigem() {
        return origem;
    }

    public String getDestino() {
        return destino;
    }

    public double getValor() {
        return valor;
    }

    public double getValorConvertido() {
        return valorConvertido;
    }

    @Override
    public String toString() {
       return "Valor "+ getValor() + " ("+ getOrigem()+ ") " + " corresponde ao valor final de =>>> " + getValorConvertido() + " (" + getDestino()+")";
    }
}
