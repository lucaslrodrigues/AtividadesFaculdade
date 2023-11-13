package sptech.dto;

// sptech.dto.PokemonSimplesDTO

public class PokemonSimplesDTO {

    private int codigo;

    private String nome;

    /*
    Construtor com os campos é obrigatório
     */
    public PokemonSimplesDTO(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }
}
