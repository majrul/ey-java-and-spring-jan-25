package ex7;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import service.CustomerService;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations="classpath:ex7/ex7-config.xml")
public class AroundTest {

	@Autowired private CustomerService customerService;

	@Test
	public void testAroundAdvice() {
		customerService.applyForChequeBook(12345);
		customerService.stopCheque(12345);
	}
	
}
