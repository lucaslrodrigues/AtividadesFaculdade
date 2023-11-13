package sptech.dominio;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

@Entity
public class Pokemon {
//    @JsonIgnore
    @Id // indica que mapeia o campo que é PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Autoincrementa a PK
    private int codigo;
    @NotBlank
    @Size(min = 2, max = 12)
    private String nome;
    @PositiveOrZero
    private Double forca;
    private boolean livre;
    @ManyToOne // Criar uma chave estrangeira relacionada a uma chave primaria
    private TipoPokemon tipo;
    public TipoPokemon getTipo() {
        return tipo;
    }

    public void setTipo(TipoPokemon tipo) {
        this.tipo = tipo;
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


    public Double getForca() {
        return forca;
    }

    public void setForca(Double forca) {
        this.forca = forca;
    }

    public boolean isLivre() {
        return livre;
    }

    public void setLivre(boolean livre) {
        this.livre = livre;
    }
}
