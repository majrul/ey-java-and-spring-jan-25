package ex6;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations="classpath:ex6/ex6-config.xml")
public class AfterThrowingAdviceTest {

	@Autowired private BusinessInterface businessInterface;
	
	@Test
	public void testAroundAdvice() {
		try {
			businessInterface.someBusinessMethod();
		}
		catch (Exception e) {
			System.out.println("Client caught exception : "+e);
		}
	}
}
