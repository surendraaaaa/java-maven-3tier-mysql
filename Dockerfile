
# Stage 1: Build the application
FROM maven:3.9-amazoncorretto-21 AS builder
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# stage 2
FROM openjdk:21-jdk-slim
WORKDIR /app
COPY --from=builder /app/target/java-maven-3tier-mysql-app.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
