package org.example.org.example;

import org.example.org.example.domain.entity.Cliente;
import org.example.org.example.domain.repositorio.ClientesAntigo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class VendasApplicationAntigo {

    @Bean
    public CommandLineRunner init (@Autowired ClientesAntigo clientesAntigo){
        return args -> {
            System.out.println("Salvando clientes");
            clientesAntigo.salvar(new Cliente("Bianca Sousa"));

            clientesAntigo.salvar(new Cliente("Francisca Alves"));


            List<Cliente> todosClientes = clientesAntigo.obterTodos();
            todosClientes.forEach(System.out::println);

            System.out.println("Atualizando clientes");

            todosClientes.forEach(c->{
                c.setNome(c.getNome()+ " atualizado.");
                clientesAntigo.atualizar(c);
            });
            todosClientes = clientesAntigo.obterTodos();
            todosClientes.forEach(System.out::println);

            System.out.println("Buscando clientes");

            clientesAntigo.buscarPorNome("Al").forEach(System.out::println);

            System.out.println("Deletando clientes");
            clientesAntigo.obterTodos().forEach(c->{
                clientesAntigo.deletar(c);
            });

            todosClientes= clientesAntigo.obterTodos();
            if(todosClientes.isEmpty()){
                System.out.println("Nenhum cliente encontrado");
            }else{
                todosClientes.forEach(System.out::println);
            }


        };
    }
    public static void main(String[] args) {
        SpringApplication.run(VendasApplicationAntigo.class);
    }
}
