package main.java;

public class AppPrimitivos {
    public static void main(String[] args) {
        System.out.println(" é nóis no intellij");

        String bairro = null;
        String cidade = "";
        System.out.println(null == "");
        System.out.println("Bairro: "+bairro);
        System.out.println("Cidade: "+cidade);

        cidade = "São Paulo";
        System.out.println("Cidade: "+cidade.toUpperCase());

        Double altura = 1.89;
        System.out.println("Alt: "+ altura.intValue());

        // A linha a baixo provoca NPE
        // System.out.println("Bairro: "+bairro.toUpperCase());

        int filhos = 3;
        double peso = 70.0;
        boolean temMundial = false;
        char escolha = 'B'; // Com aspas simples sempre


    }
}
