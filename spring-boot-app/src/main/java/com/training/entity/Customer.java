package com.training.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tbl_cust")
@Getter
@Setter
public class Customer {

	@Id //pk
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="cust_id")
	private int id;
	
	private String name;
	private String email;
	private LocalDate dateOfBirth;
	
}
