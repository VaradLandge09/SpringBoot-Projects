# 🍃 SpringBoot-Projects

A comprehensive collection of Spring Boot applications demonstrating enterprise-level Java development, RESTful APIs, data persistence, and modern web application architecture. This repository showcases practical implementations of Spring Framework ecosystem components.

## 📋 Table of Contents

- [Overview](#overview)
- [Projects](#projects)
- [Technologies Used](#technologies-used)
- [Getting Started](#getting-started)
- [Installation](#installation)
- [Configuration](#configuration)
- [Usage](#usage)
- [Project Structure](#project-structure)
- [API Documentation](#api-documentation)
- [Database Setup](#database-setup)
- [Testing](#testing)
- [Contributing](#contributing)
- [License](#license)
- [Contact](#contact)

## 🎯 Overview

This repository contains enterprise-grade Spring Boot applications that demonstrate best practices in Java backend development. Each project showcases different aspects of the Spring ecosystem, from basic CRUD operations to advanced features like security, caching, and microservices architecture.

## 📁 Projects

### 1. Employee Relationship Management App
**Directory**: `EmployeeRelationshipManagementApp/`

A comprehensive HR management system built with Spring Boot that handles employee data, relationships, and organizational structure.

**Key Features:**
- Employee CRUD operations with advanced search and filtering
- Department and role management with hierarchical structures
- Employee relationship tracking (manager-subordinate, team members)
- RESTful API endpoints for all HR operations
- Data validation and error handling
- Pagination and sorting for large datasets

**Technologies:**
- Spring Boot 3.x
- Spring Data JPA
- Spring Security
- MySQL/PostgreSQL database
- Maven build system
- Swagger/OpenAPI documentation

### 2. Movie Watchlist Application
**Directory**: `MovieWatchListApplication/`

A personal movie management system that allows users to create and manage their movie watchlists with ratings and reviews.

**Key Features:**
- Movie database with comprehensive movie information
- Personal watchlist creation and management
- Rating and review system
- Movie search and filtering capabilities
- Category and genre-based organization
- User preference tracking and recommendations

**Technologies:**
- Spring Boot 3.x
- Spring Data JPA
- Spring Web MVC
- H2/MySQL database
- Thymeleaf templating (if applicable)
- External movie API integration

## 🛠️ Technologies Used

### Core Framework
- **Spring Boot 3.x** - Enterprise Java application framework
- **Spring Framework 6** - Comprehensive programming model
- **Java 17+** - Latest LTS version with modern language features

### Spring Ecosystem
- **Spring Data JPA** - Data access layer abstraction
- **Spring Security** - Authentication and authorization
- **Spring Web MVC** - Web layer and REST API development
- **Spring Boot Actuator** - Production-ready monitoring features
- **Spring Boot DevTools** - Development-time productivity tools

### Database & Persistence
- **JPA/Hibernate** - Object-relational mapping
- **MySQL** - Production database
- **H2 Database** - In-memory database for testing
- **Connection Pooling** - HikariCP for optimal performance

### Build & Development Tools
- **Maven** - Dependency management and build automation
- **Spring Boot Starter** - Opinionated dependency management
- **Lombok** - Boilerplate code reduction
- **MapStruct** - Bean mapping framework

### Testing & Documentation
- **JUnit 5** - Unit testing framework
- **Mockito** - Mocking framework for testing
- **Spring Boot Test** - Integration testing support
- **Swagger/OpenAPI 3** - API documentation
- **Postman Collections** - API testing collections

## 🏁 Getting Started

### Prerequisites

Ensure you have the following installed:

- **Java 17 or higher** - [Download JDK](https://adoptium.net/)
- **Maven 3.8+** - [Download Maven](https://maven.apache.org/download.cgi)
- **MySQL 8.0+** - [Download MySQL](https://dev.mysql.com/downloads/)
- **Git** - [Download Git](https://git-scm.com/)
- **IDE** - IntelliJ IDEA, Eclipse, or VS Code with Java extensions

### System Requirements

- **Memory**: 4GB RAM minimum, 8GB recommended
- **Storage**: 2GB free space
- **OS**: Windows 10+, macOS 10.14+, or Linux

## 🔧 Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/VaradLandge09/SpringBoot-Projects.git
   cd SpringBoot-Projects
   ```

2. **Navigate to a specific project**
   ```bash
   # For Employee Management App
   cd EmployeeRelationshipManagementApp
   
   # OR for Movie Watchlist App
   cd MovieWatchListApplication
   ```

3. **Install dependencies**
   ```bash
   mvn clean install
   ```

4. **Run the application**
   ```bash
   mvn spring-boot:run
   ```

5. **Access the application**
   - Application: `http://localhost:8080`
   - API Documentation: `http://localhost:8080/swagger-ui.html`
   - Actuator Health: `http://localhost:8080/actuator/health`

## ⚙️ Configuration

### Database Configuration

**MySQL Setup** (application.properties):
```properties
# Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/employee_db
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# JPA Configuration
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
spring.jpa.properties.hibernate.format_sql=true

# Connection Pool
spring.datasource.hikari.maximum-pool-size=20
spring.datasource.hikari.minimum-idle=5
```

**H2 Database** (for development):
```properties
# H2 Database
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password
spring.h2.console.enabled=true
```

### Application Configuration

**Server Configuration**:
```properties
# Server Configuration
server.port=8080
server.servlet.context-path=/api

# Logging
logging.level.com.varad.springboot=DEBUG
logging.level.org.springframework.web=DEBUG
logging.pattern.console=%d{yyyy-MM-dd HH:mm:ss} - %msg%n

# Actuator
management.endpoints.web.exposure.include=health,info,metrics
management.endpoint.health.show-details=always
```

### Environment Profiles

**Development** (application-dev.properties):
```properties
spring.profiles.active=dev
spring.jpa.show-sql=true
logging.level.root=DEBUG
```

**Production** (application-prod.properties):
```properties
spring.profiles.active=prod
spring.jpa.show-sql=false
logging.level.root=WARN
```

## 💻 Usage

### Employee Relationship Management App

**Key API Endpoints:**

1. **Employee Operations**
   ```bash
   # Get all employees
   GET /api/employees
   
   # Get employee by ID
   GET /api/employees/{id}
   
   # Create new employee
   POST /api/employees
   Content-Type: application/json
   {
     "firstName": "John",
     "lastName": "Doe",
     "email": "john.doe@company.com",
     "departmentId": 1,
     "roleId": 2
   }
   
   # Update employee
   PUT /api/employees/{id}
   
   # Delete employee
   DELETE /api/employees/{id}
   ```

2. **Department Operations**
   ```bash
   # Get all departments
   GET /api/departments
   
   # Get employees by department
   GET /api/departments/{id}/employees
   ```

3. **Search and Filter**
   ```bash
   # Search employees
   GET /api/employees/search?name=John&department=IT&page=0&size=10
   
   # Filter by role
   GET /api/employees?role=MANAGER&sort=lastName,asc
   ```

### Movie Watchlist Application

**Key API Endpoints:**

1. **Movie Operations**
   ```bash
   # Get all movies
   GET /api/movies
   
   # Search movies
   GET /api/movies/search?title=Inception&genre=Sci-Fi
   
   # Add movie to watchlist
   POST /api/watchlist
   Content-Type: application/json
   {
     "movieId": 123,
     "status": "WANT_TO_WATCH",
     "priority": "HIGH"
   }
   ```

2. **Watchlist Management**
   ```bash
   # Get user watchlist
   GET /api/watchlist
   
   # Update watchlist item
   PUT /api/watchlist/{id}
   {
     "status": "WATCHED",
     "rating": 4.5,
     "review": "Great movie!"
   }
   ```

## 📂 Project Structure

```
SpringBoot-Projects/
├── EmployeeRelationshipManagementApp/
│   ├── src/main/java/com/varad/employee/
│   │   ├── config/              # Configuration classes
│   │   ├── controller/          # REST controllers
│   │   ├── dto/                 # Data Transfer Objects
│   │   ├── entity/              # JPA entities
│   │   ├── exception/           # Custom exceptions
│   │   ├── repository/          # Data repositories
│   │   ├── service/             # Business logic
│   │   └── EmployeeApplication.java
│   ├── src/main/resources/
│   │   ├── application.properties
│   │   ├── data.sql             # Sample data
│   │   └── schema.sql           # Database schema
│   ├── src/test/java/           # Test classes
│   ├── pom.xml                  # Maven configuration
│   └── README.md
├── MovieWatchListApplication/
│   ├── src/main/java/com/varad/movies/
│   │   ├── controller/
│   │   ├── entity/
│   │   ├── repository/
│   │   ├── service/
│   │   └── MovieApplication.java
│   ├── src/main/resources/
│   ├── src/test/java/
│   ├── pom.xml
│   └── README.md
└── README.md                    # This file
```

## 📖 API Documentation

Each project includes comprehensive API documentation using Swagger/OpenAPI 3.

**Access API Documentation:**
- Employee App: `http://localhost:8080/swagger-ui.html`
- Movie App: `http://localhost:8081/swagger-ui.html`

**Sample API Response:**
```json
{
  "status": "success",
  "data": {
    "id": 1,
    "firstName": "John",
    "lastName": "Doe",
    "email": "john.doe@company.com",
    "department": {
      "id": 1,
      "name": "Information Technology"
    },
    "role": "Senior Developer",
    "createdAt": "2024-01-15T10:30:00Z",
    "updatedAt": "2024-01-15T10:30:00Z"
  },
  "message": "Employee retrieved successfully"
}
```

## 🗄️ Database Setup

### Employee Management Database Schema

```sql
-- Create Database
CREATE DATABASE employee_db;

-- Departments Table
CREATE TABLE departments (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    description TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Employees Table
CREATE TABLE employees (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    department_id BIGINT,
    role VARCHAR(50),
    salary DECIMAL(10,2),
    hire_date DATE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (department_id) REFERENCES departments(id)
);
```

### Movie Watchlist Database Schema

```sql
-- Create Database
CREATE DATABASE movie_db;

-- Movies Table
CREATE TABLE movies (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(200) NOT NULL,
    genre VARCHAR(100),
    release_year INT,
    director VARCHAR(100),
    rating DECIMAL(3,1),
    description TEXT,
    poster_url VARCHAR(500)
);

-- Watchlist Table
CREATE TABLE watchlist (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    movie_id BIGINT,
    user_id BIGINT,
    status ENUM('WANT_TO_WATCH', 'WATCHING', 'WATCHED'),
    priority ENUM('LOW', 'MEDIUM', 'HIGH'),
    user_rating DECIMAL(3,1),
    review TEXT,
    added_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (movie_id) REFERENCES movies(id)
);
```

## 🧪 Testing

### Running Tests

```bash
# Run all tests
mvn test

# Run specific test class
mvn test -Dtest=EmployeeControllerTest

# Run tests with coverage
mvn jacoco:report

# Integration tests
mvn verify
```

### Test Categories

**Unit Tests:**
- Service layer logic testing
- Repository layer testing
- Controller endpoint testing

**Integration Tests:**
- Database integration testing
- API endpoint testing
- Security testing

**Test Example:**
```java
@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class EmployeeServiceTest {
    
    @Autowired
    private EmployeeService employeeService;
    
    @Test
    void shouldCreateEmployee() {
        // Given
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setFirstName("John");
        employeeDto.setLastName("Doe");
        
        // When
        Employee created = employeeService.createEmployee(employeeDto);
        
        // Then
        assertThat(created.getFirstName()).isEqualTo("John");
    }
}
```

## 🤝 Contributing

Contributions are welcome! Here's how you can help:

1. **Fork the repository**
2. **Create a feature branch**
   ```bash
   git checkout -b feature/add-employee-reports
   ```
3. **Make your changes**
4. **Write tests**
5. **Run tests**
   ```bash
   mvn test
   ```
6. **Commit your changes**
   ```bash
   git commit -m 'Add employee reporting functionality'
   ```
7. **Push to the branch**
   ```bash
   git push origin feature/add-employee-reports
   ```
8. **Open a Pull Request**

### Coding Standards

- Follow Java naming conventions
- Use Spring Boot best practices
- Write comprehensive tests
- Document your code with JavaDoc
- Follow RESTful API design principles

## 📞 Contact

**Varad Landge**

- GitHub: [@VaradLandge09](https://github.com/VaradLandge09)
- Email: [varad.landge404@gmail.com](mailto:varad.landge404@gmail.com)
- LinkedIn: [Linked In](https://www.linkedin.com/in/varad-landge-b174b1252/)

## 🙏 Acknowledgments

- Spring Boot team for the excellent framework
- Spring community for comprehensive documentation
- Contributors who helped improve these projects
- Open source libraries that made development efficient

## 📚 Learning Resources

- [Spring Boot Official Documentation](https://spring.io/projects/spring-boot)
- [Spring Framework Reference](https://docs.spring.io/spring-framework/docs/current/reference/html/)
- [Spring Data JPA Guide](https://spring.io/guides/gs/accessing-data-jpa/)
- [Building REST APIs with Spring](https://spring.io/guides/tutorials/rest/)

---

⭐ **If you found this repository helpful, please consider giving it a star!**

## 🔮 Future Enhancements

- [ ] Microservices architecture implementation
- [ ] Spring Cloud integration
- [ ] Advanced security with JWT
- [ ] Caching with Redis
- [ ] Message queues with RabbitMQ
- [ ] Monitoring with Micrometer
- [ ] GraphQL API support
- [ ] Event-driven architecture
- [ ] Performance optimization
- [ ] Advanced search with Elasticsearch
