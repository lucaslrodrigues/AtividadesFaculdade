package sptech.projetoAC1;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

public class Lutador {
    private int codigo;
    private String nome;
    private LocalDate nascimento;
    private int vida;

    public Lutador() {
        codigo = ThreadLocalRandom.current().nextInt(1, 1001);
    }

    public Lutador(String nome, LocalDate nascimento, int vida) {
        this();
        this.nome = nome;
        this.nascimento = nascimento;
        this.vida = vida;
    }

    public void levarGolpe(Integer forcarGolpe){
        if (vida >= forcarGolpe) {
            vida -= forcarGolpe;
        }
    }

    public void concentrar(){
        vida += 5;
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

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }
}
