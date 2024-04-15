import java.util.stream.IntStream;

public class PilhaObj<T> {
    private int topo;
    private int[] pilha;

    public PilhaObj(int capacidade) {
        this.topo = -1;
        this.pilha = new int[capacidade];
    }

    public boolean isEmpty(){
        return topo < 0 ? true : false;
    }

    public boolean isFull(){
        return topo >= pilha.length - 1? true : false;
    }

    public void push(int info){
        if (!(topo >= pilha.length - 1)) {
            pilha[++topo] = info;
        }else{
            throw new IllegalStateException("A lista está cheia");
        }
    }

    public int pop(){
        if (topo > - 1) {
            int retorno = pilha[topo];
            pilha[topo--] = 0;
            return retorno;
        }
        return topo;
    }

    public int peek(){
        return topo > - 1 ? pilha[topo] : topo;
    }

    public void exibe(){
        if (topo >= 0) {
            System.out.println("--------- PILHA ----------");
            IntStream.rangeClosed(0, topo).forEachOrdered(i -> System.out.printf("%s\n", pilha[i]));
        }
    }

    public boolean ehPalindromo(){
        for (int i = 0; i < topo; i++) {
            if (pilha[i] != pop()){
                return false;
            }
        }
        return true;
    }



    //Getters & Setters (manter)
    public int getTopo() {
        return topo;
    }
}
