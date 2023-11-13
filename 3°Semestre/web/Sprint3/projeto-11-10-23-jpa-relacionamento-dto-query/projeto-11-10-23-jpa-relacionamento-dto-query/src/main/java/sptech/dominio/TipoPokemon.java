package sptech.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class TipoPokemon {

    @Id // indica que mapeia o campo que é a PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // autoincremento
    private int codigo;

    @NotBlank // do javax.validations
    @Size(min = 2, max = 12)
    private String nome;
    private Double forcaMaxima;

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
}
