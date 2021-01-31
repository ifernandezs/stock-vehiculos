package com.meep.poc.stockvehiculos.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Arrays;
import java.util.List;
import com.meep.poc.stockvehiculos.dominio.Vehiculo;
import com.meep.poc.stockvehiculos.dominio.dto.VehiculoDTO;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

/**
 * Clase que contiene las pruebas unitarias de la clase @StockVehiculosMapper
 * 
 * @author Ignacio Fernandez Sanchez
 */
public class StockVehiculosMapperTest {

    @Test
    public void testMapearVehiculo() {
        StockVehiculosMapper stockVehiculosMapper = new StockVehiculosMapper(new ModelMapper());
        Vehiculo vehiculo = Vehiculo.builder().id("PT-LIS-A00187").model("Askoll").name("16VL50")
                .resourceType("MOPED").companyZoneId(Long.valueOf(473)).build();

        VehiculoDTO vehiculoDTO = stockVehiculosMapper.mapearVehiculo(vehiculo);
        assertEquals(vehiculo.getId(), vehiculoDTO.getId());
        assertEquals(vehiculo.getModel(), vehiculoDTO.getModel());
        assertEquals(vehiculo.getName(), vehiculoDTO.getName());
        assertEquals(vehiculo.getResourceType(), vehiculoDTO.getResourceType());
        assertEquals(vehiculo.getCompanyZoneId(), vehiculoDTO.getCompanyZoneId());
    }


    @Test
    public void testMapearListadoDeVehiculos() {
        StockVehiculosMapper stockVehiculosMapper = new StockVehiculosMapper(new ModelMapper());
        Vehiculo vehiculo = Vehiculo.builder().id("PT-LIS-A00187").model("Askoll").name("16VL50")
                .resourceType("MOPED").companyZoneId(Long.valueOf(473)).build();
        Vehiculo vehiculo2 = Vehiculo.builder().id("PT-LIS-A00487").model("Askoll").name("16ZC36")
                .resourceType("MOPED").companyZoneId(Long.valueOf(473)).build();

        List<VehiculoDTO> listadoVehiculoDTO =
                stockVehiculosMapper.mapearListadoVehiculosADTO(Arrays.asList(vehiculo, vehiculo2));
        assertEquals(2, listadoVehiculoDTO.size(), "Listado de vehiculos no esperado");
    }

}
