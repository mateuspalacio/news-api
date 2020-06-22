FROM openjdk:11-jre
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]


# Use the standard Nginx image from Docker Hub
FROM nginx

# Copy custom configuration file from the current directory
COPY nginx.conf /nginx.conf



# Start Nginx when the container has provisioned.
CMD ["nginx", "-g", "daemon off;"]



