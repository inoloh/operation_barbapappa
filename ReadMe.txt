READ ME

This is a small REST application that’s letting you manage animals at a zoo using Wildfly, MySQL ,Maven and JPA. 


--Run the application: 
Use the terminal  to the docker directory.
1.	Docker-compose build 
2.	Docker-compose up

--Content:

docker: 
.env = Environment variables for the sqlseMySQL and the Wildfly server. 


--parameters:

provides a Json response with all the animals In the database.
  http://localhost:8080/operation_barbapappa-1.0-SNAPSHOT-war/fantastic-world/animals
  
provides a Json response with the animal with id <id>.
  http://localhost:8080/operation_barbapappa-1.0-SNAPSHOT-war/fantastic-world/animals/<id>


provides a Json response with all the animals with health status “SICK” 
  http://localhost:8080/operation_barbapappa-1.0-SNAPSHOT-war/fantastic-world/animals/sick

Let’s you change the health status on the animal by providing id and the options “SICK”,”HEALTHY”,”DEAD” . 
  http://localhost:8080/operation_barbapappa-1.0-SNAPSHOT-war/fantastic-world/animals/updatehealth?animalid=<id>&status=<healtStatus> 

Lets you remove a animal from the database granted that you provide a available id. 
  http://localhost:8080/operation_barbapappa-1.0-SNAPSHOT-war/fantastic-world/animals/execute/<id>

Java Client: https://github.com/inoloh/operation_barbamamma
A smal java client to test the rest aplication. 
