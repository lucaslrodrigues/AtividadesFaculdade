
public class ListaObj <T> {

    private T[] vetor;

    private int nroElem;

    public ListaObj(int tamanho) {
        this.vetor = (T[]) new Object[tamanho];
        this.nroElem = 0;
    }

    public void adiciona(T elemento) {
        if (nroElem == vetor.length) {
            throw new IllegalStateException();
        }else{
            System.out.println("Adicionando "+ elemento);
            vetor[nroElem] = elemento;
            nroElem ++;
        }
    }

    public int busca(T elementoBuscado) {
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] == elementoBuscado) {
                return i;
            }
        }
        return -1;
    }

    public boolean removePeloIndice(int indice) {
        if (indice < nroElem && indice > -1) {
            vetor[indice] = null;
            reordenarLista(indice);
            nroElem --;
            return true;
        }
        return false;
    }

    public void reordenarLista(int indice){
        for (int i = indice; i < vetor.length; i++) {
            if (i < nroElem - 1) {
                vetor[i] = vetor[i+1];
            }else{
                vetor[i] = null;
            }
        }
    }

    public boolean removeElemento(T elementoARemover) {
        int num = 0;
        for (int i = 0; i < nroElem; i++) {
            System.out.println("Volta" + ++num);
            if (elementoARemover.equals(vetor[i])) {
                vetor[i] = null;
                reordenarLista(0);
                nroElem --;
                return true;
            }
        }
        return false;
    }

    public int getTamanho() {
        return nroElem;
    }

    public T getElemento(int indice) {
        return indice < nroElem - 1 && indice >= 0 ? vetor[indice] : null;
    }

    public void limpa() {
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = null;
            this.nroElem = 0;
        }
    }

    public void exibe() {
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] != null) {
                System.out.println(vetor[i]);
            }
        }
    }

    public T[] getVetor() {
        return this.vetor;
    }
}
