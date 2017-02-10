FROM java:8
RUN mkdir app
ADD *.jar app/mockSms.jar
ADD uaiMockServer.json app/uaiMockServer.json
WORKDIR /app
ENTRYPOINT [ "java", "-jar","mockSms.jar" ]
