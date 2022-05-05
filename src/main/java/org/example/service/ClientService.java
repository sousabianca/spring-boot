package org.example.service;

import org.example.model.Client;
import org.example.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    //injetando o repository

    //instanciamento da classe
    public ClientRepository repository;
    @Autowired //nem é necessário porque já faz a injeção diretamente
    public ClientService (ClientRepository repository){
        this.repository = repository;
    }
    public void salvarCliente(Client cliente){
        validarCliente(cliente);
        this.repository.persistir(cliente);
//        o cliente repository é uma dependência do cliente service
//        como o cliente repository acessa a base de dados e pra não ter que fazer uma instanciação toda vez pode quebrar
//        ClientRepository clientRepository = new ClientRepository();
//        clientRepository.persistir(cliente);


    }

    public void validarCliente(Client cliente){

    }

}
