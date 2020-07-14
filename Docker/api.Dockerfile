FROM openjdk:13-alpine
COPY target/ignant-nono-chortle-1.0-SNAPSHOT.jar /data/ignant-nono-chortle-1.0-SNAPSHOT.jar
COPY config.yml /data/config.yml