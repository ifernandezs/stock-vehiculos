# STOCK-VEHICULOS

## Enpoints definidos

## Funcionamiento del servicio

Para la compilacion y ejecucion de pruebas unitarias del servicio sera necesario lanzar los siguientes comandos:

- Compilacion

  - mvn clean install -DskipTests

- Pruebas de integracion y cobertura de pruebas

  - mvn clean install -P docker -DskipTests

- Generacion de imagen

  - mvn clean package -P docker -DskipTests

- Publicacion de la imagen

  - mvn clean install -P docker -DskipTests

- Documentacion

  - mvn javadoc:javadoc

- Despliegue

  - mvn spring-boot:run

## Project Developer

   Ignacio Fernandez Sanchez --> ignaciofernandez@piperlab.es
