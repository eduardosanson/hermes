FROM java:8
ADD *.war Hermes.war
RUN sh -c 'touch /Hermes.jar'
ENTRYPOINT [ "java", "-jar","Hermes.war" ]
