package diginamic.fr.SpeciesMVC.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {
	@Before("execution(public * diginamic.fr.SpeciesMVC.controller..*(..))")
	public void logMeth(JoinPoint joinPoint) {
		System.out.println(joinPoint.getSignature().getName());
		System.out.println("Par la force du controlleur AOP");
	}
}
