package ex2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import service.CustomerService;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations="classpath:ex2/ex2-config.xml")
public class BeforeAspectTest {

	@Autowired
	private CustomerService customerService;

	@Test
	public void testAspect() {
		customerService.applyForChequeBook(12345);
		customerService.applyForCreditCard("Majrul Ansari", 9999.9);
		customerService.stopCheque(12345);
		customerService.balance(12345);
	}
}
