package school.sptech.avaliacaocontinuada2.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

/*
    Não é necessário alterar nada nessa classe
    Foque seus esforços no repository e controller
*/

@Entity
public class Producao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String titulo;

    private String diretor;

    private String genero;

    private String tipo;

    private Double notaImdb;

    private int quantidadeAvaliacoes;

    private LocalDate dataLancamento;

    public Producao() {
    }

    public Producao(Integer id, String titulo, String diretor, String genero, String tipo, Double notaImdb, int quantidadeAvaliacoes, LocalDate dataLancamento) {
        this.id = id;
        this.titulo = titulo;
        this.diretor = diretor;
        this.genero = genero;
        this.tipo = tipo;
        this.notaImdb = notaImdb;
        this.quantidadeAvaliacoes = quantidadeAvaliacoes;
        this.dataLancamento = dataLancamento;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getNotaImdb() {
        return notaImdb;
    }

    public void setNotaImdb(Double notaImdb) {
        this.notaImdb = notaImdb;
    }

    public int getQuantidadeAvaliacoes() {
        return quantidadeAvaliacoes;
    }

    public void setQuantidadeAvaliacoes(int quantidadeAvaliacoes) {
        this.quantidadeAvaliacoes = quantidadeAvaliacoes;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }
}
