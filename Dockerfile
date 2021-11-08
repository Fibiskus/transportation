FROM openjdk:11
EXPOSE 8080
ADD target/transportation-0.0.1-SNAPSHOT.jar transportation-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/transportation-0.0.1-SNAPSHOT.jar"]