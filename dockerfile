FROM maven:3.8.1-openjdk-8 AS builder
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

FROM openjdk:8
WORKDIR /app
COPY --from=builder /app/target/eventsProject-1.0.0-SNAPSHOT.jar /event.jar
EXPOSE 8089
ENTRYPOINT ["java", "-jar", "/event.jar"]
