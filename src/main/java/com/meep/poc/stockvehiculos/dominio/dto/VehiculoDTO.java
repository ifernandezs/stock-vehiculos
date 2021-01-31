package com.meep.poc.stockvehiculos.dominio.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Objeto DTO que engloba los datos de un vehiculo en el aplicativo.
 * 
 * @author Ignacio Fernandez Sanchez
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@ToString
@ApiModel(value = "vehiculo", description = "Objeto que contiene los atributos de un vehiculo")
public class VehiculoDTO {

        @ApiModelProperty(name = "id", notes = "Identificador del vehiculo", required = true,
                        example = "VR1URHNKKKW125173", position = 0)
        private String id;

        @ApiModelProperty(name = "name", notes = "Nombre del vehiculo", required = true,
                        example = "162_40ZI28", position = 1)
        private String name;

        @ApiModelProperty(name = "model", notes = "Modelo del vehiculo", required = true,
                        example = "Askoll", position = 2)
        private String model;

        @ApiModelProperty(name = "resourceType", notes = "Tipo del vehiculo", required = true,
                        example = "MOPED", position = 3)
        private String resourceType;

        @ApiModelProperty(name = "companyZoneId",
                        notes = "Identificador de compania asociada al vehiculo", required = true,
                        example = "473", position = 4)
        private Long companyZoneId;
}
