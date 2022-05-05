package org.example;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AniamalConfig {
    @Bean(name= "cachorro")
    public Animal cachorro (){
        return new Animal() {
            @Override
            public void fazerBarulho() {
                System.out.println("AUAU");
            }
        };
    }
    @Bean(name= "gato")
    public Animal gato (){
        return new Animal() {
            @Override
            public void fazerBarulho() {
                System.out.println("MIAU");
            }
        };
    }
}
