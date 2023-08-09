package sptech.projeto2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BodyRequestController {
    private List<Pessoa> pessoas;

    @GetMapping("/pessoas")
    public List<Pessoa> getPessoa(){
        return pessoas;
    }

    @PostMapping("/pessoa-adicionar")
    public void postPessoa(@RequestBody String login, @RequestBody String senha){
        Pessoa pessoa = new Pessoa(login, senha);
        System.out.println("Teste");
        System.out.println(pessoa);
        pessoas.add(pessoa);
    }
}
