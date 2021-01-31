package com.meep.poc.stockvehiculos.controladores;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.util.Arrays;
import java.util.List;
import com.meep.poc.stockvehiculos.componentes.StockVehiculosComponente;
import com.meep.poc.stockvehiculos.dominio.Vehiculo;
import com.meep.poc.stockvehiculos.dominio.dto.VehiculoDTO;
import com.meep.poc.stockvehiculos.mapper.StockVehiculosMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * Clase que contiene las pruebas unitarias de la clase @StockVehiculosControlador.
 * 
 * @author Ignacio Fernandez Sanchez
 */
public class StockVehiculosControladorTest {

        @Mock
        private StockVehiculosComponente stockVehiculosComponenteMock;

        @Mock
        private StockVehiculosMapper stockVehiculosMapperMock;

        @InjectMocks
        private StockVehiculosControlador stockVehiculosControlador;

        @BeforeEach
        public void before() {
                MockitoAnnotations.openMocks(this);
        }

        @Test
        public void testObtenerListadoComentarios() {
                Mockito.when(stockVehiculosComponenteMock.obtenerVehiculos(Mockito.anyBoolean()))
                                .thenReturn(Arrays.asList(new Vehiculo(), new Vehiculo()));

                Mockito.when(stockVehiculosMapperMock.mapearListadoVehiculosADTO(Mockito.anyList()))
                                .thenReturn(Arrays.asList(new VehiculoDTO(), new VehiculoDTO()));

                ResponseEntity<List<VehiculoDTO>> respuesta =
                                stockVehiculosControlador.obtenerStockVehiculos(Boolean.TRUE);

                // Assercciones
                assertEquals(HttpStatus.OK, respuesta.getStatusCode(),
                                "Codigo de respuesta no esperado");
                assertNotNull(respuesta.getBody(), "Objeto de respuesta nulo");

                // Verificaciones de Mocks
                Mockito.verify(stockVehiculosComponenteMock, Mockito.times(1))
                                .obtenerVehiculos(Mockito.anyBoolean());
                Mockito.verify(stockVehiculosMapperMock, Mockito.times(1))
                                .mapearListadoVehiculosADTO(Mockito.anyList());
        }

}
