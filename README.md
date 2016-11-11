# IAM Sample Client in java

## Prerequisite

- Docker
-

## Getting started

Compile the code:

```
$ docker run -it --rm --name my-maven-project -v "$PWD":/usr/src/sampleapp -w /usr/src/sampleapp maven:3.2-jdk-7 mvn package
```

Build the docker image for the application:

```
$ docker build -t sample-app .
```

Run the docker image:

```
$ docker run --rm --name sample-app sample-app
```
