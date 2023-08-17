package sptech.projeto03;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

public class Musica {
    private Integer id;
    private String name;
    private String interprete;
    private LocalDate lancamento;
    private int ouvida;

    public Musica() {
        id = ThreadLocalRandom.current().nextInt(1,11);
    }

    public Musica(String name, String interprete, LocalDate lancamento) {
        this();
        this.name = name;
        this.interprete = interprete;
        this.lancamento = lancamento;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getInterprete() {
        return interprete;
    }

    public LocalDate getLancamento() {
        return lancamento;
    }

    public int getOuvida() {
        return ouvida;
    }

    public void ouvir(){
        this.ouvida += 1;
    }
}
