package sptech.dto;

import sptech.dominio.Pokemon;
import sptech.dominio.TipoPokemon;

public class PokemonRelatorioDTO {
    private String nome;
    private Boolean livre;
    private Double forca;
    private TipoPokemon tipo;

    public PokemonRelatorioDTO(Pokemon pokemon) {
        nome = pokemon.getNome();
        livre = pokemon.isLivre();
        forca = pokemon.getForca();
        tipo = pokemon.getTipo();
    }

    public PokemonRelatorioDTO(String nome, Boolean livre, Double forca, TipoPokemon tipo) {
        this.nome = nome;
        this.livre = livre;
        this.forca = forca;
        this.tipo = tipo;
    }

    public String getClassificacao(){
        if (forca < 500) {
            return "Fraco";
        } else if (forca < 4000) {
            return "Intermediário";
        } else {
            return "Forte";
        }
    }

    public String getNomeTipo(){
        return tipo.getNome();
    }

    public String getNome() {
        return nome;
    }

    public Boolean getLivre() {
        return livre;
    }
}
