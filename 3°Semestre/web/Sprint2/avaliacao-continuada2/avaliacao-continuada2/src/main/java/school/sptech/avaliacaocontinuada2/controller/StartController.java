package school.sptech.avaliacaocontinuada2.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/start")
public class StartController {

    /*
        Não é necessário alterar nada nessa classe
        Foque seus esforços no repository e controller de Producao
    */

    @GetMapping
    public ResponseEntity<String> start() {
        return ResponseEntity.ok("Projeto está rodando! Leia atentamente o enunciado e mãos à obra!");
    }
}
