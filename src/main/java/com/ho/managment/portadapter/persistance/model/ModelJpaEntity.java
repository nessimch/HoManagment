package com.ho.managment.portadapter.persistance.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ho.managment.portadapter.persistance.product.ProductJpaEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="model")
@Builder
public class ModelJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "model_name")
    private String name;
    
    @Column(name = "selling_price")
    private double sellingPrice;

    @Column(name = "purchase_price")
    private double purchasePrice;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="product_id", nullable = false)
    private ProductJpaEntity product;
    
}
