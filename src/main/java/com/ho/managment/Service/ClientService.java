package com.ho.managment.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ho.managment.persistance.models.Client;
import com.ho.managment.persistance.repository.ClientRepository;

@Component
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public List<Client> findAll(){
        return clientRepository.findAll();
    }
}
