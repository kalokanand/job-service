FROM openjdk:17-oracle

COPY ./build/libs/*.jar /usr/local/lib/job-service.jar

CMD [ "java", "-jar", "/usr/local/lib/job-service.jar" ]