package com.training.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.support.SimpleValueWrapper;
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
	private CacheManager cacheManager;
	
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
				
				Cache cache = cacheManager.getCache("orders.cache");
				//cache.clear();
				SimpleValueWrapper ordersWrapper = (SimpleValueWrapper) cache.get(orderDetails.getEmail());
				if(ordersWrapper != null) {
					List<Order> orders = (List<Order>) ordersWrapper.get();
					orders.add(order);
					cache.put(orderDetails.getEmail(), orders);
				}
				
				return order.getId();
			}		
		}
	}
	
	@Cacheable(value = "orders.cache", key = "#email")
	public List<Order> getOrders(String email) {
		return orderRepository.findByEmail(email);
	}

	@Cacheable(value = "orders2.cache", key = "#customerId")
	public List<Order> getOrders(int customerId) {
		return orderRepository.findByCustomerId(customerId);
	}
}
























