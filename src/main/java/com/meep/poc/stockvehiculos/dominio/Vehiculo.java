package com.meep.poc.stockvehiculos.dominio;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Objeto de Dominio para los gestion de los datos de vehiculos.
 * 
 * @author Ignacio Fernandez Sanchez
 */
@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Vehiculo {

    private String id;

    private String name;

    private String model;

    private String resourceType;

    private Long companyZoneId;

}
