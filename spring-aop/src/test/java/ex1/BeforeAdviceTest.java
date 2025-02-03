package ex1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import service.CustomerService;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations="classpath:ex1/ex1-config.xml")
public class BeforeAdviceTest {

	@Autowired
	private CustomerService customerService;

	@Test
	public void testAspect() {
		//getClass will confirm that a proxy was created dynamically
		System.out.println(customerService.getClass());
		//calling the method of the bean class. Client has no idea that
		customerService.applyForChequeBook(12345);
	}
}
