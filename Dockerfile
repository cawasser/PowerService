FROM openjdk:8-alpine

WORKDIR /power-service/

COPY target/uberjar/power-service.jar app.jar

EXPOSE 5001

ENV SERVICE_DELAY="5000"

ENV BROKER_HOST="127.0.0.1"
ENV BROKER_PORT=5672
ENV BROKER_USERNAME="guest"
ENV BROKER_PASSWORD="guest"
ENV BROKER_VHOST="/main"

CMD ["java", "-jar", "app.jar"]
