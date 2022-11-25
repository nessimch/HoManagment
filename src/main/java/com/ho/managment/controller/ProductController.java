package com.ho.managment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ho.managment.Service.ProductService;
import com.ho.managment.persistance.models.Product;

@RestController
@RequestMapping
public class ProductController {
    @Autowired
    private ProductService productService;

    @CrossOrigin(origins = "*")
    @GetMapping("/products")
    public List<Product> findProducts(){
        return productService.findAll();
    } 
}
