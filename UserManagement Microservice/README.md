# UserManagement Microservice (Spring Boot)

Backend microservice for the User Management system built using Spring Boot, Spring Data JPA, and MySQL.

---

## ⚙️ Configuration Setup

### Manual Database Configuration Required
Before launching the service, open `src/main/resources/application.properties` and manually set your MySQL database URL, username, and password:

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

---

## 🏃 Running the Microservice

```bash
./mvnw spring-boot:run
```

The application will run on port `9091` at `http://localhost:9091/api/User`.

Refer to the main [README.md](../README.md) for full project documentation and frontend integration.
