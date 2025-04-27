### 🏥 Patient Demo Spring Boot Application

## 📋 Project Description
This project is a simple CRUD Web Application built with Spring Boot, using JPA, Hibernate, H2 Database (later migrated to MySQL) for managing Patient entities.
The main objective was to practice:
Creating JPA entities
Performing CRUD operations (Create, Read, Update, Delete)
Using Spring Data JPA
Configuring both H2 and MySQL databases
Using Lombok to reduce boilerplate code
## 🛠️ Technologies Used
Java 17
Spring Boot
Spring Web
Spring Data JPA
H2 Database
MySQL
Lombok
Maven
IntelliJ IDEA Ultimate
MYSQL

## 🏗️ Project Steps

# 1. Environment Setup
Installed IntelliJ IDEA Ultimate for advanced Spring Boot development.
# 2. Project Creation
Project generated with Spring Initializer including the following dependencies:
Spring Web
Spring Data JPA
H2 Database
Lombok
# 3. Development of the Patient Entity
Created the Patient class with the following attributes:
id : Long
name : String
birthDate : Date
sick : boolean
score : int
Annotations used:
@Entity
@Id
@GeneratedValue
@Column
# 4. Application Configuration
```java
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.h2.console.enabled=true
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update
```
# 5. Repository Creation
Created a PatientRepository interface by extending JpaRepository<Patient, Long>, to automatically inherit CRUD operations.
# 6. CRUD Operations Testing
➕ Add patients using the repository
🔍 Retrieve all patients with findAll()
🔍 Retrieve a single patient with findById()
🔎 Search for patients using query methods
# 7. Migration to MySQL
Updated application.properties to switch from H2 to MySQL:
```java
spring.datasource.url=jdbc:mysql://localhost:3306/hospitaldb?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
spring.jpa.show-sql=true
```
Persistence was successfully migrated to a local MySQL database.

## 📂 Project Structure
```markdown
src/main/java
 └── net.imad.patient_demo_tp2
      ├── entities
      │     └── Patient.java
      ├── repository_DAO
      │     └── PatientRepository.java
      ├── service
      │     └── (future service classes)
      ├── web
      │     └── PatientRestController.java
      └── PatientDemoTp2Application.java

```
## 🎯 Summary
This project covers building a complete Spring Boot CRUD application, migrating from H2 to MySQL, following best backend development practices.
## 👨‍💻 Author
Name: Imad El khelyfy

Email: imadelkhelyfy@gmail.com
