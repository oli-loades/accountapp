# accountapp
Simple account management webapp created using Spring-boot and Vue.js.

-   [Spring boot](https://spring.io/projects/spring-boot) for web servicess and access to mysql

-   [Vue JS](https://vuejs.org/) for creation of web pages and user interfaces

-   [MySQL](https://www.mysql.com/) for relational data storage

-   [Docker](https://www.docker.com/) Removes the need to setup mysql database

## Prerequisite
- Maven 
- Node js
- Docker

## Backend Build Setup
``` bash
# navigate to backend directory
cd backend

# build and strat MySQL image
make docker_start_mysql

# build and start spring-boot project
make docker_start_accountapp
```

## Frontend Build Setup

``` bash
# navigate to backend directory
=======
>>>>>>> 4005d032b6023e49c46272b2c4661e780e2f0c90
cd frontend/accountapp

# install dependencies
npm install

# serve with hot reload at localhost:8080
npm run dev

```
go to localhost:8080 to view the webapp

