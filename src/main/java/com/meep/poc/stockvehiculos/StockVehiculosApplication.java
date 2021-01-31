package com.meep.poc.stockvehiculos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Clase Main que realiza el despliegue del microservicio de Spring Boot.
 * 
 * @author Ignacio Fernandez Sanchez
 */
@SpringBootApplication
@EnableScheduling
@ComponentScan(basePackages = "com.meep.poc")
public class StockVehiculosApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockVehiculosApplication.class, args);
	}


}
