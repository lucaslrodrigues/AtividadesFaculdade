public class ListaEstatica {
    int[] vetor;
    int nroElem;

    public ListaEstatica(int tamanho) {
        this.vetor = new int[tamanho];
        this.nroElem = 0;
    }

    public void adiciona(int numAdd){
        if (nroElem == vetor.length) {
            throw new IllegalStateException();
        }else{
            System.out.println("Adicionando "+ numAdd);
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
        if (indiceRemover < nroElem && indiceRemover > -1) {
            vetor[indiceRemover] = 0;
            nroElem --;
            int valorPosterior = 0;
            for (int i = indiceRemover; i < vetor.length; i++) {
                if (i < nroElem) {
                    vetor[i] = vetor[i+1];
                }else{
                    vetor[i] = 0;
                }
            }
            return true;
        }
        return false;
    }

    public boolean removeElemento(int numRemover){
        for (int i = 0; i < vetor.length; i++) {
            if (numRemover == vetor[i]) {
                removePeloIndice(i);
                return true;
            }
        }
        return false;
    }

    public boolean substitui(int valorAntigo, int valorNovo){
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] == valorAntigo) {
                vetor[i] = valorNovo;
                return true;
            }
        }
        System.out.println("Valor não encontrado");
        return false;
    }

    public int contaOcorrencias(int valorRecebido){
        int cont = 0;
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] == valorRecebido){
                cont ++;
            }
        }
        return cont;
    }

    public boolean adicionaNoInicio(int valorAdicionar){
        if (vetor.length == nroElem) {
            System.out.println("Lista cheia");
        }else{
            for (int i = vetor.length -1; i > 0; i--) {
                vetor[i] = vetor[i-1];
            }
            vetor[0] = valorAdicionar;
            nroElem ++;
            return true;
        }
        return false;
    }
}
