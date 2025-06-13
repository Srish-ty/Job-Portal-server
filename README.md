
# 🧠 Job Portal Backend

A Spring Boot-based RESTful backend for a simple Job Portal. Users can register, log in, view jobs, and apply. Companies can post jobs. All data is stored using JPA with an H2 in-memory database.

---

## 🚀 Features

- User registration and login (email + password)
- Company creation and job posting
- Users can apply to jobs
- REST APIs using Spring Web
- ORM with Spring Data JPA
- In-memory H2 database
- Lombok for boilerplate-free models

---

## 🗂️ Project Structure

```
job-portal/
├── controller/
├── model/
├── repository/
├── service/
├── config/
└── JobPortalApplication.java
```

---

## 🧾 Entity Schemas

### 👤 1. `User`

| Field       | Type    | Description                  |
|-------------|---------|------------------------------|
| id          | Long    | Primary key                  |
| name        | String  | User's full name             |
| email       | String  | User email (unique)          |
| password    | String  | Hashed password              |
| resumeLink  | String  | Link to resume               |
| applications| List    | Applications by this user    |

---

### 🏢 2. `Company`

| Field     | Type    | Description                  |
|-----------|---------|------------------------------|
| id        | Long    | Primary key                  |
| name      | String  | Company name                 |
| website   | String  | Website URL                  |
| jobs      | List    | Jobs posted by the company   |

---

### 📄 3. `Job`

| Field       | Type     | Description                 |
|-------------|----------|-----------------------------|
| id          | Long     | Primary key                 |
| title       | String   | Job title                   |
| description | String   | Job description             |
| location    | String   | Job location                |
| postedAt    | DateTime | When job was posted         |
| company     | Company  | Reference to the company    |

---

### 📬 4. `Application`

| Field     | Type     | Description                 |
|-----------|----------|-----------------------------|
| id        | Long     | Primary key                 |
| appliedAt | DateTime | Timestamp of application    |
| user      | User     | Reference to applying user  |
| job       | Job      | Reference to the job        |

---

## 🔧 Technologies Used

- Java 21
- Spring Boot
- Spring Data JPA
- H2 Database
- Lombok
- Postman (for testing)

---

## 🧪 Example API Endpoints

| Method | Endpoint                 | Description                   |
|--------|--------------------------|-------------------------------|
| POST   | `/api/auth/signup`       | Register new user             |
| POST   | `/api/companies`         | Create new company            |
| POST   | `/api/jobs`              | Post a job                    |
| POST   | `/api/applications`      | Apply to a job                |
| GET    | `/api/jobs`              | Get all jobs                  |
| GET    | `/api/applications`      | Get all applications          |

---

## 🔑 Authentication

Currently, the backend uses simple email+password login. No JWT or session handling is implemented yet. All endpoints are **public** for simplicity.

---

## 🛠️ Run Locally

```bash
./gradlew bootRun
```

Access H2 console:  
➡️ http://localhost:8080/h2-console  
Use JDBC URL: `jdbc:h2:mem:testdb`

---

## 📬 Sample Request Body (Signup)

```json
{
  "name": "Srishty",
  "email": "srishty@example.com",
  "password": "mypassword"
}
```

---

## 📌 Future Improvements

- Add JWT authentication
- Input validations & DTOs
- Company user roles
- File upload for resumes

---

## 🧑‍💻 Author

Made with ❤️ by Srishty M.

---
