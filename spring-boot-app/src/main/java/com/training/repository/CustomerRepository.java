package com.training.repository;

import com.training.entity.Customer;
import com.training.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

//extends CrudRepository {
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    //public boolean existsByEmail(String email);
    public Optional<Customer> findByEmail(String email);

}
