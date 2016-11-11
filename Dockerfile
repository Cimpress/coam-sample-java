FROM openjdk:7
COPY target /usr/src/myapp
WORKDIR /usr/src/myapp
# RUN javac HelloWorld.java
CMD ["java", "-cp", "sample-app-1.0-SNAPSHOT.jar", "com.cimpress.sampleapp.App"]
