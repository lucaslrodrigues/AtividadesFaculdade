public class PesqusaBinaria {
    public static void main(String[] args) {
        int[] v = {4, 7, 5, 2, 8, 1, 6, 3};

        System.out.println("Pesquisa binaria");
        System.out.println(pesquisaBinaria(v, 6));
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

