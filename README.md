This microservices project comprises Customer, Product, Order, Notification, and Payment services, utilizing an event-driven architecture to ensure seamless communication and integration between components.
<br>
-> Each service has its own database, ensuring data isolation and scalability.<br>
-> Leveraged Kafka for event-driven communication, Eureka server for service registration, and API Gateway with Keycloak for security.<br>
-> Dockerized the entire application for seamless deployment and coordination of services.<br>
-> Integrated Prometheus and Grafana for comprehensive monitoring and observability of the system.


## How to run the application using Docker

1. Run `mvn clean package -DskipTests` to build the applications and create the docker image locally.
2. Run `docker-compose up -d` to start the applications.

## How to run the application without Docker

1. Run `mvn clean verify -DskipTests` by going inside each folder to build the applications.
2. After that run `mvn spring-boot:run` by going inside each folder to start the applications.



