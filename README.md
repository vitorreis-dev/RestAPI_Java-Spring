# 📚 Book API

> RESTful API for managing books, users and authentication, developed with
> Java and Spring Boot.

This project was developed as a practical study of backend development,
focusing on REST APIs, Spring Security, JWT authentication, data validation,
DTOs, database migrations and containerization.

---

## 🚀 Features

- User registration and authentication
- JWT-based authentication
- Protected API endpoints with Spring Security
- Book CRUD operations
- Book and Theme relationship
- Request and Response DTOs
- DTO mapping with MapStruct
- Bean Validation
- Global exception handling
- Database versioning with Flyway
- OpenAPI / Swagger documentation

---

## 🛠️ Technologies

| Technology | Purpose |
|---|---|
| **Java** | Main programming language |
| **Spring Boot** | Backend framework |
| **Spring Security** | Authentication and authorization |
| **JWT** | Token-based authentication |
| **Spring Data JPA / Hibernate** | Data persistence |
| **PostgreSQL** | Relational database |
| **Flyway** | Database migrations |
| **MapStruct** | DTO mapping |
| **Bean Validation** | Data validation |
| **OpenAPI / Swagger** | API documentation |
| **Maven** | Dependency and build management |
| **Docker** | Application containerization |
| **Docker Compose** | Container orchestration |

---

## 📋 Prerequisites

Before running the project, make sure you have installed:

- Java
- Maven
- Docker
- Docker Compose
- PostgreSQL *(only required if running the database outside Docker)*

---

## 🚀 Getting Started

### 🔐 Environment Variables

Create a `.env` file containing the required environment variables:

```env
DB_URL=jdbc:postgresql://localhost:5432/database
DB_USERNAME=your_username
DB_PASSWORD=your_password
JWT_SECRET=your_secret
````

> ⚠️ The `.env` file contains sensitive information and must not be
> committed to the repository.

---

### 🐳 Running with Docker

Build and start the application:

```bash
docker compose up --build
```

To run the application in the background:

```bash
docker compose up -d --build
```

To stop the containers:

```bash
docker compose down
```

---

### ☕ Running with Maven

Build the application:

```bash
mvn clean package
```

Then run the generated JAR:

```bash
java -jar target/*.jar
```

The API will be available at:

```text
http://localhost:8080
```

---

## 📖 API Documentation

The API is documented using **OpenAPI / Swagger**.

### Swagger UI

```text
http://localhost:8080/docs
```

### OpenAPI Specification

```text
http://localhost:8080/api-docs
```

The Swagger interface is publicly accessible.

Protected endpoints require a valid JWT token, which can be provided through
Swagger's **Authorize** button.

---

## 🔐 Authentication

Authentication is implemented using **Spring Security** and **JWT**.

The authentication flow is:
```text
Register
   ↓
Login
   ↓
JWT Token
   ↓
Authorization Header
   ↓
Protected Endpoint
```

---

## 👤 User Authentication

### Register

```http
POST /api/v1/auth/register
```

**Example request:**

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

**Example request:**

```json
{
    "email": "user@email.com",
    "password": "password"
}
```

The login endpoint returns a JWT that can be used to access protected
resources.

---

## 📚 Books

The API provides endpoints for managing books.

| Method   | Endpoint             | Description             |
| -------- | -------------------- | ----------------------- |
| `GET`    | `/api/v1/books`      | Get all books           |
| `GET`    | `/api/v1/books/{id}` | Get a book by ID        |
| `POST`   | `/api/v1/books`      | Create a book           |
| `PATCH`  | `/api/v1/books/{id}` | Partially update a book |
| `DELETE` | `/api/v1/books/{id}` | Delete a book           |

### Example

```json
{
    "title": "The Hobbit",
    "author": "J.R.R. Tolkien",
    "year": 1937,
    "themeId": 1
}
```

A book is associated with a single theme through a `ManyToOne` relationship.

---

## 🏷️ Themes

Themes are stored as independent entities in the database.

```text
Theme
├── id
└── name
```

A book references a theme through its `theme_id`.

This approach allows themes to be managed independently instead of using
hard-coded Java enums.

---

## 👨‍💻 Author

### <a href="https://github.com/vitorreis-dev">Vitor Otavio dos Reis</a>
