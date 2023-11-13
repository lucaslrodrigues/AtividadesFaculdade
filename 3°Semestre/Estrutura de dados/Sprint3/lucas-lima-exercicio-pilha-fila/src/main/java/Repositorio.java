import java.util.ArrayList;
import java.util.List;

public class Repositorio {
    private FilaObj<Roupa> fila;
    private List<Roupa> lista;
    private PilhaObj<Integer> pilha;

    public Repositorio() {
        this.fila = new FilaObj<>(10);
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
            System.out.println("Repositório vazio\n");
        } else {
            System.out.println("--------- LISTA ----------");
            for (int i = 0; i < lista.size(); i++) {
                System.out.println(String.format("%s", lista.get(i)));
            }
        }
        pilha.exibe();
        fila.exibe();
    }

    public void desfazer(){
        if (lista.isEmpty()) {
            System.out.println("Não há nada a fazer aqui");
        }else{
            deletar(pilha.peek());
        }
    }

    public void agendarSalvar(Roupa roupa){
        fila.insert(roupa);
    }

    public void executarAgendado(int qtdOperacoes){
        if (fila.isEmpty()) {
            System.out.println("Não há operações agendadas");
        } else if (qtdOperacoes <= 0 || qtdOperacoes > fila.getTamanho()){
            System.out.println("Quantidade inválida");
        } else {
            for (int i = 0; i < qtdOperacoes; i++) {
                pilha.push(fila.peek().getId());
                lista.add(fila.peek());
                fila.poll();
            }
        }
    }
}
