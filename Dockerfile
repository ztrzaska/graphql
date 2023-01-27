FROM openjdk:17-alpine

COPY target/graphql-0.0.1-SNAPSHOT.jar /usr/app/

WORKDIR /usr/app

EXPOSE 9001

ENTRYPOINT ["java", "-jar", "graphql-0.0.1-SNAPSHOT.jar"]