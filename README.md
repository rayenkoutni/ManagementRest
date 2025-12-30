#ManagementRest – Person Management REST API
A simple Java RESTful backend for managing persons, built with JAX-RS, JPA (Hibernate), and Maven.
The project exposes CRUD operations over HTTP and uses a relational database via JPA.

📌 Features

REST API using JAX-RS

CRUD operations for Person

Database persistence using JPA

CORS enabled for frontend communication

JSON request/response handling

Maven project structure

Project Structure
ManagementRest
│
├── src
│   └── com.personmanagement
│       ├── api
│       │   ├── CorsFilter.java
│       │   └── Ressources.java
│       │
│       ├── entities
│       │   └── Person.java
│       │
│       ├── repository
│       │   └── Repository.java
│       │
│       └── service
│           └── Service.java
│
├── META-INF
│   └── persistence.xml
│
├── pom.xml
└── README.md

Technologies Used

Java

JAX-RS (REST API)

JPA / Hibernate

Maven

JSON

Relational Database (via persistence.xml)

🧑‍💻 Entity Model
| Field | Type   | Description                |
| ----- | ------ | -------------------------- |
| id    | int    | Auto-generated primary key |
| name  | String | Person name (required)     |
| email | String | Email address              |
| age   | int    | Age                        |
| phone | String | Phone number               |

🌐 REST API Endpoints

Base path:

/persons

🔹 Get all persons
GET /persons

🔹 Get person by ID
GET /persons/{id}

🔹 Create a person
POST /persons


JSON Body Example

{
  "name": "John Doe",
  "email": "john@example.com",
  "age": 30,
  "phone": "12345678"
}


✔️ name is mandatory

🔹 Update a person
PUT /persons/{id}


JSON Body Example

{
  "name": "John Updated",
  "email": "john.updated@example.com",
  "age": 31,
  "phone": "99999999"
}

🔹 Delete a person
DELETE /persons/{id}

🌍 CORS Configuration

CORS is enabled globally via CorsFilter.java.

Allowed:

Origins: *

Methods: GET, POST, PUT, DELETE, OPTIONS, HEAD

Headers: origin, content-type, accept, authorization

This allows frontend frameworks (React, Angular, etc.) to access the API.

🗄 Persistence Configuration

Database configuration is defined in:

META-INF/persistence.xml


Persistence unit name:

PersonPU


The project uses GenerationType.IDENTITY for ID generation.

▶️ How to Run

Import the project into Eclipse / IntelliJ

Make sure a compatible database is configured in persistence.xml

Run the project on a Java EE / Jakarta EE server (Tomcat, WildFly, GlassFish)

Access the API using:

Postman

Browser

Frontend application

⚠️ Validation

Person creation fails if name is empty or null

Errors return HTTP 500 with the exception message

📄 License

This project is for educational purposes.
You are free to modify and extend it.

👤 Author

Rayen Koutni,Manar Messaoudi
Students.


