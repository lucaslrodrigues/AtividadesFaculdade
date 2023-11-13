public class Pilha {
    private int topo;
    private int[] pilha;

    public Pilha(int capacidade) {
        this.topo = -1;
        this.pilha = new int[capacidade];
    }

    public boolean isEmpty(){
        return topo < 0 ? true : false;
    }

    public boolean isFull(){
        return topo > pilha.length - 1? true : false;
    }

    public void push(int info){
        if (!(topo > pilha.length - 1)) {
            pilha[topo + 1] = info;
            topo ++;
        }
    }

    public int pop(){
        if (topo > - 1) {
            int retorno = pilha[topo];
            pilha[topo] = 0;
            topo --;
            return retorno;
        }
        return topo;
    }

    public int peek(){
        if (topo > - 1) {
            return pilha[topo];
        }
        return topo;
    }

    public void exibe(){
        if (topo < 0) {
            System.out.println("Pilha vazia");
        } else {
            for (int i = 0; i < topo; i++) {
                System.out.printf("%s", pilha[i]);
            }
        }
    }
}
