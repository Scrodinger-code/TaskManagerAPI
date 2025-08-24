# 📌 TaskManagerAPI

A simple **Task Manager REST API** built with **Java 17**, **Spring Boot 3**, and **PostgreSQL**.  
The project demonstrates clean architecture, Dockerized deployment, and interactive API documentation via Swagger.

---

## ✨ Features

- ✅ Full CRUD for tasks (Create, Read, Update, Delete)
- ✅ PostgreSQL database integration with Spring Data JPA
- ✅ Swagger UI for API exploration and testing
- ✅ Dockerized setup with `docker-compose` (App + PostgreSQL + Adminer)
- ✅ Clean service & repository layer separation
- ✅ Ready for extension with new entities and features

---

## 🛠️ Tech Stack

**Languages & Runtime**
- Java 17
- Gradle 8.x

**Frameworks**
- Spring Boot 3
- Spring Data JPA
- Hibernate ORM

**Databases**
- PostgreSQL 15
- Adminer (DB UI)

**Tools**
- Docker, Docker Compose
- Swagger / OpenAPI 3
- IntelliJ IDEA

---

## 📂 Project Structure

```
TaskManagerAPI
 ┣ 📂 src
 ┃ ┣ 📂 main
 ┃ ┃ ┣ 📂 java/org/example/taskmanagerapi
 ┃ ┃ ┃ ┣ 📂 controller    # REST Controllers
 ┃ ┃ ┃ ┣ 📂 model         # Entities (JPA)
 ┃ ┃ ┃ ┣ 📂 repository    # Spring Data Repositories
 ┃ ┃ ┃ ┣ 📂 service       # Business logic
 ┃ ┃ ┃ ┗ TaskManagerApiApplication.java
 ┃ ┃ ┗ 📂 resources
 ┃ ┗ 📂 test              # Unit & Integration tests
 ┣ 📂 docker              # Dockerfile & docker-compose.yml
 ┣ build.gradle
 ┗ README.md
```

---

## 🚀 Getting Started

### 1. Clone repository
```bash
  git clone https://github.com/Scrodinger-code/TaskManagerAPI.git
  cd TaskManagerAPI
```

### 2. Run with Docker
```bash
  cd docker
  docker-compose up -d --build
```

- Backend: [http://localhost:2030](http://localhost:2030)
- Swagger UI: [http://localhost:2030/swagger-ui.html](http://localhost:2030/swagger-ui.html)
- Adminer (DB UI): [http://localhost:8081](http://localhost:8081)

Login to Adminer:
- **System**: PostgreSQL
- **Server**: db
- **User**: `taskuser`
- **Password**: `taskpass`
- **Database**: `taskdb`

---

## 📖 API Endpoints

| Method | Endpoint        | Description              |
|--------|----------------|--------------------------|
| GET    | `/tasks`       | Get all tasks           |
| GET    | `/tasks/{id}`  | Get task by ID          |
| POST   | `/tasks`       | Create a new task       |
| PUT    | `/tasks/{id}`  | Update a task by ID     |
| DELETE | `/tasks/{id}`  | Delete a task by ID     |

Swagger docs available at:  
👉 [http://localhost:2030/swagger-ui.html](http://localhost:2030/swagger-ui.html)

---

## 🧪 Tests

Run unit & integration tests:
```bash
  ./gradlew test
```

---

## 📌 Future Improvements
- 🔒 Add user authentication (Spring Security + JWT)
- 📑 Add DTOs + ModelMapper for cleaner API responses
- 🧰 Add CI/CD pipeline with GitHub Actions
- ☁️ Deploy to cloud (AWS / GCP / Azure / Fly.io)

---

## 👨‍💻 Author
**German Alexandrovich**  
📌 Backend Software Developer (Java | Python | PHP)  
🌍 [LinkedIn Profile](www.linkedin.com/in/german-k-b5433b380)

---
