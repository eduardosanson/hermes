# Hermes

Projeto Responsável por encaminhar mensagens sms de acordo com os eventos ocorridos

## Getting Started

1- Baixe o projeto
2- Execute docker do mongoDB na pasta: /docker/mongoDB
   Ex:
3- Execute docker do rabbitMQ na pasta: /docker/rabbitMQ
   Ex:
4- inicie o mock na pasta: /mock
 ex: java -jar uaiMockServer-1.1.2.Standalone.jar

### Prerequisites

MongoDB instalado e rodando ou executar o docker como no passo anterior
RabbitMQ instalado e rodando ou executar o docker como no passo anterior
O mock deve estar rodando para que o fluxo de sucesso seja concluído
no arquivo uaiMockServer.json tem os numeros configurados com os devidos
status code de acordo com o teste desejado 
Ex: "path": "/sms/5521985003853",......
         "response": {
        "statusCode": 200

## Running the tests

Execute o comando mvn install no diretório raiz

## Deployment

Para iniciar o projeto basta executar o comando mvn spring-boot:run
ou executar mvn clean install e após concluir o build execute o comando
na pasta /target java -jar hermes<version>.war

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Authors

* **Eduardo Sanson** 
