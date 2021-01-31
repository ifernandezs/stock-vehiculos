package com.meep.poc.stockvehiculos;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Clase que contiene las pruebas de despliegue del servicio y la carga correcta del contexto de
 * Spring.
 * 
 * @author Ignacio Fernandez Sanchez
 */
@SpringBootTest
class StockVehiculosApplicationTests {

	@Test
	public void testDespliegueStockVehiculos() {
		String[] array = new String[] {};
		StockVehiculosApplication.main(array);
	}

}
