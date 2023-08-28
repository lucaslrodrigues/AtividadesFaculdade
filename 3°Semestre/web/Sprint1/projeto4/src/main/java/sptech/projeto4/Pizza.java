package sptech.projeto4;

import java.util.concurrent.ThreadLocalRandom;

public class Pizza {
    private Integer codigo;
    private String sabor;
    private Double valor;
    private int quantidade;

    public Pizza() {
        codigo = ThreadLocalRandom.current().nextInt(1, 1001);
    }

    public Pizza(String sabor, Double valor, int quantidade) {
        this();
        this.sabor = sabor;
        this.valor = valor;
        this.quantidade = quantidade;
    }

    public void registrarVenda(int quantidade){
        if (this.quantidade >= quantidade){
            this.quantidade -= quantidade;
        }
    }

    public Double getValorEmEstoque(){
        return valor * quantidade;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getSabor() {
        return sabor;
    }

    public Double getValor() {
        return valor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
