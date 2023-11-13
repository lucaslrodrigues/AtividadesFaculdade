public class Main {
    public static void main(String[] args) {

        PilhaObj<String> pilha = new PilhaObj<>(3);
        pilha.push("Hello ");
        pilha.push("World");
        pilha.push("!");
        pilha.exibe();
        pilha.pop();
        pilha.exibe();
        pilha.pop();
        pilha.exibe();
        pilha.pop();
        pilha.exibe();

        exibirAoContrario("A pilha do gato");
        palavraEhPalindromo("subi no onibus");
    }
    public static void exibirAoContrario(String frase){
        for (int i = frase.length() - 1; i >= 0; i--) {
            System.out.printf("%s", frase.charAt(i));
        }
    }

    public static boolean palavraEhPalindromo(String p){
        String palavra = p.trim();
        PilhaObj pilha = new PilhaObj(p.length());
        for (int i = 0; i < p.length(); i++) {

        }
        int meio = palavra.length() / 2;
        for (int i = 0; i < meio; i++) {
            if (palavra.charAt(palavra.length() - (i + 1)) != palavra.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}