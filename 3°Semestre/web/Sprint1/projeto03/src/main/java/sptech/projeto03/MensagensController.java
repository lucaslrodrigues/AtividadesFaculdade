package sptech.projeto03;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MensagensController {

    /*
Aqui nossa URI possui uma PATH PARAM
Que é uma parte da URI que influencia no resultado da chamada.
O path param "pessoa" receberá o valor do argumento "pessoa"
Porque o argumento "pessoa" está anotado com @PathVariable
     */
    @GetMapping("/boas-vindas/{pessoa}")
    public String darBoasVindas(@PathVariable String pessoa) {
        return "Bem vindo(a) a minha simpática API, %s".formatted(pessoa);
    }

    /*
Caso existam mais de 1 path param,
todos os argumentos devem estar anotados com @PathVariable
     */
    @GetMapping("/comidas-favoritas/{salgada}/{doce}")
    public String comidas(@PathVariable String salgada,
                            @PathVariable String doce) {
        return "Sua comida salgada favorita é %s e a doce é %s"
                .formatted(salgada, doce);
    }

    /*
Aqui nós usamos a técnica de Query String, que comporta
os Query Params
Cada Query Param deve estar anotado com @RequestParam

No código abaixo podemos invocar a chamada fazendo:
1. localhost:8080/votar?nome=Joao&idade=25
2. localhost:8080/votar?idade=25&nome=Joao
A ordem dos parâmetros na URL NÃO importa!

Sempre, antes do 1º parâmetro usamos "?"
E antes de cada um a partir do 2º usamos "&"
     */
    @GetMapping("/votar")
    public boolean votar(@RequestParam String nome,
                         @RequestParam int idade) {
        System.out.println("Verificando votação p/ %s".formatted(nome));
        return idade >= 16;
    }
}
