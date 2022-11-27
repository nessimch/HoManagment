package com.ho.managment.portadapter.persistance.client;

import com.ho.managment.portadapter.persistance.client.ClientJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<ClientJpaEntity, Integer> {
    
}
