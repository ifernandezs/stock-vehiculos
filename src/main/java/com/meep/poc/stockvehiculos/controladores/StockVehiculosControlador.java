package com.meep.poc.stockvehiculos.controladores;

import java.util.List;
import com.meep.poc.stockvehiculos.componentes.StockVehiculosComponente;
import com.meep.poc.stockvehiculos.dominio.dto.VehiculoDTO;
import com.meep.poc.stockvehiculos.mapper.StockVehiculosMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/api/v1/vehiculos")
public class StockVehiculosControlador {

        @Autowired
        private StockVehiculosMapper stockVehiculosMapper;

        @Autowired
        private StockVehiculosComponente stockVehiculosComponente;

        /**
         * Servicio Rest que exponde un listado de vehiculos en base a unos parametros de
         * configuracion definidos.
         * 
         * @param string         Identificador de posicion del vehiculo.
         * @param string2        Identificador de posicion del vehiculo.
         * @param companyZoneIds Listado de companias para filtrar.
         * @param disponibles    Boolean que indica si se desean solo los vehiculos disponibles.
         * @return Listado de vehiculos solicitados.
         */
        @ApiOperation(value = "Obtiene un listado de vehiculos en Base a una serie de filtros disponibles",
                        produces = MediaType.APPLICATION_JSON_VALUE)
        @GetMapping
        public ResponseEntity<List<VehiculoDTO>> obtenerStockVehiculos(final @RequestParam(
                        required = false, name = "disponibles") Boolean disponibles) {

                log.info("[VEHICULOS-CONTROLADOR] --> Obteniendo listado de vehiculos");

                List<VehiculoDTO> listadoVehiculos = stockVehiculosMapper
                                .mapearListadoVehiculosADTO(stockVehiculosComponente
                                                .obtenerVehiculos(disponibles));

                return new ResponseEntity<List<VehiculoDTO>>(listadoVehiculos, HttpStatus.OK);
        }



}
