# stage 1
FROM maven:3.9-amazoncorretto-21 AS builder
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn clean package -DskipTests

# stage 2
FROM openjdk:21-jdk-slim
WORKDIR /app
COPY --from=builder /app/target/java-maven-3tier-mysql-app.jar app.jar
COPY src/main/resources/application.properties ./application.properties
ENTRYPOINT ["java","-jar","app.jar"]
