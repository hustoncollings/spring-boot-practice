# spring-boot-practice
Practice project connecting spring boot rest api services to MySQL and serving JSONs through http

**Setting up the project**
I used intelliJ to run this project, but it would run with mvn in the command line as well. You have to change the application.properties under src/main/resources to the configuration of your MySQL server. This will serve up specific objects from a MySQL table in JSON format using http. The object can be found in src/main/java/com/huston/Entity/Student.java and it is just an object of a Student that holds an ID, a class name, and a student name.
