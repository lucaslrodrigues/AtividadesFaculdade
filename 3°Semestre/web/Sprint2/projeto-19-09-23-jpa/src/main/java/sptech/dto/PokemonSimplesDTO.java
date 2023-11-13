package sptech.dto;

public class PokemonSimplesDTO {

    private int id;

    private String nome;

    /*
    Construtor com os campos é obrigatório
    */

    public PokemonSimplesDTO(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
