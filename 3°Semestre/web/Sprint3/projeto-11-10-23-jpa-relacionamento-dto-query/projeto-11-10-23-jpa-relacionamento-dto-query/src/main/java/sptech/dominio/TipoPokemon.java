package sptech.dominio;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class TipoPokemon {

    @Id // indica que mapeia o campo que é a PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // autoincremento
    private int codigo;

    @NotBlank // do javax.validations
    @Size(min = 2, max = 12)
    private String nome;
    private Double forcaMaxima;

    /*
    * Esta anotação só existe no Java. Não existe em banco de dados relacional
    *
    * mappedBy = "tipo" -> por que na entidade Polemon o TipoPokemon está mapeado com um atributo chamado "tipo"
    * */
    @OneToMany(mappedBy = "tipo")
    private List<Pokemon> pokemons;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getForcaMaxima() {
        return forcaMaxima;
    }

    public void setForcaMaxima(Double forcaMaxima) {
        this.forcaMaxima = forcaMaxima;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }
}
