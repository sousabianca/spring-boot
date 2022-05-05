package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class VendasAplication {

//    @Autowired
//   @Qualifier("applicationName") //Injeta a string na var abaixo
    //vai procurar essa expressão no arquivo scaneado no resources pegando o valor e injetando da var
    @Value("${application.name}")
    private String applicationName;


    @GetMapping("/hello")
    public String helloWorld()
    {
        return applicationName;
    }
    public static void main(String[] args) {
        SpringApplication.run(VendasAplication.class,args);

    }

    //verificando as annotations customizadas
//    @Autowired
//    @Qualifier("gato")
    @Cachorro
    private Animal animal;

    @Bean
    public CommandLineRunner executarAniamal(){
        return args -> {
            this.animal.fazerBarulho();
        };
    }


}
