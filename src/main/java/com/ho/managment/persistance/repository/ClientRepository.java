package com.ho.managment.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ho.managment.persistance.models.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {
    
}
