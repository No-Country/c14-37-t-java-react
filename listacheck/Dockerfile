FROM maven:3.8.5-openjdk-17 AS build
COPY . .

FROM openjdk:17.0.1-jdk-slim
COPY --from=build target/listacheck-0.0.1-SNAPSHOT.jar listacheck-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","listacheck.jar"]