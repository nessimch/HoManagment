package com.ho.managment.portadapter.persistance.product;

import com.ho.managment.portadapter.persistance.product.ProductJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductJpaEntity, Integer>{
    
}
