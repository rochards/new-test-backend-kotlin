FROM openjdk:17-slim
WORKDIR /app
COPY build/libs/*SNAPSHOT.jar /app/app.jar
COPY src/main/resources/*.properties /app/
EXPOSE 8080
CMD ["java", "-jar", "/app/app.jar"]

