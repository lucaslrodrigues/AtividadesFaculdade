package sptech.modelo;

import org.hibernate.validator.constraints.br.CPF;
import org.hibernate.validator.constraints.br.TituloEleitoral;

import javax.validation.constraints.*;
import java.time.LocalDate;

public class Cliente {
    @NotBlank // Não pode ser branco
    @Size(min = 3, max = 20) // Numero de caracteres deve estar entre 3 e 20
    private String nome;
    @DecimalMin("0.01")
    private double mediaCompras;
    @NotNull // do pacote javax.validation
    @PastOrPresent
    private LocalDate nascimento;
    @PositiveOrZero // Acima de -1
    private int pontuacao;

    @Email
    private String email;

    @CPF
    private String cpf;

    @TituloEleitoral
    private String tituloEleitor;

    @Pattern(regexp="(\\(?\\d{2}\\)?\\s)?(\\d{4,5}\\-\\d{4})", message = "Deve ser um telefone válido")
    private String telefone;

//    @Positive
//    @PositiveOrZero
//    @Negative
//    @Max(999)
//    @Min(0)

    public String getNome() {
        return nome;
    }


    public int getPontuacao() {
        return pontuacao;
    }

    public double getMediaCompras() {
        return mediaCompras;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public String getTelefone() {
        return telefone;
    }
}
