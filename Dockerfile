# Utiliser une image de base Java
FROM openjdk:17-jdk-slim

# Définir le répertoire de travail
WORKDIR /app

# Copier le fichier JAR construit dans l'image
COPY target/Exercice6Spring-0.0.1-SNAPSHOT.jar app.jar

# Exposer le port de l'application
EXPOSE 8080

# Commande pour exécuter l'application
CMD ["java", "-jar", "app.jar"]
