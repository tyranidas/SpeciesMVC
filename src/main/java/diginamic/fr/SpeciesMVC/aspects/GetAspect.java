package diginamic.fr.SpeciesMVC.aspects;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class GetAspect {
	
	@Before("execution(* diginamic.fr.SpeciesMVC..get*(..))")
	public void logGet(JoinPoint joinPoint) {
		System.out.println(joinPoint.getSignature());
		System.out.println("Par la force du roblochon AOP");
	}
}
