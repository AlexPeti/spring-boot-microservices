# spring-boot-microservices
A project showcasing microservices architecture using Spring Boot 3.2.4 and Java 17

This project's aim is showcasing the basic structure of a microservices architecture, their essential components
and their interactions within a microservices ecosystem.

Key elements include the use of a Eureka server for service discovery, which enables microservices to locate and 
communicate with each other. Centralized configuration management is provided through the Spring Cloud Config server. 
The API Gateway Service is responsible for routing requests and implementing filters, ensuring that only authenticated 
users with a valid JWT have access to protected endpoints. The Identity Service leverages Spring Security for handling 
registration, authentication, as well as JWT issuance and validation. Lastly, a test endpoint is included to evaluate 
the effectiveness of the Gateway Service.

