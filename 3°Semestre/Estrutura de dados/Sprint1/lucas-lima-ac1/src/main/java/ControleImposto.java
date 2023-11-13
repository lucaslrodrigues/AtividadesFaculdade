import java.util.ArrayList;
import java.util.List;

public class ControleImposto {
    private List<IRenda> rendas;

    public ControleImposto() {
        this.rendas = new ArrayList<>();
    }

    public void adicionarRenda(IRenda r){
        rendas.add(r);
    }

    public Double totalImpostos(){
        Double total = 0.0;
        for(IRenda renda: rendas){
            total += renda.getValorImposto();
        }
        return total;
    }

    public void exibirImposto(){
        for (IRenda r: rendas){
            if (!r.getValorImposto().equals(0)){
                System.out.println(rendas);
            }
        }
    }

}
