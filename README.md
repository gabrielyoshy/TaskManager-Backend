# Getting Started


This project is based on Spring Boot [Spring Boot](https://spring.io/projects/spring-boot) in the Backend and AngularJS in the Frontend To see the front end, follow the link  [TaskManager-Frontend](https://github.com/gabrielyoshy/TaskManager-Frontend).
The database used is [MySql](https://www.mysql.com/) and to start the project it is necessary to have a database called TaskManager

## Installation

To run this application it is necessary to open a terminal and execute the following:  

### update aplication.properties (DataSourceAutoConfiguration & DataSourceProperties)

spring.datasource.username= [database_user]
spring.datasource.password=[database_password]

### start the process associated

Runs the Backend.<br />
Open [http://localhost:9090](http://localhost:9090).


The server will respond to the following requests For example:

### `(Projekt list)` 
### http://localhost:9090/taskmanager/projekt/list
    
    Response: JSON



### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.2.4.RELEASE/maven-plugin/)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.2.4.RELEASE/reference/htmlsingle/#boot-features-jpa-and-spring-data)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.2.4.RELEASE/reference/htmlsingle/#boot-features-developing-web-applications)

### Guides
The following guides illustrate how to use some features concretely:

* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Accessing data with MySQL](https://spring.io/guides/gs/accessing-data-mysql/)
* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)

