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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="orders")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
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
}
