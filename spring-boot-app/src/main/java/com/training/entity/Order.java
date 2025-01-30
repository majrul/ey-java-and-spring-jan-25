package com.training.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_order")
@Getter
@Setter
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDateTime orderDate;
    private double amount;

    @ManyToOne
    @JoinColumn(name = "cust_id")
    //@JsonIgnore
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "prod_id")
    private Product product;


}
