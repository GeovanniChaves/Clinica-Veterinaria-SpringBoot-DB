# 🐶 Clínica Veterinária API

API REST para gerenciamento de uma clínica veterinária.
O projeto foi desenvolvido com **Java 21** e **Spring Boot**, cobrindo backend, API REST, persistência com **JPA/Hibernate** e **PostgreSQL**.

---

## 🚀 Tecnologias utilizadas

* Java 21
* Spring Boot 4.1.0
* Spring Web MVC
* Spring Data JPA
* Hibernate
* PostgreSQL
* Maven
* Postman (testes manuais dos endpoints)

Não há Swagger/OpenAPI, Spring Security nem camada `@Service` neste repositório.

---

## 📌 Funcionalidades

CRUD HTTP nas quatro entidades. Os controllers recebem e devolvem a **entidade JPA em JSON** (não DTO).

### 👤 Tutor

* Cadastro, listagem, busca por ID, atualização e exclusão

```text
POST   /tutores
GET    /tutores
GET    /tutores/{id}
PUT    /tutores/{id}
DELETE /tutores/{id}
```

### 🩺 Veterinário

* Cadastro, listagem, busca por ID, atualização e exclusão

```text
POST   /veterinarios
GET    /veterinarios
GET    /veterinarios/{id}
PUT    /veterinarios/{id}
DELETE /veterinarios/{id}
```

### 🐕 Pet

Cada pet referencia **um** tutor (`@ManyToOne`). No domínio: um tutor tem vários pets.

```text
POST   /pets
GET    /pets
GET    /pets/{id}
PUT    /pets/{id}
DELETE /pets/{id}
```

Exemplo de cadastro (o tutor `id` 1 precisa existir):

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

### 📅 Consulta

Cada consulta referencia **um** pet e **um** veterinário (`@ManyToOne` nos dois). Data (`LocalDate`) e descrição.

```text
POST   /consultas
GET    /consultas
GET    /consultas/{id}
PUT    /consultas/{id}
DELETE /consultas/{id}
```

Exemplo (pet e veterinário precisam existir):

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

Ordem típica de uso: tutor e veterinário → pet → consulta. Na exclusão, o inverso (consultas antes do pet, pets antes do tutor), por causa das chaves estrangeiras.

---

## 🗄️ Banco de dados

PostgreSQL. O banco `clinica_veterinaria` **é criado por você**. As **tabelas** são criadas/atualizadas pelo Hibernate (`spring.jpa.hibernate.ddl-auto=update`) a partir das entidades.

Entidades / tabelas: `Tutor` (`tutores`), `Veterinario` (`veterinarios`), `Pet` (`pets`), `Consulta` (`consultas`).

---

## 🏗️ Organização do código

```text
src/main/java/.../clinicaveterinaria
│
├── controller   → endpoints REST (@RestController)
├── model        → entidades JPA (@Entity)
├── repository   → JpaRepository (save, findAll, findById, deleteById)
└── dto          → PetDTO e Mensagem existem, mas nenhum endpoint usa essas classes
```

Fluxo atual: **Controller → Repository** (injeção pelo construtor). Não há pasta `service`.

---

## 🔗 Relacionamentos JPA

Mapeamento **unidirecional** `@ManyToOne` (o lado que tem a FK). Não há `@OneToMany` nas classes.

### Pet → Tutor

```java
@ManyToOne
private Tutor tutor;
```

### Consulta → Pet e Veterinário

```java
@ManyToOne
private Pet pet;

@ManyToOne
private Veterinario veterinario;
```

---

## ▶️ Como executar

**Pré-requisitos:** Java 21, PostgreSQL, Maven.

1. Crie o banco `clinica_veterinaria`.
2. Ajuste `clinica-veterinaria/src/main/resources/application.properties` (usuário e senha).

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/clinica_veterinaria
spring.datasource.username=postgres
spring.datasource.password=SUA_SENHA

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

3. Na pasta `clinica-veterinaria`:

```bash
mvn spring-boot:run
```

API em `http://localhost:8080`.

---

## 🧪 Testes

* **Manuais:** Postman — POST/GET/PUT/DELETE e cadastro respeitando as FKs (tutor antes do pet, etc.).
* **Automatizados:** apenas `ClinicaVeterinariaApplicationTests.contextLoads()` (sobe o contexto Spring). Não há testes de endpoint no repositório.

O starter de Bean Validation está no `pom.xml`, mas as entidades **não** usam `@NotBlank` / `@Valid`.

---

## 📚 Conceitos aplicados

API REST, CRUD, métodos HTTP, JSON, Spring Boot, injeção de dependência, Spring Data JPA, Hibernate, entidades, `@ManyToOne`, PostgreSQL, Maven, organização por pacotes.

---

## 🎯 Objetivo

Praticar backend Java/Spring Boot com uma API REST ligada ao PostgreSQL, no formato de um sistema de clínica veterinária.

---

## 👨‍💻 Autor

**Geovanni Chaves**
Desenvolvedor Java Backend Júnior
