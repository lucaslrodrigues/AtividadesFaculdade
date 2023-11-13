package sptech.modelo;

public class Carro {
    private String modelo;
    private int anoFabricacao;
    private Fabricante fabricante;

    public Carro() {
    }

    public Carro(String modelo, int anoFabricacao, Fabricante fabricante) {
        this.modelo = modelo;
        this.anoFabricacao = anoFabricacao;
        this.fabricante = fabricante;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAnoFabricacao() {
        return anoFabricacao;
    }

    public Fabricante getFabricante() {
        return fabricante;
    }
}
