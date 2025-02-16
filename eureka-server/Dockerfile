#Start with base image containing java runtime
FROM openjdk:17 as build

#Information of owner or maintainer
MAINTAINER sodabank

#Add the application's jar to container
COPY target/eureka_server.jar eureka_server.jar

#Execute the application
ENTRYPOINT ["java", "-jar","/eureka_server.jar"]