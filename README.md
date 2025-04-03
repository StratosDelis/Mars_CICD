# Mars Space Station Resource App

## This is the Mars CI/CD project for the first lab assignment of the course "Software Engineering in Practise"

### Specifications:
* Maven: 3.9.9
* Java: 17

### Running the app:
* Clone
* Maven build: `mvn clean package`
* Running:     `java -jar target/Mars\_CICD-0.0.1-SNAPSHOT.jar`
* Application: http://localhost:8080/resources

### And using Docker:

* Build image: `docker build -t mars\_cicd:latest .`
* Run:         `docker run -p 8080:8080 resources:latest`
* Application: http://localhost:8080/resources
