package com.ho.managment.portadapter.persistance.model;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ho.managment.portadapter.persistance.model.ModelJpaEntity;

public interface ModelRepository extends JpaRepository<ModelJpaEntity,Integer>{
    
}
