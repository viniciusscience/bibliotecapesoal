FROM openjdk:17-jdk-alpine
COPY target/bibliotecapessoal-0.0.1-SNAPSHOT.jar /bibliotecapessoal-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","bibliotecapessoal-0.0.1-SNAPSHOT.jar"]