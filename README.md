# Products-ms

Este projeto foi feito para o teste da CompassoUOL.

## Descrição

Projeto em Gradle, um microserviço que permite a criação e manutenção de uma lista de produtos usando o endpoint listado abaixo, 
é possível acessar a documentação completa da API através do endereço do Swagger-ui:

endpoint: http://localhost:9999/products
swagger: http://localhost:9999/swagger-ui.html

Utiliza as seguintes tecnologias:

- [Java 11][java 11]
- [Springboot][springboot]
- [SwaggerUi][swaggerUi]
- [H2 Database][H2 Database]
    

## Construir/Executar

_Construir:_

projeto:

`./gradlew build` para compilar e criar o arquivo jar.

_Executar:_

`./gradlew bootRun`


[java11]: https://docs.oracle.com/en/java/javase/11/
[springboot]: https://spring.io/projects/spring-boot/
[swaggerUi]: https://swagger.io/docs/specification/2-0/basic-structure/
[H2 Database]: http://www.h2database.com/html/tutorial.html
