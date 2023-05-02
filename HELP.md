# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.0.6/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.0.6/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.0.6/reference/htmlsingle/#web)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/3.0.6/reference/htmlsingle/#data.sql.jpa-and-spring-data)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)

## Commands :
* mvn clean package 
* docker build -t dineshbehera/employee-management:latest .
* docker push dineshbehera/employee-management:latest

* docker login --> login to docker hub

* docker pull <<image path>>
<br>
  docker pull dineshbehera/employee-management
* docker run -d -p [host_port]:[container_port] –name [container_name] [image_id/image_tag]
    <br>
  docker run -d -p 8080:8080 --name employee-management dineshbehera/employee-management:latest

  open http:localhost:8080

## For kubernetes :
* kubectl -n developemnt get nodes -o wide
* kubectl -n development get deployments -o wide
* kubectl -n development get pods -o wide
* kubectl -n development get services -o wide


* kubectl -n development create deployment employee-management-manual --image=dineshbehera/employee-management:latest

 or

 * kubectl -n development create -f k8.yaml

