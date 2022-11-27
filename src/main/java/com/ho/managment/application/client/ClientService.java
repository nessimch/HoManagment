package com.ho.managment.application.client;

import java.util.List;
import java.util.stream.Collectors;

import com.ho.managment.domain.model.client.Client;
import com.ho.managment.portadapter.persistance.client.ClientJpaEntity;
import com.ho.managment.portadapter.persistance.client.ClientMapper;
import lombok.AllArgsConstructor;

import com.ho.managment.portadapter.persistance.client.ClientRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@AllArgsConstructor
@Service
public class ClientService {

    private ClientRepository clientRepository;
    private ClientMapper clientMapper;

    public List<Client> findAll(){
        return clientRepository.findAll()
            .stream().map(client -> clientMapper.toDomain(client))
            .collect(Collectors.toList());
    }

    public Client save(Client client){
        ClientJpaEntity clientJpaEntity = clientMapper.toJpaEntity(client);
        return clientMapper.toDomain(clientRepository.save(clientJpaEntity));
    }

    public Client getClientById(Integer id) {
        return clientMapper.toDomain(clientRepository.findById(id).orElseThrow(EntityNotFoundException::new));
    }

    public Client update(Client client){
        ClientJpaEntity clientToUpdate = clientRepository.findById(client.getId()).orElseThrow(EntityNotFoundException::new);
        clientToUpdate.setName(client.getName());
        clientToUpdate.setMail(client.getMail());
        clientToUpdate.setOrderJpaEntities(clientMapper.orders(client));
        return clientMapper.toDomain(clientRepository.save(clientToUpdate));

    }

   public void delete(Integer id) {
        if(!clientRepository.existsById(id)) {
            throw new EntityNotFoundException("Invalid Id was provided");
        }
        clientRepository.deleteById(id);
   }

}
