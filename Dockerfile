FROM openjdk:17-jdk-slim-buster

RUN mkdir ./app

COPY . ./app

WORKDIR ./app

CMD ["./gradlew", "bootRun"]