# 🐶 Clínica Veterinária API

API REST desenvolvida para gerenciamento de uma clínica veterinária.

O projeto foi desenvolvido utilizando **Java 21 e Spring Boot**, aplicando conceitos de desenvolvimento backend, criação de APIs REST, persistência de dados com **JPA/Hibernate** e banco de dados relacional **PostgreSQL**.

---

## 🚀 Tecnologias utilizadas

* Java 21
* Spring Boot
* Spring Web
* Spring Data JPA
* Hibernate
* PostgreSQL
* Maven
* Postman

---

## 📌 Funcionalidades

### 👤 Tutor

Gerenciamento dos tutores dos animais.

**Funcionalidades:**

* Cadastro de tutores
* Listagem de tutores
* Busca de tutor por ID
* Atualização de dados
* Exclusão de tutores

**Endpoints:**

```text
POST   /tutores
GET    /tutores
GET    /tutores/{id}
PUT    /tutores/{id}
DELETE /tutores/{id}
```

---

### 🩺 Veterinário

Gerenciamento dos profissionais da clínica.

**Funcionalidades:**

* Cadastro de veterinários
* Listagem de veterinários
* Busca por ID
* Atualização de dados
* Exclusão de veterinários

**Endpoints:**

```text
POST   /veterinarios
GET    /veterinarios
GET    /veterinarios/{id}
PUT    /veterinarios/{id}
DELETE /veterinarios/{id}
```

---

### 🐕 Pet

Gerenciamento dos animais cadastrados.

Cada pet possui um tutor responsável.

**Relacionamento:**

```text
Tutor 1 -------- N Pets
```

**Funcionalidades:**

* Cadastro de pets
* Listagem de pets
* Busca de pet por ID
* Atualização de dados
* Exclusão de pets

**Endpoints:**

```text
POST   /pets
GET    /pets
GET    /pets/{id}
PUT    /pets/{id}
DELETE /pets/{id}
```

**Exemplo de cadastro:**

```json
{
    "nome": "Rex",
    "especie": "Cachorro",
    "idade": 5,
    "tutor": {
        "id": 1
    }
}
```

---

### 📅 Consulta

Gerenciamento das consultas realizadas na clínica.

Uma consulta possui:

* Pet
* Veterinário
* Data
* Descrição

**Relacionamentos:**

```text
Pet 1 -------- N Consultas

Veterinário 1 -------- N Consultas
```

**Funcionalidades:**

* Cadastro de consultas
* Listagem de consultas
* Busca de consulta por ID
* Atualização de consultas
* Exclusão de consultas

**Endpoints:**

```text
POST   /consultas
GET    /consultas
GET    /consultas/{id}
PUT    /consultas/{id}
DELETE /consultas/{id}
```

**Exemplo de cadastro:**

```json
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
```

---

## 🗄️ Banco de Dados

O projeto utiliza **PostgreSQL** como banco de dados relacional.

O gerenciamento das tabelas é realizado pelo **Hibernate**, utilizando as entidades JPA.

### Principais entidades

* Tutor
* Veterinário
* Pet
* Consulta

---

## 🏗️ Arquitetura do projeto

O projeto segue uma organização baseada em camadas:

```text
src/main/java
│
├── controller
│   └── Responsável pelos endpoints da API
│
├── model
│   └── Entidades que representam os dados do sistema
│
├── repository
│   └── Comunicação com o banco de dados utilizando JPA
│
└── dto
    └── Objetos utilizados para transferência de dados
```

---

## 🔗 Relacionamentos JPA

### Tutor e Pet

Um tutor pode possuir vários pets.

```java
@ManyToOne
private Tutor tutor;
```

### Pet e Consulta

Um pet pode possuir várias consultas.

### Veterinário e Consulta

Um veterinário pode realizar várias consultas.

---

## ▶️ Como executar o projeto

### Pré-requisitos

* Java 21 instalado
* PostgreSQL instalado
* Maven instalado

### Configuração do banco

Crie um banco de dados chamado:

```text
clinica_veterinaria
```

Depois, altere o arquivo:

```text
src/main/resources/application.properties
```

Exemplo:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/clinica_veterinaria
spring.datasource.username=postgres
spring.datasource.password=SUA_SENHA

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

### Executar a aplicação

No terminal:

```bash
mvn spring-boot:run
```

A aplicação será iniciada em:

```text
http://localhost:8080
```

---

## 🧪 Testes

Os endpoints da API foram testados utilizando **Postman**.

Foram realizadas operações de:

* Criação de registros
* Consulta de dados
* Atualização
* Exclusão
* Validação dos relacionamentos entre as entidades

---

## 📚 Conceitos aplicados

Durante o desenvolvimento foram utilizados conceitos de:

* API REST
* CRUD
* Spring Boot
* Injeção de dependência
* Spring Data JPA
* Hibernate ORM
* Entidades JPA
* Relacionamentos entre entidades
* Persistência em banco de dados relacional
* JSON
* Métodos HTTP
* Organização de projeto em camadas
* Maven

---

## 🎯 Objetivo do projeto

Projeto desenvolvido com o objetivo de aplicar conhecimentos de **desenvolvimento backend utilizando Java e Spring Boot**, simulando uma aplicação real de gerenciamento de uma clínica veterinária.

O projeto também teve como objetivo praticar a integração entre uma API REST, banco de dados PostgreSQL e as tecnologias do ecossistema Spring.

---

## 👨‍💻 Autor

**Geovanni Chaves**

Desenvolvedor Java Backend Júnior
