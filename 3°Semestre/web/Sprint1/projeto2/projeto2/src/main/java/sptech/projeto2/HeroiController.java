package sptech.projeto2;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HeroiController {

    private List<SuperHeroi> heroisInteressantes = new ArrayList<>();

    @GetMapping("/heroi-favorito")
    public SuperHeroi favorito(){
        SuperHeroi heroi = new SuperHeroi("AA", "super AA", 800.0, false);
        return heroi;
    }

    @GetMapping("/herois-fortes")
    public List<SuperHeroi> fortes(){
        var lista = List.of(
            new SuperHeroi("Tobias", "Miranha", 18000.0, true),
            new SuperHeroi("Andrew", "Miranha tbm", 18000.0, false),
            new SuperHeroi("Sophia", "Groth", 18000.0, true),
            new SuperHeroi("Relampaginho", "Flash", 18000.0, false)
        );
        return lista;
    }

    @GetMapping("/novo-interessante/{nomeVerdadeiro}/{nomeHeroi}/{forca}/{voa}")
    public String novoInteressante(@PathVariable String nomeVerdadeiro, @PathVariable String nomeHeroi, @PathVariable Double forca, @PathVariable Boolean voa){
        SuperHeroi heroi = new SuperHeroi(nomeVerdadeiro, nomeHeroi, forca, voa);
        heroisInteressantes.add(heroi);
        return "Cadastro efetuado com sucesso";
    }

    @GetMapping("/herois-interessantes")
    public List<SuperHeroi> heroisInteressantes(){
        return heroisInteressantes;
    }
}
