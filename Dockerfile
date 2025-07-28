FROM --platform=linux/amd64 amazoncorretto:21
COPY target/backend-0.0.1.jar backend-0.0.1.jar
EXPOSE 8080
ENTRYPOINT [ "java","-jar","/backend-0.0.1.jar" ]
