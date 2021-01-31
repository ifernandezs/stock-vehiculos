package com.meep.poc.stockvehiculos.adaptadores;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.meep.poc.stockvehiculos.configuracion.properties.RecursosRestProperties;
import com.meep.poc.stockvehiculos.dominio.Vehiculo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * Clase que contiene las pruebas unitarias de las clase @RecursoRestComponente.
 * 
 * @author Ignacio Fernandez Sanchez
 */
public class AdaptadorRestRecursosTest {

        @Mock
        private RestTemplate restTemplateMock;

        @Mock
        private RecursosRestProperties recursosRestPropertiesMock;

        @InjectMocks
        private AdaptadorRestRecursos adaptadorRestRecursos;

        @BeforeEach
        public void before() {
                MockitoAnnotations.openMocks(this);
        }

        @Test
        public void testObtenerRecursosLisboaOK() {
                final List<Vehiculo> listadoVehiculos = new ArrayList<>();
                listadoVehiculos.add(new Vehiculo("VR1URHNKKKW125173", "162_40ZI28", "null DS3",
                                "ELECTRIC_CAR", Long.valueOf(467)));
                final ResponseEntity<Vehiculo[]> respuesta = new ResponseEntity<Vehiculo[]>(
                                listadoVehiculos.toArray(new Vehiculo[listadoVehiculos.size()]),
                                HttpStatus.OK);

                Mockito.when(recursosRestPropertiesMock.getUrlRecursosLisboa()).thenReturn(
                                "https://apidev.meep.me/tripplan/api/v1/routers/lisboa/resources");
                Mockito.when(restTemplateMock.getForEntity(Mockito.anyString(),
                                Mockito.eq(Vehiculo[].class))).thenReturn(respuesta);

                List<Vehiculo> listadoRecursosRespuesta = adaptadorRestRecursos
                                .obtenerRecursosLisboa("38.711046,-9.160096", "38.739429,-9.137115",
                                                Arrays.asList(Long.valueOf(545), Long.valueOf(467),
                                                                Long.valueOf(473)));

                // Assercciones
                assertEquals(1, listadoRecursosRespuesta.size(),
                                "El listado de recursos no es el esperado");

                listadoRecursosRespuesta = adaptadorRestRecursos.obtenerRecursosLisboa(null, null,
                                Arrays.asList(Long.valueOf(545), Long.valueOf(467),
                                                Long.valueOf(473)));

                // Assercciones
                assertEquals(1, listadoRecursosRespuesta.size(),
                                "El listado de recursos no es el esperado");

                // Verificacion de Mocks
                Mockito.verify(recursosRestPropertiesMock, Mockito.times(2)).getUrlRecursosLisboa();
                Mockito.verify(restTemplateMock, Mockito.times(2)).getForEntity(Mockito.anyString(),
                                Mockito.any());
        }

        @Test
        public void testObtenerRecursosLisboaKO() {
                final ResponseEntity<Vehiculo[]> respuesta =
                                new ResponseEntity<Vehiculo[]>(HttpStatus.BAD_REQUEST);

                Mockito.when(recursosRestPropertiesMock.getUrlRecursosLisboa()).thenReturn(
                                "https://apidev.meep.me/tripplan/api/v1/routers/lisboa/resources");
                Mockito.when(restTemplateMock.getForEntity(Mockito.anyString(),
                                Mockito.eq(Vehiculo[].class))).thenReturn(respuesta);


                List<Vehiculo> listadoRecursosRespuesta = adaptadorRestRecursos
                                .obtenerRecursosLisboa("38.711046,-9.160096", "38.739429,-9.137115",
                                                Arrays.asList(Long.valueOf(545), Long.valueOf(467),
                                                                Long.valueOf(473)));

                // Assercciones
                assertEquals(0, listadoRecursosRespuesta.size(),
                                "El listado de recursos no es el esperado");

                // Verificacion de Mocks
                Mockito.verify(recursosRestPropertiesMock, Mockito.times(1)).getUrlRecursosLisboa();
                Mockito.verify(restTemplateMock, Mockito.times(1)).getForEntity(Mockito.anyString(),
                                Mockito.any());


        }

}
