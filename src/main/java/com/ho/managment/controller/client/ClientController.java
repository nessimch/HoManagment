package com.ho.managment.controller.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ho.managment.Service.ClientService;
import com.ho.managment.persistance.models.Client;

@RestController
@RequestMapping("client")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping("")
    public List<ClientDto> findClients(){
        return clientService.findAll();
    }

    @PostMapping("")
    public ClientDto save(@RequestBody ClientDto client){
        return clientService.save(client);
    }

    @GetMapping("/{id}")
    public ClientDto getClient(@PathVariable Integer id){
        return clientService.getClientById(id);
    }

    @PutMapping("")
    public ClientDto updateClient(@RequestBody Client client){
        return clientService.update(client);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteClient(@PathVariable Integer id) {
        clientService.delete(id);
        return ResponseEntity
            .ok("Client with id: " + id + " was deleted successfully");
    }

}
