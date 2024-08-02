FROM maven:3.8.5-openjdk-17-slim


WORKDIR /app


COPY target/Exercice6Spring-0.0.1-SNAPSHOT.jar app.jar


EXPOSE 8080


CMD ["java", "-jar", "app.jar"]
