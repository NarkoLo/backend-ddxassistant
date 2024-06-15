# Use OpenJDK 17 Alpine as the base image
FROM openjdk:17-jdk-alpine

WORKDIR /app

# Copy the Maven pom.xml and src code to the container
COPY pom.xml .
COPY src ./src

# Copy application.yaml to the container
COPY src/main/resources/application-prod.yaml src/main/resources/application-prod.yaml

# Build the application using Maven
RUN apk add --no-cache maven && \
    mvn clean package -DskipTests && \
    mv target/*.jar app.jar && \
    mvn clean

# Expose the port the app runs on
EXPOSE 8080

CMD ["java", "-jar", "app.jar"]