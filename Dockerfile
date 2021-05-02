FROM openjdk:8-jdk-alpine
EXPOSE 8080
ARG JAR_FILE=target/ms-api-core-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} ms-entry.jar
ENTRYPOINT ["java","-jar","/ms-entry.jar"]