package sptech.dominio;

import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class TipoPokemon {
    @Id // indica que mapeia o campo que é PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Autoincrementa a PK
    private int codigo;
    @NotBlank
    @Column(unique = true)
    @Size(min = 2, max = 12)
    private String nome;

    public TipoPokemon() {
    }

    public TipoPokemon(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

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
}
