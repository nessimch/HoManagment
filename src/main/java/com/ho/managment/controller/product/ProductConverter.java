package com.ho.managment.controller.product;

import com.ho.managment.persistance.models.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {

  public ProductDto convert(Product product){
    return ProductDto
        .builder()
        .productId(product.getId())
        .productName(product.getName())
        .quantity(product.getQuantity())
        .build();
  }

  public Product convert(ProductDto productDto){
    return Product
        .builder()
        .id(productDto.getProductId())
        .name(productDto.getProductName())
        .quantity(productDto.getQuantity())
        .build();
  }
}
