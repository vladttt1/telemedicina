FROM  openjdk:19
MAINTAINER primforest


COPY target/dockerFile/telemedicina-0.0.1-SNAPSHOT.jar  telemedicina-0.0.1-SNAPSHOT.jar

EXPOSE 9099
ENTRYPOINT ["java","-jar","/telemedicina-0.0.1-SNAPSHOT.jar"]
