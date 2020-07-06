# For Java 8, try this
# FROM openjdk:8-jdk-alpine

# For Java 11, try this
FROM adoptopenjdk/openjdk11:alpine-jre

# Refer to Maven build -> finalName
ARG JAR_FILE=target/anagram.war

# cd /opt/app
WORKDIR /opt/app

# cp target/anagram.war /opt/app/app.war
COPY ${JAR_FILE} app.war

# java -jar /opt/app/app.jar
ENTRYPOINT ["java","-jar","app.war"]
