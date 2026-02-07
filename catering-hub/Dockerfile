#
# Build Stage
#
FROM maven:3.9.9-eclipse-temurin-21 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

#
# Package Stage
#
FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/target/catering-hub-0.0.1-SNAPSHOT.jar demo.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "demo.jar"]