package sptech.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // indica que a classe mapeia uma tabela, ou seja, é uma Entidade
public class Pokemon {

    @Id // indica que mapeia o campo que é a PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // autoincremento
    private int codigo;
    private String nome;
    private String tipo;
    private Double forca;
    private boolean livre;

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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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
