# Mars Space Station Resource App

## This is the Mars CI/CD project for the first lab assignment of the course "Software Engineering in Practise"

### Specifications:
    Maven: 3.9.9
    Java: 17
### Running the app:
    1. Clone
    2. Maven build: mvn clean package
    3. Running:     java -jar target/Mars\_CICD-0.0.1-SNAPSHOT.jar
    4. Application: http://localhost:8080/resources
### And using Docker:
    1. Build image: docker build -t mars\cicd:latest .
    2. Run:         docker run -p 8080:8080 resources:latest
    3. Application: http://localhost:8080/resources

