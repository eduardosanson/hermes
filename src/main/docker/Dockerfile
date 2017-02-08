FROM java:8
VOLUME /tmp
ADD *.war hermes.war
RUN sh -c 'touch /app.jar'
ENV JAVA_OPTS=""
ENTRYPOINT [ "java", "-jar","hermes.war" ]
