FROM openjdk:8-jdk-alpine
ADD target/*.jar RegistrationService-0.0.1-SNAPSHOT.jar
EXPOSE 8093
ENTRYPOINT ["java", "-jar", "RegistrationService-0.0.1-SNAPSHOT.jar"]