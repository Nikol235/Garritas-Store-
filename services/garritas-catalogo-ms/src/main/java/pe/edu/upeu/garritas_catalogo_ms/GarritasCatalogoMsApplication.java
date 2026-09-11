package pe.edu.upeu.garritas.catalogo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class GarritasCatalogoMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(GarritasCatalogoMsApplication.class, args);
	}

}