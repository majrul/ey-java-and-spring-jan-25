package com.training.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.training.dto.OrderDetails;
import com.training.entity.Customer;
import com.training.entity.Order;
import com.training.entity.Product;
import com.training.exception.OrderException;
import com.training.repository.CustomerRepository;
import com.training.repository.OrderRepository;
import com.training.repository.ProductRepository;

@Service
public class OrderService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Transactional
	public int placeOrder(OrderDetails orderDetails) {
		Optional<Customer> optionalCustomer = customerRepository.findByEmail(orderDetails.getEmail());
		Customer customer;
		if(optionalCustomer.isEmpty()) {
			customer = new Customer();
			customer.setEmail(orderDetails.getEmail());
			customer.setName("Guest Account");
			customerRepository.save(customer);
		}
		else
			customer = optionalCustomer.get();
		
		Optional<Product> optionalProduct = productRepository.findById(orderDetails.getProductId());
		if(optionalProduct.isEmpty())
			throw new OrderException("Order canceled, product does not exist!");
		else {
			Product product = optionalProduct.get();
			if(product.getQuantity() < orderDetails.getQuantity())
				throw new OrderException("Order canceled, not enough stock available!");
			else {
				Order order = new Order();
				order.setOrderDate(LocalDateTime.now());
				order.setAmount(product.getPrice() * orderDetails.getQuantity());
				order.setCustomer(customer);
				order.setProduct(product);
				orderRepository.save(order);
				
				product.setQuantity(product.getQuantity() - orderDetails.getQuantity());
				productRepository.save(product);
				
				return order.getId();
			}		
		}
	}
	
	@Cacheable(value = "orders.cache", key = "#email")
	public List<Order> getOrders(String email) {
		return orderRepository.findByEmail(email);
	}
}
























