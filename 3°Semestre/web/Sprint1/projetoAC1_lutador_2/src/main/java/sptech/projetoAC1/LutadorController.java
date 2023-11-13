package sptech.projetoAC1;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/lutador")
public class LutadorController {
    List<Lutador> lutadores = new ArrayList<>();

    @GetMapping("/")
    public ResponseEntity<List<Lutador>> get(){
        return !lutadores.isEmpty() ? ResponseEntity.status(200).body(lutadores) : ResponseEntity.status(204).build();
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Lutador> getLutador(@PathVariable Integer codigo){
        for (Lutador lutador: lutadores) {
            if (codigo.equals(lutador.getCodigo())){
                return ResponseEntity.status(200).body(lutador);
            }
        }
        return ResponseEntity.status(404).build();
    }

    @PatchMapping("/apanhar/{codigo}/{forcarGolpe}")
    public ResponseEntity<Lutador> lutar(@PathVariable Integer codigo, @PathVariable Integer forcarGolpe){
        for (Lutador lutador: lutadores) {
            if (codigo.equals(lutador.getCodigo())){
                lutador.levarGolpe(forcarGolpe);
                return ResponseEntity.status(200).body(lutador);
            }
        }
        return ResponseEntity.status(404).build();
    }

    @GetMapping("/vivos")
    public ResponseEntity<List<Lutador>> vivos(){
        List<Lutador> vivos = new ArrayList<>();
        for (Lutador lutador: lutadores){
            if (lutador.getVida() > 0){
                vivos.add(lutador);
            }
        }
        return !vivos.isEmpty() ? ResponseEntity.status(200).body(vivos) : ResponseEntity.status(204).build();
    }

    @GetMapping("/mortos")
    public ResponseEntity<List<Lutador>> mortos(){
        List<Lutador> mortos = new ArrayList<>();
        for (Lutador lutador: lutadores){
            if (lutador.getVida() == 0) {
                mortos.add(lutador);
            }
        }
        return !mortos.isEmpty() ? ResponseEntity.status(200).body(mortos) : ResponseEntity.status(204).build();
    }

    @PostMapping("/")
    public ResponseEntity<Lutador> adicionar(@RequestBody Lutador novoLutador){
        lutadores.add(novoLutador);
        return lutadores.contains(novoLutador) ? ResponseEntity.status(200).body(novoLutador) : ResponseEntity.status(400).build();
    }

    @PatchMapping("/concentracao/{codigo}")
    public ResponseEntity<Lutador> concentrar(@PathVariable Integer codigo){
        for (Lutador lutador: lutadores) {
            if (codigo.equals(lutador.getCodigo()) && lutador.getVida() > 0) {
                lutador.concentrar();
                return ResponseEntity.status(200).body(lutador);
            }
        }
        return ResponseEntity.status(404).build();
    }

}
