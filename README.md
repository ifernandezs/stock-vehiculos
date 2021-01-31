# STOCK-VEHICULOS

Microservicio que gestiona el listado de vehiculos disponibles y no disponibles para una determinada region.

## Enpoints definidos

- [GET] http://{$host}:{$port}/api/v1/vehiculos?disponibles=[TRUE/FALSE]

## Compilacion,test,despliegue y generacion del entregable

Para la compilacion y ejecucion de pruebas unitarias del servicio sera necesario lanzar los siguientes comandos:

- Compilacion

  - mvn clean install -DskipTests

- Pruebas de integracion y cobertura de pruebas

  - mvn clean test

- Despliegue del microservicio.

  - mvn spring-boot:run

## Generacion y ejecucion de la imagen Docker

- Generacion de imagen

  - docker build -t {$imageName:${imageTag}} .

- Ejecucion de la imagen

  - docker run --rm -it ${imageName}:${imageTag}

## Documentacion y testing del API [SWAGGER]

- http://{$host}:{$port}/swagger-ui/index.html

- http://{$host}:{$port}/v2/api-docs

## Preguntas

- ¿Cómo de escalable es tu solución propuesta?

  - Debido a los tiempos disponibles,para la propuesta técnica se ha optado por un microservicio desarrollado con una arquitecuta por capas que permita escalar la solución a futuras necesidades que puedan ser necesarias,como por ejemplo una persistencia de datos a traves de la capa de repositorios,que en la solución no se ha implementado,por falta de tiempo.
  La decisión por tomar este tipo de arquitecturas es que cada una de las capas (Controlador,Componente,Repositorio),tenga un rol muy definido cumpliendo con el principio de separación de responsabilidades en cada de una de ellas.

- ¿Qué problemas a futuro podría presentar?

  - Considero que en una solución mas robusta,se podría implementar un patrón de diseño de eventos para generar eventos que actualizaran los recursos que pasan a estar disponibles y los que dejan de estarlo.

- ¿Qué alternativa/s propones para solventar dichos problemas?

  - Una implementación mediante un patron de diseño Observer que nos permita realizar acciones como consecuencia de la disponibilidad o no del recurso en un momento dado.

## Project Developer

   Ignacio Fernandez Sanchez --> ignaciofs87@gmail.com
