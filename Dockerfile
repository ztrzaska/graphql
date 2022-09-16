FROM openjdk:11-jre

COPY target/graphql-0.0.1-SNAPSHOT.jar /usr/app/

WORKDIR /usr/app

ENTRYPOINT ["java", "-jar", "graphql-0.0.1-SNAPSHOT.jar"]