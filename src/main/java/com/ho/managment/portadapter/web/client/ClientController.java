package com.ho.managment.portadapter.web.client;

import java.util.List;

import com.ho.managment.domain.model.client.Client;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ho.managment.application.client.ClientService;

@RestController
@RequestMapping("client")
@AllArgsConstructor
public class ClientController {

    private ClientService clientService;

    @GetMapping("")
    public ResponseEntity<List<Client>> findClients(){
        return ResponseEntity.ok().body(clientService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> getClient(@PathVariable java.lang.Integer id){
        return ResponseEntity.ok(clientService.getClientById(id));
    }

    @PostMapping("")
    public ResponseEntity<Client> saveClient(@RequestBody Client client){
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(clientService.save(client));
    }

    @PutMapping("")
    public ResponseEntity<Client> updateClient(@RequestBody Client client){
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(clientService.update(client));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteClient(@PathVariable Integer id) {
        clientService.delete(id);
        return ResponseEntity
            .ok("Client with id" + id + " is deleted successfully");
    }


}
