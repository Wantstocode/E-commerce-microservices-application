
# ⚡ Microservices E-Commerce System

A production-style **event-driven microservices architecture** built using Spring Boot and modern cloud-native technologies.

This system is composed of the following independent services:

- 🧑 Customer Service  
- 📦 Product Service  
- 🛒 Order Service  
- 💳 Payment Service  
- 📩 Notification Service  

Each service is independently deployable and follows the **database-per-service pattern**, ensuring loose coupling, scalability, and data isolation.

---

## 🏗️ Architecture Overview

This project demonstrates real-world distributed system design patterns:

- 🔁 **Event-Driven Communication** using Apache Kafka  
- 🔍 **Service Discovery** via Eureka Server  
- 🌐 **API Gateway Pattern** for centralized routing  
- 🔐 **Authentication & Authorization** using Keycloak  
- 🐳 **Containerized Deployment** with Docker & Docker Compose  
- 📊 **Monitoring & Observability** using Prometheus & Grafana  

The system is designed with scalability, resilience, and production-readiness in mind.

---

## 🧩 Tech Stack

**Backend**
- Java
- Spring Boot
- Spring Cloud
- Apache Kafka

**Infrastructure**
- Eureka Server
- API Gateway
- Keycloak
- Docker & Docker Compose

**Monitoring**
- Prometheus
- Grafana

---

## 🚀 Running the Application (Docker – Recommended)

### 1️⃣ Build All Services

```bash
mvn clean package -DskipTests
````

### 2️⃣ Start the Entire System

```bash
docker-compose up -d
```

All services, infrastructure components, and monitoring tools will start automatically.

---

## 💻 Running Without Docker

### 1️⃣ Build Each Service

Navigate into each service directory and run:

```bash
mvn clean verify -DskipTests
```

### 2️⃣ Start Services Individually

```bash
mvn spring-boot:run
```

### ⚠ Recommended Startup Order

1. Eureka Server
2. Keycloak
3. API Gateway
4. Core Services (Customer, Product, Order, Payment, Notification)

---

## 📊 Observability & Monitoring

* Prometheus collects metrics from services.
* Grafana provides visualization dashboards.
* Enables real-time monitoring of service health and system performance.

---

## 🎯 Engineering Concepts Demonstrated

* Microservices Architecture
* Event-Driven Systems
* Service Discovery Pattern
* API Gateway Pattern
* Centralized Authentication & Authorization
* Containerized Deployment
* Production Monitoring & Observability
* Distributed System Communication

---

## 📌 Key Highlights

✔ Independent database per service
✔ Loose coupling via Kafka events
✔ Centralized security with Keycloak
✔ Fully containerized environment
✔ Real-world scalable architecture
