package com.meep.poc.stockvehiculos.configuracion;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Clase de configuracion del ModelMapper.
 * 
 * https://www.baeldung.com/entity-to-and-from-dto-for-a-java-spring-application
 * 
 * @author Ignacio Fernandez Sanchez
 */
@Configuration
public class ModelMapperConfig {

    /**
     * Metodo que realiza la inicialización del Bean ModelMapper.
     *
     * @return Bean ModelMapper
     */
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
