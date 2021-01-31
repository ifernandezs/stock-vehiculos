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

    /**
     * Metodo que realiza el mapeo de un listado de vehiculos y un listado de objetos DTO para
     * retornar al cliente.
     * 
     * @param listadoVehiculos Listado de vehiculos de dominio.
     * @return listado de objeto DTO.
     */
    public List<VehiculoDTO> mapearListadoVehiculosADTO(List<Vehiculo> listadoVehiculos) {
        List<VehiculoDTO> listadoVehiculosDTOs = new ArrayList<VehiculoDTO>();
        listadoVehiculos.stream().forEach(vehiculo -> {
            listadoVehiculosDTOs.add(mapearVehiculo(vehiculo));
        });
        return listadoVehiculosDTOs;
    }

    /**
     * Metodo que realiza el mapeo de un objeto de dominio Vehiculo a un objeto DTO vehiculoDTO.
     * 
     * @param vehiculo Objeto de dominio.
     * @return Objeto DTO.
     */
    public VehiculoDTO mapearVehiculo(Vehiculo vehiculo) {
        VehiculoDTO vehiculoDTO = modelMapper.map(vehiculo, VehiculoDTO.class);
        return vehiculoDTO;
    }

}
