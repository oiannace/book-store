# Forum Web App Backend
Backend for a Forum Web App using Java, Spring Boot and MySQL

Functionality include CRUD operations for forum threads, as well as CRUD operations for users of the web app. 

**NOTE**: In order to connect to the database you need a MySQL account, and in the file application.properties changes need to be made to the following properties to represent your username and password.

spring.datasource.username=root  
spring.datasource.password=pass

## **REST APIs Available**
### Users
| Method | URL | Description | Input |
| ------ | --- | ----------- | ----- |
| GET | /api/users | Return all users in the database | |
| POST | /api/user/save | Add a new user to the database | JSON |


... more to come!
