FROM openjdk:8-jdk-alpine

EXPOSE 8080

ARG JAR_FILE=target/spring-0.0.1-SNAPSHOT.jar

ADD ${JAR_FILE} spring-0.0.1-SNAPSHOT.jar 

ENTRYPOINT ["java","-jar","/spring-0.0.1-SNAPSHOT.jar"]