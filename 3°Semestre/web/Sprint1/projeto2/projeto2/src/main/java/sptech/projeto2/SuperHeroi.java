package sptech.projeto2;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class SuperHeroi {
    @JsonIgnore
    private String nomeVerdadeiro;
    private String nomeHeroi;
    private Double forca;
    private Boolean voa;

    public SuperHeroi(String nomeVerdadeiro, String nomeHeroi, Double forca, Boolean voa) {
        this.nomeVerdadeiro = nomeVerdadeiro;
        this.nomeHeroi = nomeHeroi;
        this.forca = forca;
        this.voa = voa;
    }

    public String getNomeVerdadeiro() {
        return nomeVerdadeiro;
    }

    public void setNomeVerdadeiro(String nomeVerdadeiro) {
        this.nomeVerdadeiro = nomeVerdadeiro;
    }

    public String getNomeHeroi() {
        return nomeHeroi;
    }

    public void setNomeHeroi(String nomeHeroi) {
        this.nomeHeroi = nomeHeroi;
    }

    public Double getForca() {
        return forca;
    }

    public void setForca(Double forca) {
        this.forca = forca;
    }

    /*
    As propriedades do Json são criadas a partir dos Getters
    */
//    public Boolean getVoa() {
//        return voa;
//    }

    public void setVoa(Boolean voa) {
        this.voa = voa;
    }

    /*
        Aqui criamos um:
        Atributo virtual
        Campo virtual
        Atributo calculado
        Campo calculado
    */

    public String getCategoria(){
        return forca < 1000 ? "Fraco" : "Forte";
    }
}
