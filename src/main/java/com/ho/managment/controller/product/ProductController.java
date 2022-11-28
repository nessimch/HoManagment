package com.ho.managment.controller.product;

import com.ho.managment.Service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("products")

@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @CrossOrigin(origins = "*")
    @GetMapping()
    public List<ProductDto> findProducts(){
        return productService.findAll();
    }

    @PostMapping("")
    public ProductDto save(@RequestBody ProductDto productDto){
        return productService.save(productDto);
    }

    @PutMapping("")
    public ResponseEntity update(@RequestBody ProductDto productDto){
        productService.update(productDto);
        return ResponseEntity
            .ok("Order with id: " + productDto.getProductId() + " was updated successfully");
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity delete(@PathVariable Integer productId){
        productService.delete(productId);
        return ResponseEntity
            .ok("Product with id: " + productId + " was deleted successfully");
    }
}
