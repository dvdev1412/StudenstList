# Student Management System - Spring Shell Application

This is a simple student management system implemented as a Spring Shell console application. It allows you to perform basic CRUD (Create, Read, Update, Delete) operations on student records. The student data is stored in memory (not persistent), and the application uses events for communication between components.

## Features

- **Display All Students:** View a list of all registered students.
- **Add a New Student:** Create a new student record with first name, last name, and age.
- **Delete a Student:** Remove a student from the system by their ID.
- **Clear All Students:** Delete all student records.

## Technologies Used

- Spring Boot
- Spring Shell
- Docker (for containerization)

## Prerequisites

- **Java Development Kit (JDK):** Ensure you have JDK 21 or later installed.
- **Docker:** You'll need Docker installed and running to build and run the application in a container.

## Getting Started

1. **Build the Project:**
  - Open your terminal/command prompt and navigate to the project's root directory.
  - Run the following command to build the project and create the executable JAR file:
    ```bash
    .\gradlew.bat build
    ```

2. **Build and Run the Docker Image:**
  - **Using Docker Compose (Recommended):**
    - Make sure you have `docker-compose.yaml` configured correctly.
    - Run the following command:
      ```bash
      docker-compose up --build
      ```
      This will build the Docker image, start the Redis container, and then run your Spring Shell application.

  - **Building the Image Manually:**
     ```bash
     docker build -t students-list .
     ```
  - **Run the Image:**
     ```bash
     docker run -it --name my-students-list students-list 
     ```

3. **Interact with the Shell:**
  - You will see the shell prompt (`student-shell>`). Now you can start using the shell commands.



## Shell Commands

| Command                  | Description                                  | Example Usage                             |
| ------------------------- | -------------------------------------------- | ------------------------------------------ |
| `display all students`   | Display a list of all students.             | `display all students`                    |
| `Add <firstName> <lastName> <age>` | Add a new student.                         | `Add John Doe 25`                         |
| `deleteStudent <id>`      | Delete a student by their ID.               | `deleteStudent 1`                         |
| `clearAllStudents`       | Clear all student records.                 | `clearAllStudents`                        |


## Configuration

By default, the application will attempt to create three sample students when it starts. You can disable this behavior by setting the following property in your `application.properties` (or `application.yml`) file:

```properties
studentmanagement.create-students-at-startup=false
