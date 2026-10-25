# Student CRUD REST API – Spring Boot

A simple **Spring Boot** backend application that demonstrates full **CRUD (Create, Read, Update, Delete)** operations on a `Student` entity. It also includes a **soft‑delete** feature, allowing records to be marked as deleted without being permanently removed from the database.

The project follows a standard layered architecture (Controller → Service → Repository → Entity) and uses **Spring Data JPA** with a **MySQL** database.

---

## 📌 Features

- **Create** a new student record.
- **Read** a single student by ID or retrieve all students.
- **Update** an existing student's details.
- **Delete** a student permanently.
- **Soft‑delete** a student (sets a `deleted` flag to `true` while keeping the row in the database).
- RESTful endpoints with meaningful HTTP status codes (201 for creation, 404 for not found, etc.).

---

## 🛠️ Tech Stack

| Technology | Version / Details |
|------------|-------------------|
| **Java** | 21 |
| **Spring Boot** | 4.1.1 (Spring Boot Starter Parent) |
| **Spring Web MVC** | For building REST APIs |
| **Spring Data JPA** | For database access |
| **Hibernate** | JPA implementation |
| **MySQL** | Relational database |
| **Maven** | Build tool (wrapper included) |
| **Lombok** | Not used – getters/setters are written manually |

> The `pom.xml` shows dependencies for `spring-boot-starter-data-jpa`, `spring-boot-starter-webmvc`, and the MySQL connector.

---

The controller, entity, repository, and service packages are clearly separated, following a typical Spring Boot layered pattern.

---

## 🧑‍🎓 Entity: `Student`

The `Student` entity contains the following fields:

- `id` (Long, auto‑generated)
- `name` (String)
- `age` (int)
- `rollNo` (int)
- `email` (String)
- `subject` (String)
- `deleted` (boolean) – used for soft‑delete logic

The `id` is generated using `GenerationType.IDENTITY` and the class is annotated with `@Entity` for JPA mapping.

---


| HTTP Method | Endpoint | Description | Request Params / Body |
|-------------|----------|-------------|------------------------|
| **POST** | `/api/students/create` | Create a new student | **Body:** JSON of `Student` object |
| **GET** | `/api/students/get` | Get a student by ID | `?id={id}` |
| **GET** | `/api/students/getAll` | Get all students | – |
| **PUT** | `/api/students/update` | Update an existing student | `?id={id}` + **Body:** updated `Student` JSON |
| **DELETE** | `/api/students/delete` | Permanently delete a student | `?id={id}` |
| **PATCH** | `/api/students/soft-delete` | Soft‑delete a student (marks as deleted) | `?id={id}` |

All endpoints return appropriate `ResponseEntity` objects, including `404 Not Found` when the requested student does not exist.

---

## 🗄️ Database Configuration

The application connects to a **MySQL** database named `student_crud_db`. The connection settings are defined in `src/main/resources/application.properties`:

```properties
spring.application.name=CrudSpringbootDemo
spring.datasource.url = jdbc:mysql://localhost:3306/student_crud_db
spring.datasource.username = root
spring.datasource.password = 1234
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql = true
| HTTP Method | Endpoint | Description | Request Params / Body |
|-------------|----------|-------------|------------------------|
| **POST** | `/api/students/create` | Create a new student | **Body:** JSON of `Student` object |
| **GET** | `/api/students/get` | Get a student by ID | `?id={id}` |
| **GET** | `/api/students/getAll` | Get all students | – |
| **PUT** | `/api/students/update` | Update an existing student | `?id={id}` + **Body:** updated `Student` JSON |
| **DELETE** | `/api/students/delete` | Permanently delete a student | `?id={id}` |
| **PATCH** | `/api/students/soft-delete` | Soft‑delete a student (marks as deleted) | `?id={id}` |

All endpoints return appropriate `ResponseEntity` objects, including `404 Not Found` when the requested student does not exist.

---

## 🗄️ Database Configuration

The application connects to a **MySQL** database named `student_crud_db`. The connection settings are defined in `src/main/resources/application.properties`:

```properties
spring.application.name=CrudSpringbootDemo
spring.datasource.url = jdbc:mysql://localhost:3306/student_crud_db
spring.datasource.username = root
spring.datasource.password = 1234
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql = true

