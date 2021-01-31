package com.meep.poc.stockvehiculos.configuracion.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import lombok.Getter;
import lombok.Setter;

/**
 * Clase que contiene las propiedades especificas de Swagger.
 *
 * @author Ignacio Fernandez Sanchez
 */
@Component
@Getter
@Setter
public class SwaggerProperties {

    @Value("${swagger.contact.name:}")
    private String contactName;

    @Value("${swagger.contact.url:}")
    private String contactUrl;

    @Value("${swagger.contact.email:}")
    private String contactEmail;

    @Value("${swagger.service.title:}")
    private String title;

    @Value("${swagger.service.description:}")
    private String serviceDescription;

    @Value("${swagger.service.version:}")
    private String serviceVersion;

    @Value("${swagger.service.termsOfServiceUrl:}")
    private String termsOfServiceUrl;

    @Value("${swagger.service.license:}")
    private String license;

    @Value("${swagger.service.licenseUrl:}")
    private String licenseUrl;

    @Value("${swagger.docket.groupName:}")
    private String groupName;

    @Value("${swagger.docket.basePackage:}")
    private String basePackage;

}
