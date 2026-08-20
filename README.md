# 📚 Book REST API - Spring Boot

> RestAPI para gerenciamento de livros, usuários e autenticação, desenvolvida com Java e Spring Boot.

Este projeto foi desenvolvido como um estudo prático de desenvolvimento backend, com foco na construção de APIs REST, Spring Security, autenticação com JWT, validação de dados, DTOs, migrações de banco de dados e containerização.

---

## 🚀 Funcionalidades

* Cadastro e autenticação de usuários
* Autenticação baseada em JWT
* Proteção de endpoints com Spring Security
* Operações CRUD de livros
* Relacionamento entre livros e temas
* DTOs de requisição e resposta
* Mapeamento de DTOs com MapStruct
* Validação de dados com Bean Validation
* Tratamento global de exceções
* Versionamento do banco de dados com Flyway
* Documentação da API com OpenAPI / Swagger

---

## 🛠️ Tecnologias

| Tecnologia                      | Finalidade                            |
| ------------------------------- | ------------------------------------- |
| **Java**                        | Linguagem principal                   |
| **Spring Boot**                 | Framework backend                     |
| **Spring Security**             | Autenticação e autorização            |
| **JWT**                         | Autenticação baseada em tokens        |
| **Spring Data JPA / Hibernate** | Persistência de dados                 |
| **PostgreSQL**                  | Banco de dados relacional             |
| **Flyway**                      | Migrações e versionamento do banco    |
| **MapStruct**                   | Mapeamento entre DTOs e entidades     |
| **Bean Validation**             | Validação de dados                    |
| **OpenAPI / Swagger**           | Documentação da API                   |
| **Maven**                       | Gerenciamento de dependências e build |
| **Docker**                      | Containerização da aplicação          |
| **Docker Compose**              | Orquestração dos containers           |

---

## 📋 Pré-requisitos

Antes de executar o projeto, certifique-se de ter instalado:

* Java
* Maven
* Docker
* Docker Compose
* PostgreSQL *(necessário apenas caso o banco seja executado fora do Docker)*

---

## 🚀 Como executar

### 🔐 Variáveis de ambiente

Crie um arquivo `.env` contendo as variáveis de ambiente necessárias:

```env
DB_URL=jdbc:postgresql://localhost:5432/database
DB_USERNAME=your_username
DB_PASSWORD=your_password
JWT_SECRET=your_secret
```

> ⚠️ O arquivo `.env` contém informações sensíveis e não deve ser enviado para o repositório.

---

### 🐳 Executando com Docker

Para construir as imagens e iniciar a aplicação:

```bash
docker compose up --build
```

Para executar os containers em segundo plano:

```bash
docker compose up -d --build
```

Para parar os containers:

```bash
docker compose down
```

---

### ☕ Executando com Maven

Para compilar e empacotar a aplicação:

```bash
mvn clean package
```

Em seguida, execute o arquivo JAR gerado:

```bash
java -jar target/*.jar
```

A API estará disponível em:

```text
http://localhost:8080
```

---

## 📖 Documentação da API

A API é documentada utilizando **OpenAPI / Swagger**.

### Swagger UI

```text
http://localhost:8080/docs
```

### Especificação OpenAPI

```text
http://localhost:8080/api-docs
```

A interface do Swagger está disponível publicamente.

Os endpoints protegidos exigem um token JWT válido, que pode ser informado através do botão **Authorize** do Swagger.

---

## 🔐 Autenticação

A autenticação é implementada utilizando **Spring Security** e **JWT**.

O fluxo de autenticação funciona da seguinte maneira:

```text
Cadastro
   ↓
Login
   ↓
Token JWT
   ↓
Authorization Header
   ↓
Endpoint protegido
```

---

## 👤 Autenticação de usuários

### Cadastro

```http
POST /api/v1/auth/register
```

**Exemplo de requisição:**

```json
{
    "username": "user",
    "email": "user@email.com",
    "password": "password"
}
```

### Login

```http
POST /api/v1/auth/login
```

**Exemplo de requisição:**

```json
{
    "email": "user@email.com",
    "password": "password"
}
```

O endpoint de login retorna um JWT que pode ser utilizado para acessar os recursos protegidos da API.

---

## 📚 Livros

A API fornece endpoints para gerenciamento de livros.

| Método   | Endpoint             | Descrição                      |
| -------- | -------------------- | ------------------------------ |
| `GET`    | `/api/v1/books`      | Lista todos os livros          |
| `GET`    | `/api/v1/books/{id}` | Busca um livro pelo ID         |
| `POST`   | `/api/v1/books`      | Cria um novo livro             |
| `PATCH`  | `/api/v1/books/{id}` | Atualiza parcialmente um livro |
| `DELETE` | `/api/v1/books/{id}` | Remove um livro                |

### Exemplo

```json
{
    "title": "The Hobbit",
    "author": "J.R.R. Tolkien",
    "year": 1937,
    "themeId": 1
}
```

Um livro está associado a um único tema através de um relacionamento `ManyToOne`.

---

## 👤 Pessoas

A API disponibiliza endpoints para gerenciamento de pessoas.

| Método   | Endpoint       | Descrição                           |
| -------- | -------------- | ----------------------------------- |
| `GET`    | `/person`      | Retorna todas as pessoas            |
| `GET`    | `/person/{id}` | Retorna uma pessoa pelo ID          |
| `PUT`    | `/person/{id}` | Atualiza os dados de uma pessoa     |
| `DELETE` | `/person/{id}` | Exclui uma pessoa pelo ID           |
| `DELETE` | `/person`      | Exclui todas as pessoas cadastradas |

---

## 👋 Greeting

A API também disponibiliza um endpoint simples para teste da aplicação.

| Método | Endpoint | Descrição                        |
| ------ | -------- | -------------------------------- |
| `GET`  | `/`      | Retorna uma mensagem de saudação |

---

## 🏷️ Temas

Os temas são armazenados como entidades independentes no banco de dados.

```text
Theme
├── id
└── name
```

Um livro referencia um tema através da coluna `theme_id`.

Essa abordagem permite que os temas sejam gerenciados de forma independente, em vez de serem definidos como enums fixos na aplicação.

---

## 👨‍💻 Autor

### <a href="https://github.com/vitorreis-dev">Vitor Otavio dos Reis</a>
