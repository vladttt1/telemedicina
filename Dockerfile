FROM openjdk:19
COPY ./out/production/Dockertelemedicina/ /tmp
WORKDIR /tmp
ENTRYPOINT ["java","telemedicina"]