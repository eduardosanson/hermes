FROM java:8
RUN mkdir app
ADD *.jar mockSms.jar
ADD uaiMockServer.json uaiMockServer.json
ENTRYPOINT [ "java", "-jar","mockSms.jar" ]