FROM openjdk:8
ADD target/eventsProject-1.0.0-SNAPSHOT.jar event.jar
EXPOSE 8089
ENTRYPOINT ["java", "-jar", "event.jar"]