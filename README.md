# Monster-Hunter-Logbook

This project will allow a hostable web application that will allow users to create an account, add,update and delete monsters and for each monster have editable logs.

## How To run this application

### Requirements

1. Java 8 - added to the **path**
2. maven
3. h2database
4. wildfly

### h2database

download the h2 jar here - http://repo2.maven.org/maven2/com/h2database/h2/1.4.197/h2-1.4.197.jar
run a terminal or command promt at the same location as this jar file type in,
                                java -jar h2-1.4.197.jar
the h2 database should be viewable at localhost on port 8082 e.g. http://localhost:8082
if you do not have java installed on your path this may not work.

### wildfly
This project was developed using wildfly-10.1.0.Final

wildfly uses by default the h2 database as an in-memory database
in order to prevent this add the following into the standalone.xml inside the folder
                            \wildfly-XX.X.X\standalone\configuration
find the following lines
```
<datasource jndi-name="java:jboss/datasources/ExampleDS" pool-name="ExampleDS" enabled="true" use-java-context="true">
    <connection-url>jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE</connection-url>
    <driver>h2</driver>
    <security>
        <user-name>sa</user-name>
    </security>
</datasource>
```
This is the example data source that wildfly server uses by default that will connect with an in-memory h2 database.
to connect to a persistance database directly ,underneath the above block of text add the following
```
<datasource jta="true" jndi-name="java:jboss/datasources/MyApplicationDS" pool-name="MyApplicationDS" enabled="true" use-ccm="true">
    <connection-url>jdbc:h2:tcp://localhost/~/test;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE</connection-url> 
    <driver-class>org.h2.Driver</driver-class>
    <driver>h2</driver>
    <security>
        <user-name>sa</user-name>
    </security>
    <validation>
        <background-validation>false</background-validation>
    </validation> 
</datasource> 
```
Doing this will allow the wildlfy server to use our local hosted h2 server instead of wildfly's in memory database.
When you connect to the database in a web browser your username should be sa with no password.

Using maven, run mvn install on the project and take the created .war file, place it in the deployments folder of your wildfly server.
if you do not want to run the tests use the command mvn install -DskipTests.

wildfly will run the http server on port 8080, to see the website the address is your localhost on port 8080 with name-of-war-file Replaced with the name of the .war file,
created using the mvn install command.
                                 http://127.0.0.1:8080/name-of-war-file/

this will take you to the index page of the website, use the navigation bar to go to userm which will let you register as a user
and login using you username and password. monsters will take you to a page which displays all currently added monsters, if you
are logged in as a user you can add your own monsters or edit and even delete them, by clicking on the name of the monster you
can see all of you logs for that monster, on this page you can create new logs, delete your old ones if you want and edit a log.

### Tests
This project includes 16 headless tests that use selenium and chrome driver to perform these tests.
The current test coverage is 32.9%
