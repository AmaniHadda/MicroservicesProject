package tn.esprit.MembreProjet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient

public class MembreProjetApplication {

	public static void main(String[] args) {
		SpringApplication.run(MembreProjetApplication.class, args);
	}

}
