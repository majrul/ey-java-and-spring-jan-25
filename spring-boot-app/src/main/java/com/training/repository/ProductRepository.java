package com.training.repository;

import com.training.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

//extends CrudRepository {
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("select p from Product p where p.name ilike %?1%")
    public List<Product> findByName(String name);
}
