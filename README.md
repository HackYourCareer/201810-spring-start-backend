# HYC - Spring Start Backend

This is backend part of the application presented on Hack your career lecture on 23.10.2018.

## What it does

It is a simple CRUD REST API to manage a Beer entity with some validation. It is created with [Spring boot](https://spring.io/projects/spring-boot) 

Application exposes following methods:
 * `GET http://locahost:8080/beers` which returns all the beers from the db
 * `GET http://locahost:8080/beers/ID` which returns a beer with requested ID, if such does not exist null is returned
 * `POST http://locahost:8080/beers` which creates new beer and accepts following request body:
```json
{
  "id": 1,
  "name": "Name",
  "description": "Description",
  "alcoholContent": 10.0,
  "ibu": 10
}
```
* `PUT http://locahost:8080/beers/{ID}` which modifies beer with the requested ID, note that request body requires you to provide all data.
* `DELETE http://locahost:8080/beers/{ID}` which removes beer with requested ID form db 

## Getting started

This project require [MySQL](https://dev.mysql.com/downloads/mysql/) database, you can install one on you pc.

Checkout the repository and configure the database connection by modifying `src/main/resources/application.properties`.

```
# Table creation strategy
spring.jpa.hibernate.ddl-auto=update

# Database User
spring.datasource.username=root

# Database User's password
spring.datasource.password=nimda

# Database connection URL, hyc is the name of the Mysql's database
spring.datasource.url=jdbc:mysql://localhost:3306/hyc
```
 
Then open terminal in root folder of the repository and run `./gradlew build` for MacOs and Linux or `bat gradlew.bat build` for windows.
 
You can start the application from your IDE by executing `./gradlew bootRun` for MacOs and Linux or `bat gradlew.bat bootRun` for windows. The application by default is available under `http://localhost:8080` 

## Frontend

This application has the frontend part which is available at this [github](https://github.com/HackYourCareer/201810-spring-start-frontend) repository.
