package sptech.projeto03;

import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/musicas") // Cria um router em que todas as URI começaram com /musicas
public class MusicaController {
    List<Musica> musicas = new ArrayList<>();

    @GetMapping("/")
    public List<Musica> getMusicas() {
        return musicas;
    }

    @PostMapping("/{nome}/{interprete}/{lancamento}")
    public String cadastrar(@PathVariable String nome,
                            @PathVariable String interprete,
                            @PathVariable LocalDate lancamento){
        Musica nova = new Musica(nome, interprete, lancamento);

        musicas.add(nova);
        return "Música criada com id %d".formatted(nova.getId());
    }

    @PutMapping("/{id}/ouvida")
    public String ouvirMusica(@PathVariable int id){
        for (Musica musica: musicas){
            if (musica.getId().equals(id)) {
                musica.ouvir();
                return "Música %d atualizada".formatted(id);
            }
        }
        return "Música %d não encontrada".formatted(id);
    }
}
