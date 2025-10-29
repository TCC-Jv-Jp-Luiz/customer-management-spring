FROM alpine:3.20
RUN apk add --no-cache openjdk21-jre
WORKDIR /customers
ENV JAR_NAME=customer-management-spring-0.0.1-SNAPSHOT.jar
COPY target/$JAR_NAME $JAR_NAME
ENTRYPOINT java -jar $JAR_NAME
