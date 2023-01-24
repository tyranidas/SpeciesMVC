package diginamic.fr.SpeciesMVC.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Pouet {
	@GetMapping("pouet")
	public String getPouet() {
	return "pouet";
	}
}
