package sptech.projeto4;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/pizzas")
public class PizzaController {
    List<Pizza> pizzas = new ArrayList<>();
    // Set<Pizza> pizzas2 = new LinkedHashSet<>(); // Cria um conjunto

    @GetMapping("/") // localhost:8080/pizzas/
    public List<Pizza> getPizzas() {
        return pizzas;
    }

    @GetMapping("/{codigo}")
    public Pizza get(@PathVariable Integer codigo){
        return pizzas.stream().filter(pizza -> pizza.getCodigo().equals(codigo)).findFirst().orElse(null);
    }

    @PostMapping("/{sabor}/{valor}/{quantidade}")
    public Pizza post(@PathVariable String sabor, @PathVariable Double valor, @PathVariable int quantidade){
        var novaPizza = new Pizza(sabor, valor, quantidade);
        pizzas.add(novaPizza);
        return novaPizza;
    }

    @DeleteMapping("/{codigo}")
    public String delete(@PathVariable Integer codigo){
        boolean excluiu = pizzas.removeIf(pizza -> pizza.getCodigo().equals(codigo));
        String retorno =  excluiu ? "Pizza %d excluida".formatted(codigo) : "Código %d não encontrado!".formatted(codigo);

        return retorno.formatted(codigo);
    }

    @PutMapping("/{codigo}/{sabor}/{valor}/{quantidade}")
    public Pizza put(@PathVariable Integer codigo,
                     @PathVariable Double valor,
                     @PathVariable String sabor,
                     @PathVariable int quantidade){
        var pizzaEncontrada = get(codigo);
        if (pizzaEncontrada == null){
            return null;
        }

        delete(codigo);

        pizzaEncontrada.setSabor(sabor);
        pizzaEncontrada.setQuantidade(quantidade);
        pizzaEncontrada.setValor(valor);

        pizzas.add(pizzaEncontrada);

        return pizzaEncontrada;
    }

    @PatchMapping("/venda/{codigo}/{quantidade}")
    public Pizza vender(@PathVariable Integer codigo,
                        @PathVariable int quantidade){
        var pizzaEncontrada = get(codigo);

        if (pizzaEncontrada == null) {
            return null;
        }

        pizzaEncontrada.registrarVenda(quantidade);
        // registrando a venda

        return pizzaEncontrada;
    }
}
