# FROM openjdk
# WORKDIR /app
# COPY . /app
# RUN javac Sign.java
# CMD [ "java", "Sign" ]

# Use a base image with JDK 11 or 17 (depending on your setup)
FROM openjdk:11-jdk-slim

# Install Maven
RUN apt-get update && apt-get install -y maven

# Set the working directory
WORKDIR /app

# Copy the Maven project
COPY . .

# Package the application using Maven
RUN mvn clean package

# Set the entry point to run your Java class
CMD ["java", "-cp", "target/sample-app-1.0-SNAPSHOT.jar", "com.sspl.sample.filter.Signer"]
