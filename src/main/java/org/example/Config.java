package org.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

//@Configuration
//@Profile("development")

@Development //Annotation criada
public class Config {
    @Bean
    public CommandLineRunner executar(){
        return args ->{
            System.out.println("RODANDO A APLICAÇÃO");
        };

    }

//Cria o objeto String com esse valor no contexto da aplicação
//        @Bean(name= "applicationName")
//        public String applicationName(){
//            return "Sistema de vendas";
//        }

}
