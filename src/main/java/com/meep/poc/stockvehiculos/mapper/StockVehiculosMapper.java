package com.meep.poc.stockvehiculos.mapper;

import java.util.ArrayList;
import java.util.List;
import com.meep.poc.stockvehiculos.dominio.Vehiculo;
import com.meep.poc.stockvehiculos.dominio.dto.VehiculoDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;

/**
 * Componenente interno que realiza el mapeo entre objetos de dominio y DTO.
 * 
 * https://www.baeldung.com/entity-to-and-from-dto-for-a-java-spring-application
 * 
 * @author Ignacio Fernandez Sanchez
 */
@Component
@AllArgsConstructor
public class StockVehiculosMapper {

    @Autowired
    private ModelMapper modelMapper;

    public List<VehiculoDTO> mapearListadoVehiculosADTO(List<Vehiculo> listadoVehiculos) {
        List<VehiculoDTO> listadoVehiculosDTOs = new ArrayList<VehiculoDTO>();
        listadoVehiculos.stream().forEach(vehiculo -> {
            listadoVehiculosDTOs.add(mapearVehiculo(vehiculo));
        });
        return listadoVehiculosDTOs;
    }

    public VehiculoDTO mapearVehiculo(Vehiculo vehiculo) {
        VehiculoDTO vehiculoDTO = modelMapper.map(vehiculo, VehiculoDTO.class);
        return vehiculoDTO;
    }

}
