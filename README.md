# LEARNING MANAGEMENT SYSTEM

## Description

LMS is a web application built using Java Spring Boot for managing learning management system
functionalities. It allows administrators, teachers, and students to interact with courses, assignments, grades, and
more.

## Features

- User roles: Admin, Teacher, Student
- Admin can manage users, courses, groups, and lessons
- Teachers can manage attendance, upload content, create tasks, grade assignments, and communicate with students
- Students can view their records, access course content, submit assignments, and communicate with teachers

## Technologies Used

- Java Spring Boot
- Spring Security
- Hibernate/JPA
- Thymeleaf (for server-side templating)
- React (for frontend components)
- PostgreSQL (as the database)
- Maven (for dependency management)
- liquibase
- Websocket
- Amazon S3

## Setup Instructions

1. Clone the repository: `git clone https://github.com/NicatQuliyev601/lms-project.git`
2. Navigate to the project directory: `cd lms-project`
3. Set up the PostgreSQL database and update the `application.properties` file with your database configuration.
4. Build the project using Maven: `mvn clean install`
5. Run the application: `mvn spring-boot:run`
6. Access the application at: `http://localhost:8080`

## Additional Configuration

1. If you want to change the default port (8080), you can modify the application.yml file located in src/main/resources
   and set the desired port.

2. The application is already configured to use the MySQL instance provided by Docker Compose. You can find the
   connection properties in the application.yml file.

## Usage

1. Register as a user or log in with existing credentials based on your role (Admin, Teacher, Student).
2. Navigate through the dashboard to access different functionalities based on your role.
3. Create courses, manage assignments, grade submissions, and interact with users as needed.

## Contributors

- [Nicat Quliyev](https://github.com/NicatQuliyev601)


