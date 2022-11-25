package com.ho.managment.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ho.managment.persistance.models.Model;

public interface ModelRepository extends JpaRepository<Model,Integer>{
    
}
