package com.meep.poc.stockvehiculos.dominio;

import org.springframework.data.annotation.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Vehiculo {

    @Id
    private String idVehiculo;

    private String id;

    private String name;

    private String model;

    private String resourceType;

    private Long companyZoneId;

}
