# HiringBoard Project

The HiringBoard project is a mini application built with Spring Boot for the backend and Angular for the frontend. The main purpose of this project was to put into practice the knowledge acquired while learning the Spring framework. 

## Prerequisites


Before you start, ensure you have the following tools and software installed:

- Angular CLI
- Node Package Manager (NPM)
- Java Development Kit (JDK) version 21 or higher
- Apache Maven
- Database (in this project, PostgreSQL is used)

## How to Run

Follow these steps to set up and run the HiringBoard project:

1. **Clone this repository to your local machine.**

    ```bash
    git clone <url>
    ```

2. **Start the Backend:**
    - Install Maven dependencies.
    - Configure the `application.properties` file to match your database settings, including the database URL, username, and password.
    - Run the Spring Boot application using your preferred IDE or by running the following command:

    ```bash
    mvn spring-boot:run
    ```

3. **Run the Frontend:**
    - Change your working directory to the `frontend` folder within the project.

    ```bash
    cd hiring-board/frontend
    ```

    - Install the required Node modules using NPM:

    ```bash
    npm install
    ```

    - Launch the Angular development server:

    ```bash
    ng serve
    ```

   This will start the Angular application and make it accessible in your web browser.

## Accessing the Application

Once you have completed the steps above, you can access the HiringBoard application by opening your web browser and navigating to [http://localhost:4200](http://localhost:4200).

You are now ready to explore and interact with the HiringBoard project.

## Purpose
This is a project used for study purposes only.
The primary motivation for this project was to gain hands-on experience with the Spring framework.
