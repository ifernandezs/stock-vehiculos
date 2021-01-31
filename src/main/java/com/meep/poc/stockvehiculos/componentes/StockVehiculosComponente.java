package com.meep.poc.stockvehiculos.componentes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import com.meep.poc.stockvehiculos.adaptadores.AdaptadorRestRecursos;
import com.meep.poc.stockvehiculos.configuracion.properties.RecursosRestProperties;
import com.meep.poc.stockvehiculos.dominio.Vehiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Componente interno de negocio que realiza las operaciones de gestion el stock de vehiculos
 * disponibles.
 * 
 * @author Ignacio Fernandez Sanchez
 */
@Slf4j
@Component
@AllArgsConstructor
public class StockVehiculosComponente {

    @Autowired
    private AdaptadorRestRecursos adaptadorRestRecursos;

    @Autowired
    private RecursosRestProperties recursosRestProperties;

    private List<Vehiculo> listDisp;

    private List<Vehiculo> listNoDisp;

    @Scheduled(fixedDelay = 30000)
    public void actualizarRecursos() {
        log.info("[VEHICULOS-COMPONENTE] --> Obteniendo recursos actualizados de LISBOA");
        List<Vehiculo> listadoActualizado = adaptadorRestRecursos.obtenerRecursosLisboa(
                recursosRestProperties.getLowerLeftLatLon(),
                recursosRestProperties.getUpperRightLatLon(),
                recursosRestProperties.getCompanyZoneIds());

        log.info("[VEHICULOS-COMPONENTE] --> Actualizando listado de recursos no disponibles");
        actualizarNoDisponibles(listadoActualizado);
        log.info("[VEHICULOS-COMPONENTE] --> Actualizando listado de recursos disponibles");
        actualizarDisponibles(listadoActualizado);

    }

    /**
     * Metodo que actualiza el listado de vehiculos disponibles.
     * 
     * @param listadoActualizado Listado de recursos actualizado.
     */
    private void actualizarDisponibles(List<Vehiculo> listadoActualizado) {
        listDisp = listadoActualizado;
        log.info("[VEHICULOS-COMPONENTE] --> Numero de recursos disponibles: [" + listDisp.size()
                + "]");
    }

    private void actualizarNoDisponibles(List<Vehiculo> listadoActualizado) {
        if (listDisp != null) {
            listNoDisp = listDisp.stream().filter(element -> !listadoActualizado.contains(element))
                    .collect(Collectors.toList());
            log.info("[VEHICULOS-COMPONENTE] --> Numero de recursos NO disponibles: ["
                    + listNoDisp.size() + "]");
        } else {
            listNoDisp = new ArrayList<Vehiculo>();
        }
    }

    /**
     * Metodo que obtiene el listado de vehiculos disponibles o no disponibles en base a los filtros
     * dados.
     * 
     * @param disponibles Booleano que le indica al metodo que listado de vehiculos se desea.
     * 
     * @return Listado de vehiculos.
     */
    public List<Vehiculo> obtenerVehiculos(Boolean disponibles) {
        if (!disponibles) {
            log.info(
                    "[VEHICULOS-COMPONENTE] --> resolviendo peticion de vehiculos no disponibles en la plataforma");
            return listNoDisp;
        } else {
            log.info(
                    "[VEHICULOS-COMPONENTE] --> resolviendo peticion de vehiculos disponibles en la plataforma");
            return listDisp;
        }
    }

}
