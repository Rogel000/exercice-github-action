FROM maven:3.8.1-openjdk-17 AS builder

WORKDIR /app

COPY pom.xml .

RUN mvn dependency:go-offline

COPY src ./src

RUN mvn package -DskipTests

FROM openjdk

COPY --from=builder /app/target/Exercice6Spring-0.0.1-SNAPSHOT.jar .


EXPOSE 8080


CMD ["java", "-jar", "Exercice6Spring-0.0.1-SNAPSHOT.jar"]
