package sptech.dominio;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

@Entity // indica que a classe mapeia uma tabela, ou seja, é uma Entidade
public class Pokemon {

    @Id // indica que mapeia o campo que é a PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // autoincremento
    private int codigo;

    @NotBlank // do javax.validations
    @Size(min = 2, max = 12)
    private String nome;

    @PositiveOrZero
    private Double forca;

    private boolean livre;

    @JsonIgnore
    @Column(length = 10 * 1024 * 1024)
    private byte[] foto;
    @JsonIgnore
    @Column(length = 2 * 1024 * 1024)
    private byte[] relatorioCSV;

    /*
    Na hora de cadastrar/atualizar, basta enviar o valor
    do atributo de id (no caso é "codigo")
     */
    @ManyToOne // cria o relacionamento FK -> PK entre as entidade
    private TipoPokemon tipo;

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
        if (this.tipo.getForcaMaxima() < forca) {
            throw new IllegalArgumentException();
        }
        this.forca = forca;
    }

    public boolean isLivre() {
        return livre;
    }

    public void setLivre(boolean livre) {
        this.livre = livre;
    }


    public TipoPokemon getTipo() {
        return tipo;
    }

    public void setTipo(TipoPokemon tipo) {
        this.tipo = tipo;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public byte[] getRelatorioCSV() {
        return relatorioCSV;
    }

    public void setRelatorioCSV(byte[] relatorioCSV) {
        this.relatorioCSV = relatorioCSV;
    }
}
