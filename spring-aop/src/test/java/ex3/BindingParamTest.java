package ex3;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import service.Order;
import service.OrderService;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations="classpath:ex3/ex3-config.xml")
public class BindingParamTest {

	@Autowired private OrderService orderService;
	
	@Test
	public void testOrder() {
		orderService.placeOrder(new Order());
	}
}
