public interface Tributavel {
    static final double taxaFixa = 3.1;
    public double getValorTributo();

    default void calcularTributoAnual(){
        System.out.println("Isso é padrão para qualquer classe que usar!");

        analisarCalculoMensal(); // é dependente do metodo default para ser iniciado (não é muito utilizado)
    }

    private double analisarCalculoMensal(){
        return 10.3;
    }
}
