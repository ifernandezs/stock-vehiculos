package com.meep.poc.stockvehiculos.configuracion.properties;

import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import lombok.Getter;
import lombok.Setter;

/**
 * Componente interno que gestiona las propiedades del adaptador Rest de recursos externos.
 * 
 * @author Ignacio Fernadez Sanchez
 */
@Component
@Getter
@Setter
public class RecursosRestProperties {

    @Value("${recursos.data.lowerLeftLatLon:}")
    private String lowerLeftLatLon;

    @Value("${recursos.data.upperRightLatLon:}")
    private String upperRightLatLon;

    @Value("${recursos.data.companyZoneIds:}")
    private List<Long> companyZoneIds;

    @Value("${recursos.url.lisboa:}")
    private String urlRecursosLisboa;

}
