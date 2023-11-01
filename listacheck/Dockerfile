FROM eclipse-temurin:21-alpine
VOLUME /tmp
COPY target/listacheck-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
EXPOSE 8080
