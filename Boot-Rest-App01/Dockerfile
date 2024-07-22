FROM openjdk:17
COPY target/springboot-rest-app.jar /usr/local
WORKDIR /usr/local
ENTRYPOINT ["java","-jar","springboot-rest-app.jar"]