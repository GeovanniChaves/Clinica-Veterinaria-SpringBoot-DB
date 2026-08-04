# 🐶 Clínica Veterinária API

API REST desenvolvida para gerenciamento de uma clínica veterinária.

O projeto foi desenvolvido utilizando Java com Spring Boot, aplicando conceitos de desenvolvimento backend, criação de APIs REST, persistência de dados com JPA/Hibernate e banco de dados relacional PostgreSQL.

---

# 🚀 Tecnologias utilizadas

- Java 21
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- PostgreSQL
- Maven
- Postman
- Swagger/OpenAPI

---

# 📌 Funcionalidades

## 👤 Tutor

Gerenciamento dos tutores dos animais.

Funcionalidades:

- Cadastro de tutores
- Listagem de tutores
- Busca de tutor por ID
- Atualização de dados
- Exclusão de tutores

Endpoints:


POST /tutores
GET /tutores
GET /tutores/{id}
PUT /tutores/{id}
DELETE /tutores/{id}


---

## 🩺 Veterinário

Gerenciamento dos profissionais da clínica.

Funcionalidades:

- Cadastro de veterinários
- Listagem de veterinários
- Busca por ID
- Atualização de dados
- Exclusão de veterinários

Endpoints:


POST /veterinarios
GET /veterinarios
GET /veterinarios/{id}
PUT /veterinarios/{id}
DELETE /veterinarios/{id}


---

## 🐕 Pet

Gerenciamento dos animais cadastrados.

Cada pet possui um tutor responsável.

Relacionamento:


Tutor 1 -------- N Pets


Funcionalidades:

- Cadastro de pets
- Listagem de pets
- Busca por ID
- Atualização de dados
- Exclusão de pets

Endpoints:


POST /pets
GET /pets
GET /pets/{id}
PUT /pets/{id}
DELETE /pets/{id}


Exemplo de cadastro:

json
{
    "nome": "Rex",
    "especie": "Cachorro",
    "idade": 5,
    "tutor": {
        "id": 1
    }
}
📅 Consulta

Gerenciamento das consultas realizadas na clínica.

Uma consulta possui:

Um pet
Um veterinário
Data
Descrição

Relacionamentos:

Pet 1 -------- N Consultas

Veterinário 1 -------- N Consultas

Funcionalidades:

Cadastro de consultas
Listagem de consultas
Busca por ID
Atualização
Exclusão

Endpoints:

POST   /consultas
GET    /consultas
GET    /consultas/{id}
PUT    /consultas/{id}
DELETE /consultas/{id}

Exemplo:

{
    "data": "2026-08-04",
    "descricao": "Consulta de rotina",
    "pet": {
        "id": 1
    },
    "veterinario": {
        "id": 1
    }
}
🗄️ Banco de Dados

Banco utilizado:

PostgreSQL

O gerenciamento das tabelas é realizado automaticamente pelo Hibernate através das entidades JPA.

Principais entidades:

Tutor
Veterinario
Pet
Consulta
🏗️ Arquitetura do projeto

O projeto segue uma organização baseada em camadas:

src/main/java

├── controller
│   └── Responsável pelos endpoints da API
│
├── model
│   └── Entidades que representam as tabelas do banco
│
├── repository
│   └── Comunicação com o banco utilizando JPA
│
└── dto
    └── Objetos de transferência de dados
🔗 Relacionamentos JPA
Tutor e Pet

Um tutor pode possuir vários pets.

Implementação:

@ManyToOne
private Tutor tutor;
Pet e Consulta

Um pet pode possuir várias consultas.

Veterinário e Consulta

Um veterinário pode realizar várias consultas.

▶️ Como executar o projeto
Pré-requisitos
Java 21 instalado
PostgreSQL instalado
Maven instalado
Configuração do banco

Alterar o arquivo:

src/main/resources/application.properties

Exemplo:

spring.datasource.url=jdbc:postgresql://localhost:5432/clinica_veterinaria
spring.datasource.username=postgres
spring.datasource.password=SUA_SENHA

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
Executar aplicação

No terminal:

mvn spring-boot:run

A aplicação será iniciada em:

http://localhost:8080
📖 Documentação da API

A documentação dos endpoints está disponível utilizando Swagger/OpenAPI.

Após configurar o Swagger, acessar:

http://localhost:8080/swagger-ui/index.html

O Swagger permite visualizar e testar todos os endpoints diretamente pelo navegador.

🧪 Testes

Os endpoints foram testados utilizando:

Postman

Operações realizadas:

Criação de registros
Consulta de dados
Atualização
Exclusão
Validação dos relacionamentos entre entidades
📚 Conceitos aplicados

Durante o desenvolvimento foram utilizados:

API REST
CRUD completo
Spring Boot
Injeção de dependência
Spring Data JPA
Hibernate ORM
Entidades JPA
Relacionamentos entre tabelas
Persistência em banco relacional
JSON
HTTP Methods

👨‍💻 Autor

Geovanni Chaves

📌 Objetivo do projeto

Projeto desenvolvido com objetivo de aplicar conhecimentos de desenvolvimento backend utilizando Java e Spring Boot, simulando uma aplicação real de gerenciamento de uma clínica veterinária.
