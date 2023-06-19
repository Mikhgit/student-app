FROM eclipse-temurin:17-jre-alpine

ARG APP_NAME="student-app-0.0.1"
ARG JAR_FILE="/build/libs/${APP_NAME}.jar"

COPY ${JAR_FILE} application.jar
ENTRYPOINT ["java","-jar", "application.jar"]