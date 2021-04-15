# Basic Login with Struts2 - CZ3002 Assignment 2 S2-2020/2021

Simple Login web application made by group 43: Tran Anh Tai, Cai Zixin and Clawrence Chew Kai Wei using 
[Struts](https://struts.apache.org/) framework.

## Installation

#### This guideline is corresponding with following setup:
 
- [Intellij](https://www.jetbrains.com/idea/) to build the web application. 

- [JDK](https://www.oracle.com/sg/java/technologies/javase-downloads.html) version is 11.1.0.

- Latest [maven](https://maven.apache.org/) version is installed.

- [MySQL Server](https://dev.mysql.com/downloads/mysql/) is installed.


#### Important Java dependencies used within our application:

- [Mockito](https://site.mockito.org/)

- [Junit](https://junit.org/junit4/) 

- [Struts](https://struts.apache.org/)

- [Ecllipse Jetty](https://www.eclipse.org/jetty/)

- [mysql-connector-java](https://mvnrepository.com/artifact/mysql/mysql-connector-java)

More details for other dependencies as well as their versions could be found in [pom.xml](https://github.com/saobangmath/Basic-Struts/blob/master/pom.xml)

To install those required Java dependencies in [pom.xml](ttps://github.com/saobangmath/Basic-Struts/blob/master/pom.xml), execute:

```
mvn clean install
```

#### To setup the database for the  webapplication, 

- Execute [db_user.sql](https://github.com/saobangmath/Basic-Struts/blob/master/src/sql/db_user.sql) 
with root privilege.

- Make sure to update DB_USERNAME and DB_PASSWORD in [DBController.java](https://github.com/saobangmath/Basic-Struts/blob/master/src/main/java/cz3002/grp43/struts/login/service/DBController.java)
as your own privilege user setup in your local machine.

Now you are good to go!

## Start the web application

To start the jetty web application,
```
mvn jetty:run
```
Access [http://localhost:8080/BasicStrutsApp/index.jsp](http://localhost:8080/BasicStrutsApp/index.jsp) to start using the web application


## Screenshots References
Here is the screenshots of important scenarios in our login web application

### Default login Page 

![](/img/default-login.PNG)

### Unsucessful login - Missing username or password

Sample credential:
- username = "trtai" 
- password is empty

![](/img/missing-input-login.PNG)

### Unsucessful login - User not in the database
Sample credential:
- username = "fake_user" 
- password = "fake_password"

![](/img/invalid-user-login.PNG)

### Successful login 

Sample credential:
- username = "trtai" 
- password = "trtai"


![](/img/successful-login.PNG)
