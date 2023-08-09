package sptech.projeto01;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Descorador para o metodo
public class FrasesController {
    @GetMapping("/cumprimentar")
    public String cumprimentar(){
        return "Sejam bem vindos a minha simpática API!";
    }
    @GetMapping("/boa-noite")
    public String cumprimento_noite(){
        return "Tenha uma boa noite!";
    }
}
