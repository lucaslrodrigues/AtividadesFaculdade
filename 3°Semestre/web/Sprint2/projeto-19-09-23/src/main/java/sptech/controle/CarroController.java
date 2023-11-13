package sptech.controle;

import org.springframework.web.bind.annotation.*;
import sptech.modelo.Carro;
import sptech.modelo.Fabricante;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/carros")
public class CarroController {
    List<Carro> carros = new ArrayList();

    public CarroController(){
        Fabricante f1 = new Fabricante("Audi", "Alemanha");
        Carro c1 = new Carro("A7", 2021, f1);

        carros.add(c1);
    }

    @GetMapping("/")
    public List<Carro> getCarros(){
        return carros;
    }

    @PostMapping("/")
    public void adicionarCarro(@RequestBody Carro novoCarro){
        carros.add(novoCarro);
    }

}
