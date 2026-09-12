FROM gradle:8-jdk21 AS build
WORKDIR /home/gradle/src
COPY . .
RUN gradle buildFatJar --no-daemon

FROM amazoncorretto:21
EXPOSE 8080
RUN mkdir /app
COPY --from=build /home/gradle/src/build/libs/*-all.jar /app/app.jar
ENTRYPOINT ["java","-jar","/app/app.jar"]