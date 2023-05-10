FROM  openjdk:19

ARG WAR_FILE=target/telemedicina-0.0.1-SNAPSHOT.war

COPY ${WAR_FILE} telemedicina.war
EXPOSE 9090
CMD["java","-war","telemedicina.war"]