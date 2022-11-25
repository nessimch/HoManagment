package com.ho.managment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
    public List<Client> findClients(){
        return clientService.findAll();
    } 
}
