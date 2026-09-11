package pe.edu.upeu.garritas.usuario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class GarritasUsuarioMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(GarritasUsuarioMsApplication.class, args);
	}

}