package sptech.projeto03;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class HeroiController {

    private List<SuperHeroi> heroisInteressantes = new ArrayList<>();

/*
O formato JSON virou PADRÃO em Rest APIs
Por isso o Spring Boot transforma a resposta em JSON
caso não seja um valor simples (String, double, int, Boolean etc)

OBS: As propriedades do JSON são geradas a partir dos GETTERs
     e não a partir doa atributos de instância!
 */
    @GetMapping("/heroi-favorito")
    public SuperHeroi favorito() {
        SuperHeroi heroi = new SuperHeroi("AA", "super A", 800.0, false);
        return heroi;
    }

    @GetMapping("/herois-fortes")
    public List<SuperHeroi> fortes() {
        return heroisInteressantes.stream().filter(heroi -> heroi.getCategoria().equals("Forte")).collect(Collectors.toList());
//        var lista = List.of(
//            new SuperHeroi("AA", "super A", 1800.0, false),
//            new SuperHeroi("BB", "super B", 8000.0, true),
//            new SuperHeroi("CC", "super C", 3100.0, false),
//            new SuperHeroi("DD", "super D", 5000.0, true)
//        );
//        return lista;

//        List heroisFortes = new ArrayList();
//        for (SuperHeroi heroi: heroisInteressantes){
//            if (heroi.getCategoria().equals("Forte")){
//                heroisFortes.add(heroi);
//            }
//        }
//        return heroisFortes;
    }

    @GetMapping("/novo-interessante/{nomeVerdadeiro}/{nomeHeroi}/{forca}/{voa}")
    public String novoInteressante(@PathVariable String nomeVerdadeiro,
                                   @PathVariable String nomeHeroi,
                                   @PathVariable double forca,
                                   @PathVariable boolean voa) {
        var novo = new SuperHeroi(nomeVerdadeiro, nomeHeroi, forca, voa);
        heroisInteressantes.add(novo);

        return "Cadastro efetuado com sucesso!";
    }

    @GetMapping("/herois-interessantes")
    public List<SuperHeroi> getHeroisInteressantes() {
        return heroisInteressantes;
    }
}
