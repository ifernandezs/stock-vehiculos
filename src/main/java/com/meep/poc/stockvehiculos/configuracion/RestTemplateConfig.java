package com.meep.poc.stockvehiculos.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Clase de configuracion del RestTemplate de Spring.
 * 
 * https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/client/RestTemplate.html
 * 
 * @author Ignacio Fernandez Sanchez
 */
@Configuration
public class RestTemplateConfig {

  /**
   * Metodo que realiza la inicialización del Bean RestTemplate.
   *
   * @return Bean restTemplate
   */
  @Bean
  public RestTemplate restTemplate() {
      return new RestTemplate();
  }
}
