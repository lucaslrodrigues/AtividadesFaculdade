import java.util.ArrayList;
import java.util.List;

public class InstituicaoFinanceira {
    private String nome;
    private String cnpj;
    private List<IMonetario> monetarios;

    public InstituicaoFinanceira(String nome, String cnpj) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.monetarios = new ArrayList<>();
    }

    public void adicionarMonetario(IMonetario monetario){
        monetarios.add(monetario);
    }

    public void exibirMonetarios(){
        for (IMonetario m: monetarios){
            System.out.println(m);
        }
    }

}
