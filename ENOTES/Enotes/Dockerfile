# Use a lightweight Java image
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file into the container
COPY target/Enotes-0.0.1-SNAPSHOT.jar app.jar

# Expose the application port (change if your app uses another port)
EXPOSE 8080

# Command to run the JAR
ENTRYPOINT ["java", "-jar", "app.jar"]
