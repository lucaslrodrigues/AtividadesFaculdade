public class ExemploOrdenacao {
    public static void main(String[] args) {
        int[] v1 = {4, 7, 5, 2, 8, 1, 6, 3};
        int[] v2 = {4, 7, 5, 2, 8, 1, 6, 3};
        int[] v3 = {4, 7, 5, 2, 8, 1, 6, 3};
        int[] v4 = {4, 7, 5, 2, 8, 1, 6, 3};

        selectionsort(v1);

        selectOtimizado(v2);

        bubllesort(v3);

        for (int i = 0; i < v1.length - 1; i++) {
            for (int j = i + 1; j < v1.length; j++) {
                if (v1[j] < v1[i]){
                    int aux = v1[i];
                    v1[i] = v1[j];
                    v1[j] = aux;
                }
            }
        }
        System.out.println("Selection sort");
        exibirVetor(v1);

        System.out.println("Selection sort otimizado");
        exibirVetor(v2);

        System.out.println("Bubble sort");
        exibirVetor(v3);

        System.out.println("Pesquisa binaria");
        System.out.println(pesquisaBinaria(v4, 6));
    }

    public static void exibirVetor(int[] v){
        for (int i = 0; i < v.length; i++) {
            System.out.println(v[i]);
        }
    }
    public static void selectionsort(int[] v){
        for (int i = 0; i < v.length - 1; i++) {
            for (int j = i + 1; j < v.length; j++) {
                if (v[j] < v[i]){
                    int aux = v[i];
                    v[i] = v[j];
                    v[j] = aux;
                }
            }
        }
    }

    public static void selectOtimizado(int[] v){
        for (int i = 0; i < v.length - 1; i++) {
            int menor = i;
            for (int j = i + 1; j < v.length; j++) {
                if (v[j] < v[menor]){
                    menor = j;
                }
            }
            int auxiliar = v[i];
            v[i] = v[menor];
            v[menor] = auxiliar;
        }
    }

    public static void bubllesort(int[] v){
        boolean validacao = false;
        while (!validacao) {
            int i = 0;
            validacao = true;
            for (i = 0; i < v.length - 1; i++) {
                for (int j = i + 1; j < v.length; j++) {
                    if (v[j] < (v[j - 1])) {
                        mudarMaior(v, j);
                        validacao = false;
                    }
                }
            }
            i = 0;
        }
    }

    public static void mudarMaior(int[] v, int j){
        int aux = v[j - 1];
        v[j - 1] = v[j];
        v[j] = aux;
    }

    public static Integer pesquisaBinaria(int[] v, Integer numBusca){
        Integer indInf = 0;
        Integer indSup = v.length - 1;
        Integer encontrado = -1;

        bubllesort(v);
        while (indInf < indSup) {
            Integer meio = (indInf + indSup) / 2;
            if (numBusca.equals(v[meio])) {
                encontrado = meio;
            }
            if (numBusca < v[meio]) {
                indSup = meio - 1;
            }else{
                indInf = meio + 1;
            }
        }
        return encontrado;
    }
}