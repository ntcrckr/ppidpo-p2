FROM eclipse-temurin:17-jre-alpine
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar
RUN apk add --no-cache curl bash vim htop
ENTRYPOINT ["java", "-jar", "app.jar"]