import java.util.ArrayList;
import java.util.List;

public class Repositorio {
    private List<Roupa> lista;
    private PilhaObj<Integer> pilha;

    public Repositorio() {
        this.lista = new ArrayList<>();
        this.pilha = new PilhaObj<>(10);
    }

    public void salvar(Roupa roupa){
        if (!pilha.isFull()) {
            pilha.push(roupa.getId());
            lista.add(roupa);
        }
    }

    public void deletar(Integer id){
        for (int i = 0; i < lista.size(); i++) {
            if (id.equals(lista.get(i).getId())){
                lista.remove(lista.get(i));
            }
        }
    }

    public void exibir(){
        if(lista.isEmpty()){
            System.out.println("Repositório vazio");
        }
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(String.format("%s", lista.get(i)));
        }

        pilha.exibe();
    }

    public void desfazer(){
        if (lista.isEmpty()) {
            System.out.println("Não há nada a fazer aqui");
        }else{
            deletar(pilha.peek());
        }
    }
}
