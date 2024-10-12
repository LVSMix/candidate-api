<p align="center">
  <a href="#"><img src="https://img.shields.io/badge/Spring_Boot-3.2.2-brightgreen" alt="Spring Boot"></a>
  <a href="#"><img src="https://img.shields.io/badge/chat-on%20Discord-7289da.svg?sanitize=true" alt="Chat"></a>
  <a href="#"><img src="https://img.shields.io/badge/Java-17-orange" alt="Chat"></a>
</p>

<br>
<br>
<p align="center">

# Candidate Management API

This project is a Candidate Management API built with Spring Boot. It provides endpoints to manage candidates, including creating, retrieving, updating, and deleting candidate records.

## Technologies Used

- **Java 17**
- **Spring Boot 3.2.2**
- **Maven**
- **SQL**

## Endpoints

### Get All Candidates

- **URL:** `/candidates`
- **Method:** `GET`
- **Response:**
    - `200 OK`: Candidates retrieved successfully.
    - `500 Internal Server Error`: An error occurred on the server.

### Get Candidate by ID

- **URL:** `/candidates/{id}`
- **Method:** `GET`
- **Response:**
    - `200 OK`: Candidate retrieved successfully.
    - `404 Not Found`: Candidate not found.
    - `500 Internal Server Error`: An error occurred on the server.

### Create a New Candidate

- **URL:** `/candidates`
- **Method:** `POST`
- **Request Body:** `CandidateRequest`
- **Response:**
    - `200 OK`: Candidate created successfully.
    - `400 Bad Request`: Invalid request data.
    - `404 Not Found`: Candidate not found.
    - `500 Internal Server Error`: An error occurred on the server.

### Update a Candidate by ID

- **URL:** `/candidates/{id}`
- **Method:** `PUT`
- **Request Body:** `CandidateRequest`
- **Response:**
    - `200 OK`: Candidate updated successfully.
    - `400 Bad Request`: Invalid request data.
    - `404 Not Found`: Candidate not found.
    - `500 Internal Server Error`: An error occurred on the server.

### Delete a Candidate by ID

- **URL:** `/candidates/{id}`
- **Method:** `DELETE`
- **Response:**
    - `200 OK`: Candidate deleted successfully.
    - `404 Not Found`: Candidate not found.
    - `500 Internal Server Error`: An error occurred on the server.

## 🔨 Build and Run

## Prerequisites

Ensure you have the following installed on your system:

- Java Development Kit (JDK 17)
- Maven


## Steps


### 1. Run docker compose

Run docker compose to start the external microservice that provides the candidate categories:

```bash
docker-compose up
```
### 2. Clone the Repository

Clone your Spring Boot API repository to your local machine:

```bash
git clone https://github.com/LVSMix/candidate-api.git
```
```
cd candidate-api
```

### 3. Build the Project

Navigate to the root directory of your project and execute the following Maven command to build the project:
```
./mvnw clean install
```

### 4. Run the Application
Once the build is successful, you can run your Spring Boot application using the following command:
```
./mvnw spring-boot:run
```

### 5. Access the API
Your Spring Boot API should now be accessible at the default port 8080. Open your web browser or a tool like Postman and access the following URL:

> http://localhost:8080/candidate-api/swagger-ui/index.html

## Postman Collection

You can use the following Postman collection to test the API:

[Reto-Seek.postman_collection.json](Reto-Seek.postman_collection.json)
