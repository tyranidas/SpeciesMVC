package diginamic.fr.SpeciesMVC;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@SpringBootApplication
public class SpeciesMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpeciesMvcApplication.class, args);
	}

}
