package com.ho.managment.persistance.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="model")
public class Model {
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
    private Product product;

    
    public Model(String name, double sellingPrice, double purchasePrice, Product product) {
        this.name = name;
        this.sellingPrice = sellingPrice;
        this.purchasePrice = purchasePrice;
        this.product = product;
    }


    public Model() {
    }


    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public double getSellingPrice() {
        return sellingPrice;
    }


    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }


    public double getPurchasePrice() {
        return purchasePrice;
    }


    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }


    public Product getProduct() {
        return product;
    }


    public void setProduct(Product product) {
        this.product = product;
    }
    
}
