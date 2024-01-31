# Projeto Web Services com Spring Boot e JPA / Hibernate

Este projeto é parte do curso de Java com Spring Boot ministrado pelo professor Nélio Alves, sendo um sistema de gestão de compras e pedidos. As principais entidades são User, Order e Product, com funcionalidades de CRUD (Create, Read, Update, Delete) e consultas específicas para manipulação de dados no banco de dados H2.

## Tecnologias Utilizadas

- Java 21
- Spring Boot
- JPA / Hibernate
- Maven
- Banco de dados H2
- Postman

## Objetivos

- Implementar modelo de domínio
- Estruturar camadas lógicas: resource, service, repository
- Configurar banco de dados de teste (H2)
- Povoar o banco de dados
- CRUD - Create, Retrieve, Update, Delete
- Tratamento de exceções

## Checklist da Entidade

- Atributos básicos
- Associações (instância de coleções)
- Construtores
- Getters & Setters (coleções: apenas get)
- hashCode & equals
- Serializable

## Como Utilizar

1. Clone o projeto para sua IDE preferida.
2. Execute o projeto Spring Boot.
3. Importe a collection para o Postman através do arquivo `course/CourseApplication.postman_collection.json`.
4. Utilize as rotas fornecidas para realizar requisições ao sistema.

