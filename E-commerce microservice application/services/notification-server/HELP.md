# Read Me First
The following was discovered as part of building this project:

* The original package name 'com.kiran.notification-server' is invalid and this project uses 'com.kiran.notification_server' instead.

# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.3.1/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.3.1/maven-plugin/reference/html/#build-image)
* [Config Client Quick Start](https://docs.spring.io/spring-cloud-config/docs/current/reference/html/#_client_side_usage)
* [Eureka Discovery Client](https://docs.spring.io/spring-cloud-netflix/docs/current/reference/html/#service-discovery-eureka-clients)
* [Spring for Apache Kafka](https://docs.spring.io/spring-boot/docs/3.3.1/reference/htmlsingle/index.html#messaging.kafka)
* [Java Mail Sender](https://docs.spring.io/spring-boot/docs/3.3.1/reference/htmlsingle/index.html#io.email)
* [Spring Data MongoDB](https://docs.spring.io/spring-boot/docs/3.3.1/reference/htmlsingle/index.html#data.nosql.mongodb)
* [Thymeleaf](https://docs.spring.io/spring-boot/docs/3.3.1/reference/htmlsingle/index.html#web.servlet.spring-mvc.template-engines)

### Guides
The following guides illustrate how to use some features concretely:

* [Service Registration and Discovery with Eureka and Spring Cloud](https://spring.io/guides/gs/service-registration-and-discovery/)
* [Accessing Data with MongoDB](https://spring.io/guides/gs/accessing-data-mongodb/)
* [Handling Form Submission](https://spring.io/guides/gs/handling-form-submission/)

### Maven Parent overrides

Due to Maven's design, elements are inherited from the parent POM to the project POM.
While most of the inheritance is fine, it also inherits unwanted elements like `<license>` and `<developers>` from the parent.
To prevent this, the project POM contains empty overrides for these elements.
If you manually switch to a different parent and actually want the inheritance, you need to remove those overrides.
