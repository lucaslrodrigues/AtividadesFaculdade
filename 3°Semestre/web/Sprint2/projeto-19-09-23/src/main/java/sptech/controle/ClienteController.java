package sptech.controle;

import org.springframework.web.bind.annotation.*;
import sptech.modelo.Cliente;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    List<Cliente> clientes = new ArrayList<>();

    @GetMapping("/")
    public List<Cliente> getClientes() {
        return clientes;
    }

    @PostMapping("/")
    public void post(@RequestBody @Valid Cliente novoCliente){
        clientes.add(novoCliente);
    }

}
