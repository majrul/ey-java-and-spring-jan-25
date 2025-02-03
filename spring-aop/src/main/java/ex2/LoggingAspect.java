package ex2;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect {

	@Before("execution(public * apply*(..))") //pointcut
	public void log(JoinPoint joinPoint) {
		System.out.println("common logging code executed for : "+joinPoint);
	}	
}
