package com.meep.poc.stockvehiculos.configuracion.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Clase que contiene la configuracion especifica de Swagger para la documentacion del API.Cuando el
 * microservicio se despliega,automaticamente se autogenera la documentacion.
 * 
 * https://www.baeldung.com/swagger-2-documentation-for-spring-rest-api
 * https://springframework.guru/spring-boot-restful-api-documentation-with-swagger-2/
 * 
 *
 * @author Ignacio Fernandez Sanchez
 */
@Configuration
public class SwaggerConfig {


  /**
   * Docket de Swagger para desplegar la configuracion.
   * 
   * @return Docket de Swagger
   */
  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
        .paths(PathSelectors.ant("/api/v1/vehiculos/**")).build();
  }

}
