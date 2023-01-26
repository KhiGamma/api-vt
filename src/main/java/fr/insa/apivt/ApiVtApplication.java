package fr.insa.apivt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class ApiVtApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiVtApplication.class, args);
	}

}
