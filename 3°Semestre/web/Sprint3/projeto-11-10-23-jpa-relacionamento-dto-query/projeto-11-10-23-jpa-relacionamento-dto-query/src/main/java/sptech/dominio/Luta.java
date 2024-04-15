package sptech.dominio;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Luta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;
    @ManyToOne
    @JsonIgnore
    private Pokemon pokemon1;
    @ManyToOne
    @JsonIgnore
    private Pokemon pokemon2;
    @ManyToOne
    @JsonIgnore
    private Pokemon vencedor;

    public Luta() {
    }

    public Pokemon getPokemon1() {
        return pokemon1;
    }

    public void setPokemon1(Pokemon pokemon1) {
        this.pokemon1 = pokemon1;
    }

    public Pokemon getPokemon2() {
        return pokemon2;
    }

    public void setPokemon2(Pokemon pokemon2) {
        this.pokemon2 = pokemon2;
    }

    public Pokemon getVencedor() {
        return vencedor;
    }

    public void setVencedor(Pokemon vencedor) {
        this.vencedor = vencedor;
    }

    public String getDescricaoPokemon1(){
        return "%d - %s".formatted(pokemon1.getCodigo(), pokemon1.getNome());
    }
    public String getDescricaoPokemon2(){
        return "%d - %s".formatted(pokemon2.getCodigo(), pokemon2.getNome());
    }
    public String getDescricaoVencedor(){
        return "%d - %s".formatted(vencedor.getCodigo(), vencedor.getNome());
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
}
