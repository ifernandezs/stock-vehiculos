package com.meep.poc.stockvehiculos.adaptadores;

import java.util.Arrays;
import java.util.List;
import com.meep.poc.stockvehiculos.configuracion.properties.RecursosRestProperties;
import com.meep.poc.stockvehiculos.dominio.Vehiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import lombok.extern.slf4j.Slf4j;

/**
 * Adaptador Rest que gestiona las peticiones REST a terceros.
 * 
 * Este componente deberia ser incluido en un libreria externa de adaptadores que se cargasen como
 * librerias al microservicio,siguiendo un arquitectura hexagonal que nos permita independizar del
 * microservicio las integraciones con terceros.
 * 
 * https://refactorizando.com/ejemplo-de-arquitectura-hexagonal/
 * 
 * @author Ignacio Fernandez Sanchez
 */
@Component
@Slf4j
public class AdaptadorRestRecursos {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private RecursosRestProperties recursosRestProperties;

    /**
     * Metodo que obtiene el listado de recursos disponibles dado un marco base de configuracion del
     * Api definidos para la zona de Lisboa.
     * 
     * @param lowerLeftLatLon  Parametros de posicionamiento.
     * @param upperRightLatLon Parametros de posicionamiento.
     * @param companyZoneIds   Listado con los identificadores de compañias de zona que se desean
     *                         filtrar.
     * @return Listado de vehiculos[Recursos] disponibles para la zona de de Lisboa.
     */
    public List<Vehiculo> obtenerRecursosLisboa(final String lowerLeftLatLon,
            final String upperRightLatLon, List<Long> companyZoneIds) {

        final String url = recursosRestProperties.getUrlRecursosLisboa();
        final UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("lowerLeftLatLon", lowerLeftLatLon != null ? lowerLeftLatLon : "")
                .queryParam("upperRightLatLon", upperRightLatLon != null ? upperRightLatLon : "")
                .queryParam("companyZoneIds", companyZoneIds);

        log.info("[RECURSOS-LISBOA] --> Url de peticion de recursos: -->" + builder.toUriString());

        final ResponseEntity<Vehiculo[]> respuesta =
                restTemplate.getForEntity(builder.toUriString(), Vehiculo[].class);
        log.info("[RECURSOS-LISBOA] --> Codigo de respuesta HTTP obtenido: "
                + respuesta.getStatusCodeValue());
        if (respuesta.getStatusCode().equals(HttpStatus.OK)) {
            log.info("[RECURSOS-LISBOA] --> Listado de recursos obtenidos correctamente");
            return Arrays.asList(respuesta.getBody());
        } else {
            log.warn("[RECURSOS-LISBOA] --> No ha sido posible recuperar los recursos de la zona.");
            return Arrays.asList();
        }
    }

}
