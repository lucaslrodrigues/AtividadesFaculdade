import java.util.ArrayList;
import java.util.List;

public class Tributo {
    private List<Tributavel> tributavelList;

    public Tributo() {
        this.tributavelList = new ArrayList<>();
    }

    public void adicionarTributavel(Tributavel tributavel){
        tributavelList.add(tributavel);
    }

    public double calculaTotalTributo(){
        double total = 0;
        for (Tributavel t: tributavelList) {
            total += t.getValorTributo();
        }
        return total;
    }

    public void exibeTodos(){
        for (Tributavel t: tributavelList) {
            System.out.println(t);
        }
    }
}
