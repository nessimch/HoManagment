package com.ho.managment.Service;

import java.util.List;

import javax.management.monitor.Monitor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ho.managment.persistance.models.Model;
import com.ho.managment.persistance.repository.ModelRepository;

@Component
public class ModelService {
    @Autowired
    private ModelRepository modelRepository;

    public List<Model> findAll(){
        return modelRepository.findAll();
    }

    public Model save(Model model){
        return modelRepository.save(model);
    }
    
}
