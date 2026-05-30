# Bug Management API 
Bug Management API is a Spring Boot REST application designed to provide a secure and efficient platform for managing software bugs and user accounts. The application implements authentication and authorization using Spring Security and JWT, ensuring that protected resources are accessible only to authenticated users based on their assigned roles. It supports both standard user operations and administrative functionality through a set of RESTful endpoints, following a role-based access control approach.

The application follows a layered architecture based on the Controller–Service–DAO–Database Model pattern, promoting a clear separation of concerns, maintainability, and scalability. It also uses Controller Advice to handle exceptions across the application.

For development purposes, the application uses the embedded H2 database, which is included out of the box and requires no additional setup. The H2 Console is also available, allowing developers to inspect the database and execute SQL queries directly from the browser, making testing and debugging more convenient during development.

All REST endpoints are documented and accessible through Swagger UI, enabling interactive API exploration and testing directly from the browser or using third-party tools such as Postman.
