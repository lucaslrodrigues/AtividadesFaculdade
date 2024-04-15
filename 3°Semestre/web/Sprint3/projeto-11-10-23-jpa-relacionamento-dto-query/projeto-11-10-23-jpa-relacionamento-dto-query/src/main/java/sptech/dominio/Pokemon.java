package sptech.dominio;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import java.util.List;

@Entity // indica que a classe mapeia uma tabela, ou seja, é uma Entidade
public class Pokemon {

    @Id // indica que mapeia o campo que é a PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // autoincremento
    private int codigo;

    @NotBlank // do javax.validations
    @Size(min = 2, max = 12)
    private String nome;

    @PositiveOrZero
    private double forca;

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
    @JsonIgnore
    private TipoPokemon tipo;

    @OneToMany(mappedBy =  "pokemon1")
    private List<Luta> lutasComoPokemon1;
    @OneToMany(mappedBy =  "pokemon2")
    private List<Luta> lutasComoPokemon2;
    @OneToMany(mappedBy =  "vencedor")
    private List<Luta> lutasComoVencedor;

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


    public double getForca() {
        return forca;
    }

    public void setForca(double forca) {
        if (tipo != null) {
            if (this.tipo.getForcaMaxima() < forca) {
                throw new IllegalArgumentException();
            }
            this.forca = forca;
        }
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

    public List<Luta> getLutasComoPokemon1() {
        return lutasComoPokemon1;
    }

    public void setLutasComoPokemon1(List<Luta> lutasComoPokemon1) {
        this.lutasComoPokemon1 = lutasComoPokemon1;
    }

    public List<Luta> getLutasComoPokemon2() {
        return lutasComoPokemon2;
    }

    public void setLutasComoPokemon2(List<Luta> lutasComoPokemon2) {
        this.lutasComoPokemon2 = lutasComoPokemon2;
    }

    public List<Luta> getLutasComoVencedor() {
        return lutasComoVencedor;
    }

    public void setLutasComoVencedor(List<Luta> lutasComoVencedor) {
        this.lutasComoVencedor = lutasComoVencedor;
    }
}
