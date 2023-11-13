package imydb.exfilmesimydb.controle;

import imydb.exfilmesimydb.modelo.Filme;
import imydb.exfilmesimydb.repositorio.FilmesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/filmes")
public class FilmesController {
    @Autowired
    FilmesRepository repository;

    @GetMapping("/")
    public List<Filme> getRepository() {
        return repository.findAll();
    }

    @PostMapping("/")
    public void post(@RequestBody Filme filme){
        repository.save(filme);
    }

    @PutMapping("/")
    public void putFilme(@RequestBody Filme filme){
        // Deletar a tupla antiga e adicionar a nova
    }

    @DeleteMapping("/{id}")
    public void deleteFilme(@PathVariable int id){
        repository.deleteById(id);
    }
}
