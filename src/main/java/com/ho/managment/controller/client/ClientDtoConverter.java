package com.ho.managment.controller.client;

import com.ho.managment.persistance.models.Client;
import org.springframework.stereotype.Component;

@Component
public class ClientDtoConverter {

  public ClientDto convert(Client client){
    return ClientDto
        .builder()
        .id(client.getId())
        .name(client.getName())
        .mail(client.getMail())
        .build();
  }

  public Client convert(ClientDto clientDto){
    return Client
        .builder()
        .id(clientDto.getId())
        .name(clientDto.getName())
        .mail(clientDto.getMail())
        .build();
  }
}
