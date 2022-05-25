package org.example.org.example.rest.controller;

import org.example.model.Client;
import org.example.org.example.domain.entity.Cliente;
import org.example.org.example.domain.repository.Clientes;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/")

public class ClienteController {
    private Clientes clientes;

    public ClienteController(Clientes clientes) {

        this.clientes = clientes;
    }

    //        @RequestMapping(value = {"/hello/{nome}", "/api/hello"},
//                method = RequestMethod.GET)

    @GetMapping("/api/clientes/{id}") //equivalente ao request mapping
    @ResponseBody //vai indicar que o retorno é o corpo da resposta
//    O @PathVariable significa que vai ser recebido uma var via url e será injetado abaixo
    public ResponseEntity getClienteById(@PathVariable Integer id) {
        Optional<Cliente> cliente = clientes.findById(id);
        if (cliente.isPresent()) {
            return ResponseEntity.ok(cliente.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/api/clientes")
    @ResponseBody
    public ResponseEntity save(@RequestBody Cliente cliente) {
        Cliente clienteSalvo = clientes.save(cliente);
        return ResponseEntity.ok(clienteSalvo);
    }
    // Deletar
    @DeleteMapping("/api/clientes/{id}")
    @ResponseBody
    public ResponseEntity delete(@PathVariable Integer id) {
        Optional<Cliente> cliente = clientes.findById(id);
        if (cliente.isPresent()) {
            clientes.delete(cliente.get());
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
//    Atualizar Clientes
    @PutMapping("/api/clientes/{id}")
    @ResponseBody
    public ResponseEntity update(@PathVariable Integer id, @RequestBody Cliente cliente){
        return clientes.findById(id)
                .map(clienteExistente ->{
                    cliente.setId(clienteExistente.getId());
                    clientes.save(cliente);
                    return ResponseEntity.noContent().build();
                }).orElseGet(()-> ResponseEntity.notFound().build());
    }
//    Listagem de clientes

    @GetMapping("/api/clientes")
    @ResponseBody
    public ResponseEntity find (Cliente filtro){
//        String sql = "select * from cliente";
//
//        if(filtro.getNome()!=null){
//            sql +="where nome = :nome";
//        }
//        if(filtro.getCpf()!=null){
//            sql += "and cpf = :cpf";
//        }
        
    }
}


