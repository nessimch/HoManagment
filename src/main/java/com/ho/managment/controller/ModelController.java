package com.ho.managment.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ho.managment.Service.ModelService;
import com.ho.managment.persistance.models.Model;

@RestController
@RequestMapping("model")
public class ModelController {
    @Autowired
    private ModelService modelService;


    @GetMapping("")
    public List<Model> findModels(){
        return modelService.findAll();
    } 

    @PostMapping("")
    public void addModel(@ModelAttribute Model model, HttpServletResponse response){
            modelService.save(model);
    }
    
}
