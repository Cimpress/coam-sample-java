FROM openjdk:7
COPY target /usr/src/myapp
COPY config.properties /usr/src/myapp 
WORKDIR /usr/src/myapp
# RUN javac HelloWorld.java
CMD ["java", "-jar", "sample-app-1.0-SNAPSHOT.jar"]
