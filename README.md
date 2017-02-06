# Hermes

Projeto Responsável por encaminhar mensagens sms de acordo com os eventos ocorridos

## Getting Started

1- Baixe o projeto
2- Execute docker  da infra do sitema  na pasta: /docker/
   Ex: excute o comando  - docker-compose up -d
3- inicie o mock na pasta: /mock
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

teste integrado:

antes de iniciar a aplicação verificar os dados mestres que serão criados
localizados na pasta resouces/db


## Deployment

Para iniciar o projeto basta executar o comando mvn spring-boot:run
ou executar mvn clean install e após concluir o build execute o comando
na pasta /target java -jar hermes<version>.war

## Built With

* [Docker](https://dockercon.smarteventscloud.com/portal/newreg.ww) - Container par a infra do sistema
* [Maven](https://maven.apache.org/) - Dependency Management

## Authors

* **Eduardo Sanson** 
