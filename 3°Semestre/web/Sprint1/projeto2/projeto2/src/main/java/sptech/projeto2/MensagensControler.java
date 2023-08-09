package sptech.projeto2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/*
As Rest Controller são SINGLETONs
Elas são únicas, executadas apenas uma vez.
Haverá apenas uma e somente uma instância de cada Rest controller
*/
@RestController
public class MensagensControler {

    @GetMapping("/boas-vindas/{pessoa}")
    public String darBoasVindas(@PathVariable String pessoa){
        return "Bem vindo(a) a minha simpática API, %s".formatted(pessoa);
    }

    @GetMapping("/comidas-favoritas/{salgada}/{doce}")
    public String comidas(@PathVariable String salgada, @PathVariable String doce){
        return "Sua comida salgada favorita é %s e a doce é %s".formatted(salgada, doce);
    }

    /*
    Aqui nós utilizamos a técnica de Query String, que comporta os Query Params
    * localhost:8080/votar?nome=Lucas&idade=25
    * */
    @GetMapping("/votar")
    public boolean votar(@RequestParam String nome, @RequestParam int idade){

        System.out.println("Verificando votação para %s".formatted(nome));
        return idade >= 16;
    }

    @GetMapping("/potencia/{n1}/{n2}")
    public Double potencia(@PathVariable Integer n1, @PathVariable Integer n2){
        return Math.pow(n1, n2);
    }

    @GetMapping("/calcular")
    public String calcular(@RequestParam String operacao, @RequestParam Integer n1, @RequestParam Integer n2){
        if (Objects.equals(operacao, "subtracao")){
            return "O resultado de %d - %d é igual a %d".formatted(n1, n2, n1 - n2);
        }
        else if (Objects.equals(operacao, "soma")){
            return "O resultado de %d + %d é igual a %d".formatted(n1, n2, n1 + n2);
        }else{
            return "Operação invalida";
        }
    }



}
