FROM openjdk:17
COPY target/fashion-blog-API-0.0.1-SNAPSHOT.jar fashion-blog-api.jar
ENTRYPOINT ["java", "-jar", "fashion-blog-api.jar"]
EXPOSE 8080