# Imagen Base
FROM openjdk:11-jre-slim

# Copiamos el Jar
COPY target/stock-vehiculos-0.0.1-SNAPSHOT.jar service.jar

# Ejecucion
ENTRYPOINT exec java -jar /service.jar
