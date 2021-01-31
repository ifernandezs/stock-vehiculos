package com.meep.poc.stockvehiculos.componentes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Arrays;
import java.util.List;
import com.meep.poc.stockvehiculos.adaptadores.AdaptadorRestRecursos;
import com.meep.poc.stockvehiculos.configuracion.properties.RecursosRestProperties;
import com.meep.poc.stockvehiculos.dominio.Vehiculo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Clase que contiene las pruebas unitarias de la clase @StockVehiculosComponente.
 * 
 * @author Ignacio Fernandez Sanchez
 */
public class StockVehiculosComponenteTest {

    @Mock
    private AdaptadorRestRecursos adaptadorRestRecursosMock;

    @Mock
    private RecursosRestProperties recursosRestPropertiesMock;

    @InjectMocks
    private StockVehiculosComponente stockVehiculosComponente;

    @BeforeEach
    public void before() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testObtenerRecursosYListadoVehiculos() {
        Mockito.when(recursosRestPropertiesMock.getLowerLeftLatLon())
                .thenReturn("38.711046,-9.160096");
        Mockito.when(recursosRestPropertiesMock.getUpperRightLatLon())
                .thenReturn("38.711046,-9.160096");
        Mockito.when(recursosRestPropertiesMock.getCompanyZoneIds())
                .thenReturn(Arrays.asList(Long.valueOf(545), Long.valueOf(467), Long.valueOf(473)));

        Mockito.when(adaptadorRestRecursosMock.obtenerRecursosLisboa("38.711046,-9.160096",
                "38.711046,-9.160096",
                Arrays.asList(Long.valueOf(545), Long.valueOf(467), Long.valueOf(473))))
                .thenReturn(generarListaVehiculosPrimeraPeticion())
                .thenReturn(generarListaVehiculosSegundaPeticion());

        // Primera peticion
        stockVehiculosComponente.actualizarRecursos();
        assertEquals(5, stockVehiculosComponente.obtenerVehiculos(Boolean.TRUE).size());
        assertEquals(0, stockVehiculosComponente.obtenerVehiculos(Boolean.FALSE).size());

        // Segunda peticion
        stockVehiculosComponente.actualizarRecursos();
        assertEquals(4, stockVehiculosComponente.obtenerVehiculos(Boolean.TRUE).size());
        assertEquals(2, stockVehiculosComponente.obtenerVehiculos(Boolean.FALSE).size());

    }

    private List<Vehiculo> generarListaVehiculosPrimeraPeticion() {
        Vehiculo vehiculo1 = Vehiculo.builder().id("PT-LIS-A00187").model("Askoll").name("16VL50")
                .resourceType("MOPED").companyZoneId(Long.valueOf(473)).build();
        Vehiculo vehiculo2 = Vehiculo.builder().id("PT-LIS-A00487").model("Askoll").name("16ZC36")
                .resourceType("MOPED").companyZoneId(Long.valueOf(473)).build();
        Vehiculo vehiculo3 = Vehiculo.builder().id("PPT-LIS-A00477").model("Askoll").name("16ZC62")
                .resourceType("MOPED").companyZoneId(Long.valueOf(473)).build();
        Vehiculo vehiculo4 = Vehiculo.builder().id("PT-LIS-A00294").model("Askoll").name("61ZB16")
                .resourceType("MOPED").companyZoneId(Long.valueOf(473)).build();
        Vehiculo vehiculo5 = Vehiculo.builder().id("PT-LIS-A00319").model("Askoll").name("87ZB62")
                .resourceType("MOPED").companyZoneId(Long.valueOf(473)).build();
        return Arrays.asList(vehiculo1, vehiculo2, vehiculo3, vehiculo4, vehiculo5);
    }

    private List<Vehiculo> generarListaVehiculosSegundaPeticion() {
        Vehiculo vehiculo1 = Vehiculo.builder().id("PT-LIS-A00187").model("Askoll").name("16VL50")
                .resourceType("MOPED").companyZoneId(Long.valueOf(473)).build();
        Vehiculo vehiculo3 = Vehiculo.builder().id("PPT-LIS-A00477").model("Askoll").name("16ZC62")
                .resourceType("MOPED").companyZoneId(Long.valueOf(473)).build();
        Vehiculo vehiculo4 = Vehiculo.builder().id("PT-LIS-A00294").model("Askoll").name("61ZB16")
                .resourceType("MOPED").companyZoneId(Long.valueOf(473)).build();
        Vehiculo vehiculo6 = Vehiculo.builder().id("PT-LIS-A00339").model("Askoll").name("841357")
                .resourceType("MOPED").companyZoneId(Long.valueOf(473)).build();
        return Arrays.asList(vehiculo1, vehiculo3, vehiculo4, vehiculo6);
    }

}
