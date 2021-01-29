# Imagen Base
FROM openjdk:11-jre-slim

# Copiamos el Jar
COPY service.jar service.jar

# Ejecucion
ENTRYPOINT exec java -XX:+UseSerialGC -Xss512k -XX:MaxRAM=72m -Xmx2g -Xms32m -Djava.security.egd=file:/dev/./urandom -XX:NativeMemoryTracking=summary -XX:+UnlockExperimentalVMOptions -XX:+UseContainerSupport -jar /service.jar
