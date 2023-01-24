package diginamic.fr.SpeciesMVC.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExcepAspect {

	@AfterThrowing(pointcut = "execution(public * diginamic.fr.SpeciesMVC.controller..*(..))", throwing ="ex")
	public void logError(Exception ex) throws Throwable {
		System.out.println("pouet");
		System.out.println(ex);
	
		
	}
}
