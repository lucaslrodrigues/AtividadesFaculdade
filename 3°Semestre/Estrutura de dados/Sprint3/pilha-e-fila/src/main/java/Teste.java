public class Teste {
    public static void main(String[] args) {
        int[] v = {2,7,-3,-50,45,-4,30,-21,38};

//        separaPositivoNegativoEmOrdem(v);
        separaPositivoNegativoOrdemDiferente(v);
    }

    public static void separaPositivoNegativoEmOrdem(int[] vetor){
        FilaObj<Integer> positivos = new FilaObj<>(vetor.length);
        FilaObj<Integer> negativos = new FilaObj<>(vetor.length);
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] < 0) {
                negativos.insert(vetor[i]);
            }else {
                positivos.insert(vetor[i]);
            }
        }
        while (!positivos.isEmpty()){
            System.out.println(positivos.poll());
        }
        while (!negativos.isEmpty()){
            System.out.println(negativos.poll());
        }
    }

    public static void separaPositivoNegativoOrdemDiferente(int[] vetor){
        FilaObj<Integer> fila = new FilaObj<>(vetor.length);
        PilhaObj<Integer> pilha = new PilhaObj<>(vetor.length);

        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] < 0) {
                pilha.push(vetor[i]);
            }else {
                fila.insert(vetor[i]);
            }
        }
        while (!fila.isEmpty()){
            System.out.println(fila.poll());
        }
        while (!pilha.isEmpty()){
            System.out.println(pilha.pop());
        }
    }
}
