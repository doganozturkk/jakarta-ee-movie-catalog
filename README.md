<h1 align="center">
  <span style="
    background: linear-gradient(to right, #5382a1, #f89820);
    -webkit-background-clip: text;
    color: transparent;
    font-size: 40px;
    font-weight: 900;
  ">
    Jakarta EE Movie Catalog
  </span>
</h1>

<p align="center" style="
  font-size: 18px;
  color: #555;
  margin-top: -10px;
">
  <i>A Movie Catalog web application developed with Jakarta EE, featuring JSF, EJB, JPA, JMS, MDB, JAX-RS REST services, JSON communication, and a Java HTTP client.</i>
</p>

<p align="center">
  <img src="https://media3.giphy.com/media/v1.Y2lkPTc5MGI3NjExa2djbWdpNnZvY3VsOWxwaGFxeHE1N2wyMTZsdWpuZjc5ZDBsZGh1diZlcD12MV9pbnRlcm5hbF9naWZfYnlfaWQmY3Q9Zw/AFdcYElkoNAUE/giphy.gif" width="320" />
</p>

<p align="center">
  <img src="https://img.shields.io/badge/Java-25-f89820?logo=openjdk&logoColor=white&style=for-the-badge">
  <img src="https://img.shields.io/badge/Jakarta%20EE-11-5382a1?logo=jakartaee&logoColor=white&style=for-the-badge">
  <img src="https://img.shields.io/badge/JSF-UI-6f42c1?style=for-the-badge">
  <img src="https://img.shields.io/badge/EJB-Enterprise%20Beans-e44d26?style=for-the-badge">
  <img src="https://img.shields.io/badge/JMS-Asynchronous%20Messaging-2ea44f?style=for-the-badge">
  <img src="https://img.shields.io/badge/REST-JAX--RS-198754?style=for-the-badge">
</p>

---

## 📌 Overview

This repository contains examples and exercises developed for the **Information Systems Architectures and Patterns** course (*Arhitekture IS in Vzorci*), offered as part of the **IPT UNI 2nd year curriculum**.

The repository includes introductory Java, JSP, Servlet, MVC, Node.js, Maven, and JSF examples provided throughout the course.

The main project in this repository is **`00_JSF101`**, a Jakarta EE based **Movie Catalog** application that was progressively developed through six assignments.

The Movie Catalog starts as a simple JSF web application and gradually introduces enterprise application concepts including:

* JSF web interfaces
* CRUD operations
* Stateless EJBs
* Local and Remote EJB interfaces
* Asynchronous JMS messaging
* Message Driven Beans
* JAX-RS REST services
* JSON communication
* Java HTTP Client
* Maven-based project management
* Jakarta EE application architecture

Each assignment represents a new stage of development and builds upon the functionality introduced in the previous stage.

---

## 📚 Project Context

The project focuses on enterprise application development and architectural patterns using technologies such as **Jakarta EE**, Maven, JSF, Servlets, JSP, EJB, JMS, REST services, and related enterprise Java technologies.

The repository follows the general structure and purpose of the official course examples.

See also:

[Platforms to run the examples](https://github.com/lukapavlic/platforms)

---

## 🧩 Course Examples

The repository contains several smaller examples demonstrating individual technologies used throughout the course.

### `00_Java101` — Java Fundamentals

An introductory Java project demonstrating fundamental concepts used throughout the course.

Main topics include:

* Classes and objects
* Methods
* Packages
* Basic Java application structure
* Unit testing
* Lombok

---

### `01_jsp` — JSP

A basic **JavaServer Pages** example demonstrating server-side view rendering.

The project introduces the fundamentals of JSP-based web applications and demonstrates how dynamic content can be generated on the server.

---

### `02_servlet` — Servlets

A basic HTTP handling example using **Jakarta Servlets**.

The project demonstrates the role of a Servlet as a controller capable of receiving HTTP requests and generating HTTP responses.

---

### `03_mvcDemo` — MVC Architecture

An example combining:

```text
JSP
 │
 ▼
View
 │
 │ HTTP
 ▼
Servlet
 │
 ▼
Controller
```

The project demonstrates the basic principles of the **Model-View-Controller (MVC)** architecture by combining JSP as the view technology with Servlets as controllers.

---

### `04_node_demo` — Node.js

A simple backend example demonstrating HTTP request handling with **Node.js**.

This project provides a comparison between traditional Java web technologies and a lightweight JavaScript-based server environment.

---

### `mvnTemplate` — Maven Template

A reusable Maven project template containing the initial project structure and configuration required for course examples and exercises.

It provides a standardized starting point for Maven-based Java projects.

---

### `mvnEmptyJsf` — JSF Starter

A minimal Maven-based **Jakarta EE / JSF** project.

It provides a basic skeleton that can be used to bootstrap JSF web applications with a standard Maven project structure.

---

# 🎬 Movie Catalog — `00_JSF101`

The main project in this repository is a **Movie Catalog** application developed using Jakarta EE.

The application manages movies with the following information:

```text
Movie
├── ID
├── Title
├── Genre
├── Release Year
├── Description
└── Director
```

The application demonstrates how a simple domain model can gradually evolve into a multi-layered enterprise application.

---

## 🏗️ Architecture

The final application consists of several layers and enterprise technologies:

```text
                    ┌─────────────────────┐
                    │      JSF Web UI     │
                    │     MovieJsfBean    │
                    └──────────┬──────────┘
                               │
                               ▼
                    ┌─────────────────────┐
                    │     Remote EJB      │
                    │   MovieRemoteBean   │
                    └──────────┬──────────┘
                               │
                               ▼
                    ┌─────────────────────┐
                    │       DAO / EJB     │
                    │      MovieDao       │
                    └──────────┬──────────┘
                               │
                               ▼
                    ┌─────────────────────┐
                    │   In-Memory Store   │
                    │     ArrayList       │
                    └─────────────────────┘


 REST Client
     │
     │ HTTP / JSON
     ▼
┌─────────────────────┐
│   JAX-RS REST API   │
│  MovieRestService   │
└──────────┬──────────┘
           │
           ▼
      Remote EJB
           │
           ▼
          DAO


 JSF Movie Request
          │
          ▼
   ┌───────────────┐
   │ MovieProducer │
   └───────┬───────┘
           │
           ▼
      JMS Queue
           │
           ▼
      ┌─────────┐
      │ MovieMDB│
      └────┬────┘
           │
           ▼
          DAO
```

This architecture separates the presentation layer, enterprise business logic, data-access operations, asynchronous processing, and REST communication.

---

# 🧩 Assignment Progression

The Movie Catalog was developed incrementally through six assignments.

Each assignment introduced a new enterprise application concept while extending the existing project.

---

## Assignment 01 — JSF Application

### Environment Setup

The first assignment establishes the Jakarta EE development environment.

The project is built using:

* Java 17
* Maven
* Jakarta EE 10
* JSF
* WildFly
* IntelliJ IDEA

The application is packaged as a deployable **WAR** file.

### Initial Domain Model

The selected domain is a **Movie Catalog**.

The primary entity contains:

* `title`
* `genre`
* `releaseYear`
* `description`
* `director`

### Initial Functionality

The first stage focuses on the fundamental JSF application structure.

Implemented functionality includes:

* Movie creation
* Movie listing
* Movie details
* JSF managed bean
* In-memory data storage
* DAO abstraction
* JSF page navigation

The initial architecture can be summarized as:

```text
JSF Page
   ↓
JSF Managed Bean
   ↓
DAO
   ↓
In-Memory List
```

---

## Assignment 02 — CRUD Extension

The second assignment extends the original JSF application with full CRUD-oriented functionality.

### Main Additions

* Create movies
* Read movie list
* Read movie details
* Update existing movies
* Delete movies
* Filtered movie listing
* Navigation between pages

The application reuses the same movie form for both creation and editing.

### Filtered View

A dedicated page was introduced for movies without a director:

```text
moviesWithoutDirector.xhtml
```

This page demonstrates filtering the domain objects according to a specific business condition.

### Navigation

The application provides navigation between:

```text
Movie List
    │
    ├── Create
    │
    ├── Edit
    │
    ├── Details
    │
    └── Movies Without Director
```

---

## Assignment 03 — Enterprise Java Beans

The third assignment introduces **Enterprise Java Beans (EJB)**.

The DAO is converted into a **Stateless Session Bean**:

```java
@Stateless
public class MovieDao implements MovieDaoLocal
```

A local interface separates the DAO contract from its implementation:

```java
@Local
public interface MovieDaoLocal
```

### Remote EJB

A separate remote EJB interface was also introduced:

```java
@Remote
public interface MovieRemote
```

The remote bean exposes operations such as:

* Count movies
* List movies
* Find movie by ID
* Create movie
* Update movie
* Delete movie
* List movies without directors
* Retrieve movie titles

### Console Client

The project also contains a Java client for interacting with the application's external functionality.

This demonstrates the difference between:

```text
Local EJB
    ↓
Internal application components
```

and:

```text
Remote EJB
    ↓
External Java client
```

---

## Assignment 04 — JPA Preparation

The fourth assignment introduces the concepts of **Java Persistence API (JPA)** and entity mapping.

The `Movie` class is converted into a JPA entity:

```java
@Entity
@Table(name = "movies")
public class Movie
```

The primary key is configured using:

```java
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
```

The project also contains a JPA persistence unit:

```text
src/main/resources/
└── META-INF/
    └── persistence.xml
```

The entity therefore follows the standard Jakarta Persistence model and is prepared for relational persistence.

### Current Storage Model

The current implementation retains an **in-memory collection inside `MovieDao`** rather than performing database CRUD operations through `EntityManager`.

Therefore, this project demonstrates the JPA entity and persistence-unit configuration introduced at this stage, while the active DAO implementation continues to use in-memory storage.

---

## Assignment 05 — JMS & Message Driven Beans

The fifth assignment introduces **Message-Oriented Middleware** using JMS.

The project implements an asynchronous movie submission workflow.

### Message Flow

```text
User
 │
 ▼
JSF Application
 │
 ▼
MovieProducer
 │
 ▼
JMS Queue
 │
 ▼
MovieMDB
 │
 ├── Validate movie
 │
 ├── Apply business logic
 │
 └── Store movie
```

### JMS Producer

The `MovieProducer` sends movie objects to the configured JMS queue:

```text
java:/jms/queue/MovieQueue
```

The producer uses:

```java
JMSContext
```

to create and send messages.

### Message Driven Bean

The queue is consumed by:

```java
@MessageDriven
public class MovieMDB implements MessageListener
```

The MDB receives the asynchronous request and processes it independently from the original web request.

### Validation

Before saving the movie, the MDB performs validation such as:

* Movie title must not be empty
* Release year must be valid
* Invalid requests are rejected

Successful processing is reported through application logs.

This demonstrates the basic asynchronous processing pattern:

```text
Request
  ↓
Queue
  ↓
Asynchronous Consumer
  ↓
Validation
  ↓
Business Operation
```

---

## Assignment 06 — REST Web Services

The final assignment exposes parts of the application through a RESTful API using **JAX-RS**.

The REST layer is implemented by:

```java
MovieRestService
```

and configured under:

```text
/api
```

using:

```java
@ApplicationPath("/api")
```

---

## 🌐 REST API

The Movie Catalog exposes the following endpoints.

| Method | Endpoint                  | Description                        |
| ------ | ------------------------- | ---------------------------------- |
| `GET`  | `/api/movies`             | Retrieve all movies                |
| `GET`  | `/api/movies/{id}`        | Retrieve a movie by ID             |
| `GET`  | `/api/movies/no-director` | Retrieve movies without a director |
| `POST` | `/api/movies`             | Create a new movie                 |
| `PUT`  | `/api/movies/{id}`        | Update an existing movie           |

The service consumes and produces:

```text
application/json
```

### Example JSON

```json
{
  "title": "Inception",
  "genre": "Science Fiction",
  "releaseYear": 2010,
  "description": "A thief who steals corporate secrets through dream-sharing technology.",
  "director": "Christopher Nolan"
}
```

---

## 🔄 REST Layer & EJB Reuse

The REST service does not duplicate the application's data-access logic.

Instead, it reuses the existing remote EJB:

```text
REST Service
     ↓
MovieRemote
     ↓
MovieRemoteBean
     ↓
MovieDao
```

This keeps the REST layer focused on HTTP and JSON communication while the existing business/data-access layer handles movie operations.

---

## 💻 REST CLI Client

The project also includes:

```text
MovieClient.java
```

which uses Java's built-in:

```java
HttpClient
HttpRequest
HttpResponse
```

APIs.

The client:

1. Requests movie information from the user.
2. Builds a JSON request.
3. Sends an HTTP `POST` request.
4. Displays the server response.

The communication flow is:

```text
Java CLI Client
      │
      │ HTTP + JSON
      ▼
   JAX-RS API
      │
      ▼
   Remote EJB
      │
      ▼
      DAO
```

This demonstrates how an external client can communicate with a Jakarta EE application through REST.

---

# 🖥️ JSF Web Interface

The application includes several JSF pages for managing movies.

### Movie List

```text
movies.xhtml
```

Displays the available movies and provides access to movie operations.

### Create / Edit

```text
createMovie.xhtml
```

Provides a reusable form for creating and editing movies.

### Movie Details

```text
movieDetails.xhtml
```

Displays detailed information about a selected movie.

### Filtered Movies

```text
moviesWithoutDirector.xhtml
```

Displays movies that do not have a director assigned.

---

## 🛠️ Technologies

### Backend

* **Java 17**
* **Jakarta EE 10**
* **Maven**
* **WildFly**
* **EJB**
* **JPA**
* **JMS**
* **Message Driven Beans**
* **JAX-RS**

### Web

* **JSF**
* **Jakarta Faces**
* **HTML**
* **XHTML**
* **JSON**

### Client

* **Java HttpClient**
* **HttpRequest**
* **HttpResponse**

### Development

* **IntelliJ IDEA**
* **Maven**
* **WildFly Maven Plugin**
* **Lombok**

---

## ✨ Key Features

✔ Movie catalog domain model

✔ JSF-based web interface

✔ Create, read, update and delete operations

✔ Movie details page

✔ Filtered movie listing

✔ Movies-without-director view

✔ Reusable create/edit form

✔ Stateless EJB

✔ Local EJB interface

✔ Remote EJB interface

✔ External Java client

✔ Asynchronous JMS message processing

✔ JMS Queue

✔ Message Driven Bean

✔ Movie validation inside MDB

✔ JPA entity mapping

✔ JAX-RS REST API

✔ JSON request and response handling

✔ Java HTTP Client

✔ Maven-based build system

✔ WildFly deployment configuration

---

# 🔄 Project Evolution

The Movie Catalog demonstrates how a simple JSF application can gradually evolve into a broader enterprise application architecture.

```text
JSF + In-Memory DAO
     │
     ▼
CRUD + Navigation + Filtering
     │
     ▼
EJB + Local / Remote Interfaces
     │
     ▼
JPA Entity Mapping
     │
     ▼
JMS + Message Driven Bean
     │
     ▼
REST API + JSON + HTTP Client
```

The final application therefore combines multiple enterprise Java concepts in a single project rather than treating each technology as an isolated example.

---

# 📂 Main Movie Catalog Structure

```text
00_JSF101/
│
├── pom.xml
├── README.md
├── .gitignore
│
└── src/
    └── main/
        │
        ├── java/
        │   └── si/
        │       └── um/
        │           └── feri/
        │               └── jee/
        │                   └── sample/
        │                       │
        │                       ├── client/
        │                       │   └── MovieClient.java
        │                       │
        │                       ├── config/
        │                       │   └── ApplicationConfig.java
        │                       │
        │                       ├── dao/
        │                       │   ├── MovieDao.java
        │                       │   ├── MovieDaoLocal.java
        │                       │   └── PersonDao.java
        │                       │
        │                       ├── ejb/
        │                       │   ├── MovieRemote.java
        │                       │   └── MovieRemoteBean.java
        │                       │
        │                       ├── jms/
        │                       │   └── MovieProducer.java
        │                       │
        │                       ├── jsf/
        │                       │   ├── MovieJsfBean.java
        │                       │   ├── PeopleJsfBean.java
        │                       │   └── SampleJSFBean.java
        │                       │
        │                       ├── mdb/
        │                       │   └── MovieMDB.java
        │                       │
        │                       ├── rest/
        │                       │   └── MovieRestService.java
        │                       │
        │                       └── vao/
        │                           ├── Movie.java
        │                           └── Person.java
        │
        ├── resources/
        │   └── META-INF/
        │       ├── beans.xml
        │       └── persistence.xml
        │
        └── webapp/
            ├── index.html
            ├── movies.xhtml
            ├── createMovie.xhtml
            ├── movieDetails.xhtml
            ├── moviesWithoutDirector.xhtml
            │
            └── WEB-INF/
                ├── web.xml
                └── template/
                    └── template.xhtml
```

---

# 🚀 How to Run

## Requirements

Before running the Jakarta EE application, make sure the following are installed:

* **Java 17**
* **Maven**
* **WildFly 39 or another compatible Jakarta EE server**
* **IntelliJ IDEA Ultimate** or another Java IDE

---

## 1. Clone the Repository

```bash
git clone https://github.com/doganozturkk/jakarta-ee-movie-catalog.git
cd jakarta-ee-movie-catalog
```

---

## 2. Enter the Movie Catalog Project

```bash
cd 00_JSF101
```

---

## 3. Start WildFly

Start your local WildFly server and make sure it is available on the default management and application ports.

The project is configured to communicate with WildFly through:

```text
Application: http://localhost:8080
Management:  http://localhost:9990
```

---

## 4. Build the Project

```bash
mvn clean install
```

The Maven configuration includes the **WildFly Maven Plugin** for deployment.

For development mode, the project can also be started with:

```bash
mvn clean wildfly:dev
```

---

## 5. Open the Application

After deployment, the Movie Catalog application is available at:

```text
http://localhost:8080/my-jsf-sample-project/
```

The REST API is available under:

```text
http://localhost:8080/my-jsf-sample-project/api/movies
```

---

# 🌐 Example REST Requests

### Get all movies

```http
GET /my-jsf-sample-project/api/movies
```

### Get movie by ID

```http
GET /my-jsf-sample-project/api/movies/1
```

### Get movies without directors

```http
GET /my-jsf-sample-project/api/movies/no-director
```

### Create a movie

```http
POST /my-jsf-sample-project/api/movies
Content-Type: application/json
```

Request body:

```json
{
  "title": "The Dark Knight",
  "genre": "Action",
  "releaseYear": 2008,
  "description": "A masked vigilante faces a criminal mastermind.",
  "director": "Christopher Nolan"
}
```

### Update a movie

```http
PUT /my-jsf-sample-project/api/movies/1
Content-Type: application/json
```

---

# 📦 Maven Configuration

The Movie Catalog is packaged as a WAR application:

```xml
<packaging>war</packaging>
```

The project uses:

```text
Java                 17
Jakarta EE            10.0.0
WildFly Maven Plugin  5.1.5.Final
Maven WAR Plugin      3.5.1
Lombok                1.18.42
```

The Jakarta EE API provides the APIs required for:

* JSF
* CDI
* EJB
* JPA
* JMS
* JAX-RS

---

# 🎯 Learning Objectives

This project demonstrates the practical application of several enterprise software architecture concepts.

### Web Application Development

* JSF
* Managed beans
* XHTML views
* Navigation
* Form handling

### Enterprise Java

* Stateless Session Beans
* Local interfaces
* Remote interfaces
* Dependency injection
* Layered architecture

### Persistence

* JPA entities
* Entity mapping
* Persistence units
* DAO abstraction

### Messaging

* JMS
* Queues
* Message producers
* Message Driven Beans
* Asynchronous processing
* Message validation

### Web Services

* JAX-RS
* RESTful endpoints
* HTTP methods
* JSON communication
* External clients

### Build & Deployment

* Maven
* WAR packaging
* WildFly
* Jakarta EE deployment

---

# 📝 Notes

Some enterprise examples require a Jakarta EE compatible application server.

The course documentation specifies **WildFly 39** as a verified environment for the examples.

Maven-based projects include their own `pom.xml` files for dependency management and build lifecycle configuration.

The `00_JSF101` project contains the most advanced application in this repository and combines the concepts introduced throughout the six assignments.

The project is intentionally structured as a progressive learning exercise: each assignment adds another architectural concept to the same Movie Catalog domain.

---

## 🎓 Academic Context

This project was developed as part of the **Information Systems Architectures and Patterns** course at the **University of Maribor**.

The Movie Catalog represents the main progressive assignment project, while the remaining folders contain supporting examples and templates used throughout the course.

---

## 📄 License

This project is licensed under the MIT License — feel free to fork it, extend it, and experiment with new ideas!

---

## 🙌 Author

Developed by **[Doğan Öztürk](https://github.com/doganozturkk)**

Computer Engineering Student
University of Maribor / Pamukkale University
