package org.example.org.example;

import org.example.org.example.domain.entity.Cliente;
import org.example.org.example.domain.repository.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class VendasApplication {
    @Bean
    public CommandLineRunner commandLineRunner (@Autowired Clientes clientes){
        return args -> {
            Cliente c = new Cliente(null, "Fulano");
            clientes.save(c);

        };
    }

    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class);
    }

//    @Bean
//    public CommandLineRunner init (@Autowired Clientes clientes,
//                                   @Autowired Pedidos pedidos){
//        return args -> {
//            System.out.println("Salvando  Clientes");
////            clientes.save(new Cliente("Bianca Sousa"));
////
////            clientes.save(new Cliente("Francisca Alves"));
//            Cliente fulano = new Cliente("Fulano");
//            clientes.save(fulano);
//            Pedido p = new Pedido();
//            p.setCliente(fulano);
//            p.setDataPedido(LocalDate.now()); //data atual
//            p.setTotal(BigDecimal.valueOf(100));
//            pedidos.save(p);
//
//            pedidos.findByCliente(fulano).forEach(System.out::println);

//            Cliente cliente = clientes.findClienteFetchPedidos(fulano.getId());
//            System.out.println(cliente);
//            System.out.println(cliente.getPedidos());

//            boolean existe = clientes.existsByNome("Bianca Sousa");
//            System.out.println("Existe um cliente com o nome Bianca? "+existe);

//            List<Cliente> result = clientes.encontrarPorNome("Bianca Sousa");
//            result.forEach(System.out::println);

//            System.out.println("Atualizando clientes");
//
//            todosClientes.forEach(c->{
//                c.setNome(c.getNome()+ " atualizado.");
//                clientes.save(c); //save tanto salva como atualiza
//            });
//            todosClientes = clientes.findAll();
//            todosClientes.forEach(System.out::println);
//
//            System.out.println("Buscando clientes");
//
//            clientes.findByNomeLike("Al").forEach(System.out::println);
//
//            System.out.println("Deletando clientes");
//            clientes.findAll().forEach(c->{
//                clientes.delete(c);
//            });
//
//            todosClientes= clientes.findAll();
//            if(todosClientes.isEmpty()){
//                System.out.println("Nenhum cliente encontrado");
//            }else{
//                todosClientes.forEach(System.out::println);
//            }
//
//
//        };
//    }

}
