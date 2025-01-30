package com.training.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.training.entity.Order;

//extends CrudRepository {
public interface OrderRepository extends JpaRepository<Order, Integer> {

    @Query("select o from Order o join o.customer c where c.email = ?1")
    public List<Order> findByEmail(String email);

    @Query("select o from Order o where o.customer.id = ?1")
    public List<Order> findByCustomerId(int id);
}
