## car-challenge-kafka

[![Java17](https://img.shields.io/badge/devel-Java17-brightgreen)](https://docs.oracle.com/en/java/javase/17)
[![SpringBoot](https://img.shields.io/badge/framework-SpringBoot-brightgreen)](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle)
[![Docker](https://img.shields.io/badge/container-Docker-brightgreen)](https://www.docker.com)
[![Maven](https://img.shields.io/badge/dependency--manager-Maven-brightgreen)](https://maven.apache.org/guides)
[![MongoDB](https://img.shields.io/badge/database-MongoDb-brightgreen)](https://www.mongodb.com/pt-br)
[![MIT](https://img.shields.io/badge/license-MIT-brightgreen)](https://opensource.org/licenses/MIT)


## TL; DR

##### Documentação Swagger ->  [http://localhost:8080](http://localhost:8080)
##### Control Center ->  [http://localhost:9021](http://localhost:9021)
##### Repositório Github -> https://github.com/souluanf/car-challenge-kafka


## Framework e Bibliotecas
- **Java 17**: Develop
- **Spring Boot**: Framework;
- **Swagger(springfox, openapi)**: Para documentação.
- **Maven**: Para solução gerenciamento de dependencias.
- **Lombok**: Código clean.
- **Kafka (zookeeper,server,schema registry, control center)**: Mensageria.
- **Avro Schema**: Versionamento de schema.


### Execução

``` shell
docker-compose -f docker-compose.yml -p sistema-carros up -d 
```

#### Abra o terminal na pasta do projeto

```shell
mvn clean package -Dspring.profiles.active=test
mvn spring-boot:run
```

1. Aponte o browser para  [http://localhost:8080](http://localhost:8080) para ver a documentação.
   - Aqui é possível ver a documentação e gerar requisições.

2. Aponte para  [http://localhost:9021](http://localhost:9021) para utilizar o control center.
   - Aqui é possível ver o tópico e enviar mensagens. A partir da primeira mensagem enviada já é possível ver o schema registrado no control center.
