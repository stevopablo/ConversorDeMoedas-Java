package ExChanceRate;
import java.util.ArrayList;
import java.util.List;

public class Registro {
    List<Moeda> registros = new ArrayList<>();

    public void salvarConversao(Moeda moeda){
        registros.add(moeda);
    }

    public void mostrarHistorico(){
        System.out.println("Histórico de Conversões");
        for (Moeda m : registros){
            System.out.println(m + " "+  m.getHora());
        }
    }

    public void tamanhoLista(){
        System.out.println(registros.size());
    }
}
