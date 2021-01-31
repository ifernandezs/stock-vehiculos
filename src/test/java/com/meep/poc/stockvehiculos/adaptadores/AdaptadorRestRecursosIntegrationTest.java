package com.meep.poc.stockvehiculos.adaptadores;


import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.util.Arrays;
import com.meep.poc.stockvehiculos.configuracion.RestTemplateConfig;
import com.meep.poc.stockvehiculos.configuracion.properties.RecursosRestProperties;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

/**
 * Clase que contiene las pruebas de integracion de la clase @RecursosRestComponente.
 * 
 * @author Ignacio Fernandez Sanchez
 */
@SpringBootTest(classes = {AdaptadorRestRecursos.class, RestTemplateConfig.class})
class AdaptadorRestRecursosIntegrationTest {

        @MockBean
        private RecursosRestProperties recursosRestPropertiesMock;

        @Autowired
        private AdaptadorRestRecursos recursosRestComponente;

        @BeforeEach
        public void before() {
                MockitoAnnotations.openMocks(this);
        }

        @Test
        public void testRegistrarComentariosOk() {
                String urlRecursosLisboa =
                                "https://apidev.meep.me/tripplan/api/v1/routers/lisboa/resources";
                Mockito.when(recursosRestPropertiesMock.getUrlRecursosLisboa())
                                .thenReturn(urlRecursosLisboa);

                assertNotNull(recursosRestComponente.obtenerRecursosLisboa("38.711046,-9.160096",
                                "38.739429,-9.137115", Arrays.asList(Long.valueOf(545),
                                                Long.valueOf(467), Long.valueOf(473))),
                                "respuesta no esperada");
        }
}
