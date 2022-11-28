package com.ho.managment.Service;

import com.ho.managment.controller.product.ProductConverter;
import com.ho.managment.controller.product.ProductDto;
import com.ho.managment.persistance.models.Product;
import com.ho.managment.persistance.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductConverter productConverter;

    public List<ProductDto> findAll(){
        return productRepository
            .findAll()
            .stream()
            .map(productConverter::convert).collect(Collectors.toList());
    }

    public ProductDto save(ProductDto productDto){
        return productConverter
            .convert(productRepository
                .save(productConverter
                    .convert(productDto)));
    }

    public ProductDto update(ProductDto productDto){
        if(productRepository.existsById(productDto.getProductId()) ) {
            Product product = productConverter.convert(productDto);
            return productConverter.convert(productRepository.save(product));
        }
        else throw new RuntimeException("cannot update inexistent product");
    }

    public void delete(Integer productId){
        if(!productRepository.existsById(productId)) {
            throw new EntityNotFoundException("Invalid Id was provided");
        }
        productRepository.deleteById(productId);
    }
}

