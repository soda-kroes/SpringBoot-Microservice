#Start with base image containing java runtime
FROM openjdk:17 as build

#Information of owner or maintainer
MAINTAINER sodabank

#Add the application's jar to container
COPY target/config_server.jar config_server.jar

#Execute the application
ENTRYPOINT ["java", "-jar","/config_server.jar"]