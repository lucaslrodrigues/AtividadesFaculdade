package imydb.exfilmesimydb.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Range;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

@Entity
public class Filme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @NotBlank
    @Size(min=0, max=30)
    private String titulo;
    @NotNull
    @NotBlank
    private String diretor;
    @PastOrPresent
    private LocalDate dataLancamento;
    @Positive
    private double duracao;
    @DecimalMin("1.0")
    @DecimalMax("10.0")
    private Double nota;
    @Max(100)
    @Min(1)
    private int ranking;

    public Filme() {
    }

    public Filme(String titulo, String diretor, LocalDate dataLancamento, double duracao, double nota, int ranking) {
        this.titulo = titulo;
        this.diretor = diretor;
        this.dataLancamento = dataLancamento;
        this.duracao = duracao;
        this.nota = nota;
        this.ranking = ranking;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDiretor() {
        return diretor;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public double getDuracao() {
        return duracao;
    }

    public double getNota() {
        return nota;
    }

    public int getRanking() {
        return ranking;
    }
}
