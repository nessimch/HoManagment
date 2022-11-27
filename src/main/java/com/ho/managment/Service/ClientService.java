package com.ho.managment.Service;

import java.util.List;
import java.util.stream.Collectors;

import com.ho.managment.controller.client.ClientDto;
import com.ho.managment.controller.client.ClientDtoConverter;
import com.ho.managment.persistance.models.Client;
import lombok.RequiredArgsConstructor;

import com.ho.managment.persistance.repository.ClientRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
@Transactional
public class ClientService {

    private final ClientRepository clientRepository;
    private final ClientDtoConverter converter;

    public List<ClientDto> findAll(){
        return clientRepository
            .findAll()
            .stream()
            .map(converter::convert)
            .collect(Collectors.toList());
    }

    public ClientDto save(ClientDto client) {
        return converter
            .convert(clientRepository
            .save(converter.convert(client)));
    }

    public ClientDto getClientById(Integer id) {
        return converter.convert(clientRepository
            .findById(id)
            .orElseThrow(EntityNotFoundException::new));
    }

    public ClientDto update(Client client){
        Client clientToUpdate = clientRepository.findById(client.getId()).orElseThrow(EntityNotFoundException::new);
        clientToUpdate.setName(client.getName());
        clientToUpdate.setMail(client.getMail());
        return converter.convert(clientRepository.save(clientToUpdate));
    }

    public void delete(Integer id) {
        if(!clientRepository.existsById(id)) {
            throw new EntityNotFoundException("Invalid Id was provided");
        }
        clientRepository.deleteById(id);
    }
}
