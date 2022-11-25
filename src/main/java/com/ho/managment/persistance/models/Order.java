package com.ho.managment.persistance.models;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="client_id", nullable = false)
    private Client client;

    @JsonIgnore
    @ManyToMany(targetEntity = Product.class,fetch = FetchType.EAGER)
    @JoinTable(name="products_orders",joinColumns = @JoinColumn(name="id_order"),inverseJoinColumns = @JoinColumn(name="product"))
    private Set<Product> products = new HashSet<>();

    @Column(name = "transportor")
    private String transportor;

    @Transient
    @Column(name = "purchase_date")
    private LocalDateTime date;
    
    @Column(name = "advance")
    private double advance;

    @Column(name = "price")
    private double price;

    @Column(name = "foire")
    private String foire;

   

    public Order(Client client, Set<Product> products, String transportor, LocalDateTime date, double advance,
            double price, String foire) {
        this.client = client;
        this.products = products;
        this.transportor = transportor;
        this.date = date;
        this.advance = advance;
        this.price = price;
        this.foire = foire;
    }

    public Order() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getTransportor() {
        return transportor;
    }

    public void setTransportor(String transportor) {
        this.transportor = transportor;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public double getAdvance() {
        return advance;
    }

    public void setAdvance(double advance) {
        this.advance = advance;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getFoire() {
        return foire;
    }

    public void setFoire(String foire) {
        this.foire = foire;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
