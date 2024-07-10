FROM openjdk:17-jdk-alpine

COPY target/*.jar config-server-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","/config-server-0.0.1-SNAPSHOT.jar"]
