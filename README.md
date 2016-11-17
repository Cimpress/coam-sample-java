# IAM Sample Client in Java

## Prerequisite

- Docker

or

- JDK
- Maven

In addition to the aforementioned development dependencies, you will need the following:

- Client ID / Secret
- Client authorized to access api.cimpress.io
- Permissions configured in IAM

## Getting started

Create a `config.properties` file with `CLIENT_ID` and `CLIENT_SECRET` in the repo directory:

```
$ cat > config.properties <<EOF
CLIENT_ID=<client-id>
CLIENT_SECRET=<client-secret>
EOF
```

Compile the code:

```
$ docker run -it --rm --name my-maven-project -v "$PWD":/usr/src/sampleapp -w /usr/src/sampleapp maven:3.2-jdk-7 mvn package
```

Build the docker image:

```
$ docker build -t sample-app .
```

Run the docker image:

```
$ docker run --rm --name sample-app sample-app
```
