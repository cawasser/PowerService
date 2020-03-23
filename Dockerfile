FROM openjdk:8-alpine

COPY target/uberjar/power-service.jar /power-service/app.jar

EXPOSE 3000

CMD ["java", "-jar", "/power-service/app.jar"]
