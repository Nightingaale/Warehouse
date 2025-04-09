# Warehouse
Warehouse - a Spring-Boot microservice that provide access to different roles for interacting with this microservice.

### Features

Role-Based Access Control: 3 seperate controller for each type of user(Customer, Supplier, Manager)

### Prerequisites
- Java Development Kit(JDK): Version 17 or higher
- Gradle: For project build and dependency management

# Technologies 

- Spring Boot(Web, Data JPA, Spring Security will be added sooner)
- Gradle
- Postman
- PostgreSQL
- Docker

# Flow Diagram

<img src = "https://github.com/Nightingaale/Warehouse/blob/master/project-structure/structure.png" alt = "Diagram" width = "500px">
  
# Information for the repository:

1. Clone the repository
 ```bash  
git clone https://github.com/Nightingaale/Warehouse.git
```
2. Find directory and open it in your IDE
 ```bash
cd ~/Warehouse
```
3. Build the project
 ```bash
./gradlew build
```
4. Configure Docker
 ``` bash
docker run -d --name storage -e POSTGRES_DB=postgres -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=secret -p 5432:5432 postgres:17.2-alpine3.20
```
5. Run the microservice repeatedly (First - to create tables, second and etc - work with Postman)
 ```bash
./gradlew bootrun
```
The service will be accessible at http://localhost:8080 or you may configure other port.
