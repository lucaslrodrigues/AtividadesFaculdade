public class ListaEstatica {
    int[] vetor;
    int nroElem;

    public ListaEstatica(int tamanho) {
        this.vetor = new int[tamanho];
        this.nroElem = 0;
    }

    public void adiciona(int numAdd){
        if (nroElem == vetor.length) {
            System.out.println("Lista cheia");
        }else{
            vetor[nroElem] = numAdd;
            nroElem ++;
        }
    }

    public void exibe(){
        for (int i = 0; i < vetor.length; i++) {
            System.out.println(vetor[i]);
        }
    }

    public int busca(int numBusca){
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] == numBusca) {
                return i;
            }
        }
        return -1;
    }

    public boolean removePeloIndice(int indiceRemover){
        if (indiceRemover < vetor.length - 1 && indiceRemover > 0) {
            vetor[indiceRemover] = 0;
            nroElem --;
            int valorPosterior = 0;
            for (int i = indiceRemover; i < vetor.length; i++) {
                if (i < nroElem) {
                    valorPosterior = vetor[i+1];
                    vetor[i] = valorPosterior;
                }else{
                    vetor[i] = 0;
                }
            }
            return true;
        }
        return false;
    }

    public boolean removerElemento(int numRemover){
        for (int i = 0; i < vetor.length; i++) {
            if (numRemover == vetor[i]) {
                vetor[i] = 0;
                nroElem--;
                int valorPosterior = 0;
                for (int j = i; j < vetor.length; j++) {
                    if (j < nroElem) {
                        valorPosterior = vetor[j + 1];
                        vetor[j] = valorPosterior;
                    } else {
                        vetor[j] = 0;
                    }
                }
                return true;
            }
        }
        return false;
    }
}
