# User Management System (Spring Boot + React + MySQL)

A full-stack User Management Web Application built with **Spring Boot (REST API & Spring Data JPA)** on the backend and **React (Vite, React Router, Axios, Bootstrap)** on the frontend, with **MySQL** for data persistence.

---

## 🚀 Features

- **User Listing**: View all registered users in a responsive datatable.
- **Add User**: Interactive form to register a new user with Name, Email, Age, and Password.
- **Edit User**: Fetch existing user details by ID and update fields.
- **Delete User**: Remove a user from the database.
- **CORS Enabled**: Cross-Origin Resource Sharing enabled on the Spring Boot backend (`@CrossOrigin("*")`) to seamlessly communicate with the React UI.

---

## 🛠️ Tech Stack

### **Backend**
- **Java 17**
- **Spring Boot 3.4.1**
- **Spring Data JPA** (Hibernate ORM)
- **MySQL Database**
- **Maven**

### **Frontend**
- **React 18** (Vite)
- **React Router DOM v7** (Client-side routing)
- **Axios** (HTTP Client)
- **Bootstrap 5** (Styling & layout)

---

## 📁 Directory Structure

```text
user_Management/
├── UserManagement Microservice/    # Spring Boot REST API
│   ├── src/main/java/com/Gnaneswar/userManagament/
│   │   ├── controller/             # userManagementController.java
│   │   ├── model/                  # User.java (JPA Entity)
│   │   ├── repository/             # UserManagementRepository.java
│   │   └── service/                # UserManagementService.java
│   └── src/main/resources/
│       └── application.properties  # Database & server configuration
│
└── user_Management_UI/             # React (Vite) Frontend
    ├── src/
    │   ├── pages/                  # Home.jsx, AddUser.jsx, Edit.jsx
    │   ├── services/               # userManagament.js (API Base URL)
    │   ├── App.jsx                 # Router setup
    │   └── main.jsx                # App entry point
    └── package.json
```

---

## ⚙️ Configuration Setup

### ⚠️ Step 1: Database Setup & `application.properties` Configuration

Before running the backend, you **must manually configure your MySQL database credentials** in `application.properties`.

1. Open your MySQL client (e.g., MySQL Workbench or CLI) and create a database named `userManagement`:
   ```sql
   CREATE DATABASE userManagement;
   ```

2. Open the backend configuration file located at:
   `UserManagement Microservice/src/main/resources/application.properties`

3. **Manually update** the database URL, username, and password fields with your local MySQL credentials:

   ```properties
   spring.application.name=userManagament
   server.port=9091

   # Database Configuration - ADD YOUR CREDENTIALS MANUALLY HERE
   spring.datasource.url=jdbc:mysql://localhost:3306/userManagement
   spring.datasource.username=YOUR_MYSQL_USERNAME
   spring.datasource.password=YOUR_MYSQL_PASSWORD

   # JPA & Hibernate Settings
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   ```

   > **Note**: Replace `YOUR_MYSQL_USERNAME` (e.g., `root`) and `YOUR_MYSQL_PASSWORD` (e.g., `your_password`) with your actual MySQL login credentials.

---

## 🏃 Running the Application

### 1. Launch Backend (Spring Boot Microservice)

Navigate to the microservice directory and run using Maven wrapper:

```bash
cd "UserManagement Microservice"
./mvnw spring-boot:run
```
*(On Windows Command Prompt / PowerShell, you can also use `mvnw.cmd spring-boot:run` or run `UserManagamentApplication.java` directly from your IDE like Eclipse or IntelliJ).*

The backend server will start on **`http://localhost:9091`**.

---

### 2. Launch Frontend (React UI)

In a new terminal window, navigate to the frontend directory:

```bash
cd user_Management_UI
npm install
npm run dev
```

The Vite dev server will start (typically on **`http://localhost:5173`**). Open the URL in your browser to interact with the application.

---

## 📡 REST API Endpoints

Base URL: `http://localhost:9091/api/User`

| HTTP Method | Endpoint | Description | Request Body | Response Status |
| :--- | :--- | :--- | :--- | :--- |
| **GET** | `/api/User` | Fetch all users | None | `200 OK` |
| **GET** | `/api/User/{id}` | Fetch single user by ID | None | `200 OK` / `404 Not Found` |
| **POST** | `/api/User` | Create a new user | User JSON object | `201 Created` |
| **PUT** | `/api/User/{id}` | Update existing user by ID | User JSON object | `201 Created` / `404 Not Found` |
| **DELETE** | `/api/User/{id}` | Delete user by ID | None | `200 OK` / `404 Not Found` |

### User Object Schema (JSON)
```json
{
  "name": "John Doe",
  "email": "john@example.com",
  "age": 28,
  "password": "secretPassword123"
}
```

---

## 📝 License
This project is for educational and administrative user management purposes.
