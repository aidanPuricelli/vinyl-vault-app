# Start with a base image that includes Java and Maven (you can choose a specific tag if needed)
FROM maven:3.8.4-openjdk-17 as build

# Create a directory for your application
WORKDIR /app

# Optionally, copy the Maven settings file if you have one
# COPY settings.xml /root/.m2/

# Copy the pom.xml file first to fetch dependencies
COPY pom.xml .

# Copy the source code
COPY src src

# Package the application
RUN mvn clean package -DskipTests

# Now start with a Java runtime image
FROM openjdk:17-slim

# Make a directory for your application
WORKDIR /app

# Copy the JAR file from the build stage
COPY --from=build /app/target/vinylvaultback*.jar /app/vinylvaultback.jar

# Expose the port the app runs on
EXPOSE 8080

# Run the JAR file
CMD ["java", "-jar", "/app/vinylvaultback.jar"]
