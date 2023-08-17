package sptech.projeto03;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
/*
As Rest Controller são SINGLETONs
Ou seja haverá apenas 1 e somente 1 instância de cada Rest controller
na aplicação
 */
@RestController
public class ContadorController {
    private int contador = 0;

    @GetMapping("/contar")
    public String contar() {
        contador++;
        return "Você já me chamou %d vezes".formatted(contador);
    }
}
