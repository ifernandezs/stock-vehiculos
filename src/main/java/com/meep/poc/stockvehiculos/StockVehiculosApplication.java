package com.meep.poc.stockvehiculos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class StockVehiculosApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockVehiculosApplication.class, args);
	}

}
