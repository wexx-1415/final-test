FROM openjdk:latest
WORKDIR app
COPY ./target/final-test-0.0.1-SNAPSHOT.jar .
CMD ["java","-jar","final-test-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080