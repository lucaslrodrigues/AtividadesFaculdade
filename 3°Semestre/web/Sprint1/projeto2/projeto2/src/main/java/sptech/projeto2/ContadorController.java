package sptech.projeto2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContadorController {
    private int contador = 0;

    @GetMapping("/contar")
    public String contar(){
        contador ++;
        return "Você já me chamou %d vezes".formatted(contador);
    }
}
