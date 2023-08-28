package sptech.projetoAC1;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/lutador")
public class LutadorController {
    List<Lutador> lutadores = new ArrayList<>();

    @GetMapping("/")
    public List<Lutador> get(){
        return lutadores;
    }

    @GetMapping("/{codigo}")
    public Lutador getLutador(@PathVariable Integer codigo){
        for (Lutador lutador: lutadores) {
            if (codigo.equals(lutador.getCodigo())){
                return lutador;
            }
        }
        return null;
    }

    @PatchMapping("/apanhar/{codigo}/{forcarGolpe}")
    public Lutador lutar(@PathVariable Integer codigo, @PathVariable Integer forcarGolpe){
        for (Lutador lutador: lutadores) {
            if (codigo.equals(lutador.getCodigo())){
                lutador.levarGolpe(forcarGolpe);
                return lutador;
            }
        }
        return null;
    }

    @GetMapping("/vivos")
    public List<Lutador> vivos(){
        List<Lutador> vivos = new ArrayList<>();
        for (Lutador lutador: lutadores){
            if (lutador.getVida() > 0){
                vivos.add(lutador);
            }
        }
        return vivos;
    }

    @GetMapping("/mortos")
    public List<Lutador> mortos(){
        List<Lutador> mortos = new ArrayList<>();
        for (Lutador lutador: lutadores){
            if (lutador.getVida() == 0) {
                mortos.add(lutador);
            }
        }
        return mortos;
    }

    @PostMapping("/{nome}/{nascimento}/{vida}")
    public Lutador adicionar(@PathVariable String nome, @PathVariable LocalDate nascimento, @PathVariable int vida){
        Lutador lutador = new Lutador(nome, nascimento, vida);
        lutadores.add(lutador);
        return lutador;
    }

    @PatchMapping("/concentracao/{codigo}")
    public Lutador concentrar(@PathVariable Integer codigo){
        for (Lutador lutador: lutadores) {
            if (codigo.equals(lutador.getCodigo()) && lutador.getVida() > 0) {
                lutador.concentrar();
                return lutador;
            }
        }
        return null;
    }

}
