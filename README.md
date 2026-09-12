# User Management System (Spring Boot + React + MySQL)

A full-stack User Management application built with a **Spring Boot REST API** and **Spring Data JPA** backend, a **React (Vite)** frontend, and a **MySQL** relational database.

---

##  Features

- **View All Users**: Dynamic datatable displaying users' Name, Email, Age, Password, and management actions.
- **Add New User**: Interactive form to register a new user.
- **Edit User**: Edit existing user details by ID.
- **Delete User**: Delete user records from the MySQL database.
- **CORS Configured**: Built-in `@CrossOrigin("*")` support on backend API for frontend integration.

---

##  Technology Stack

### Backend
- **Java 17**
- **Spring Boot 3.4.1**
- **Spring Data JPA & Hibernate**
- **MySQL Database**
- **Maven**

### Frontend
- **React 18** (Vite build tool)
- **React Router DOM v7** (Client-side routing)
- **Axios** (HTTP requests)
- **Bootstrap 5** (Responsive layout & UI styling)

---

## 📁 Directory Structure

```text
user_Management/
├── UserManagement Microservice/    # Spring Boot REST API Backend
│   ├── src/main/java/com/Gnaneswar/userManagament/
│   │   ├── controller/             # REST Controller (userManagementController.java)
│   │   ├── model/                  # JPA Entity (User.java)
│   │   ├── repository/             # Spring Data Repository (UserManagementRepository.java)
│   │   └── service/                # Business Logic (UserManagementService.java)
│   └── src/main/resources/
│       └── application.properties  # Database & server configuration
│
└── user_Management_UI/             # React (Vite) Frontend
    ├── src/
    │   ├── pages/                  # Home.jsx, AddUser.jsx, Edit.jsx
    │   ├── services/               # userManagament.js (API Base URL)
    │   ├── App.jsx                 # Client routes
    │   └── main.jsx                # App entry point
    └── package.json


Configuration & Prerequisites
Step 1: Create MySQL Database
        Make sure MySQL server is running, then execute the following SQL command to create the database:
            CREATE DATABASE userManagement;
Step 2: Configure Database Credentials in application.properties
        Open UserManagement Microservice/src/main/resources/application.properties
        and manually add your local MySQL database URL, username, and password:

            spring.application.name=userManagament
            server.port=9091
            
            # Database Configuration - ADD YOUR CREDENTIALS MANUALLY HERE
            spring.datasource.url=jdbc:mysql://localhost:3306/userManagement
            spring.datasource.username=YOUR_MYSQL_USERNAME
            spring.datasource.password=YOUR_MYSQL_PASSWORD
            
            # JPA & Hibernate Settings
            spring.jpa.hibernate.ddl-auto=update
            spring.jpa.show-sql=true

    Note: Replace YOUR_MYSQL_USERNAME (e.g., root) and YOUR_MYSQL_PASSWORD (e.g., your_password) with your actual MySQL server credentials.

How to Run the Application
1. Launch Spring Boot Backend
    Navigate to the microservice folder and start the server:
        cd "UserManagement Microservice"
        ./mvnw spring-boot:run

2. Launch React Frontend
    Open a new terminal, navigate to the UI directory, install dependencies, and start Vite:
        cd user_Management_UI
        npm install
        npm run dev

