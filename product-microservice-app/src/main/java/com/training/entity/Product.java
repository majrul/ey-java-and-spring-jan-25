package com.training.entity;

import java.io.Serializable;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tbl_product")
@Getter
@Setter
@NoArgsConstructor
//@ToString
//@Data
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private double price;
    private int quantity;
    
    @Transient
    private String serviceAddress;
}
