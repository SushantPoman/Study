
### Why Spring Boot for Microservices?:
Spring Boot is an excellent choice for microservices development due to its features:
- Embedded Server Support: Spring Boot includes embedded servers (like Tomcat or Jetty), simplifying deployment.
- Load Balancer: It supports load balancing for distributing requests across instances.
- Auto Configuration: Spring Boot automatically configures components based on conventions.
- Minimal Code using Annotations: Annotations reduce boilerplate code.
- Loose Coupling: Microservices can be independently developed and deployed.
- Dependency Management: Spring Boot manages dependencies efficiently.
- Open Source: It’s a vibrant open-source community1.

### Spring boot disadvantages:
- Lack of Control:
Spring Boot abstracts away much of the configuration and setup, which can be beneficial for rapid development.
However, this opinionated design may not suit projects with unique requirements.
Developers might feel limited in customization due to Spring Boot’s predefined conventions1.
- Large Deployment File Size:
Spring Boot creates many unused dependencies, resulting in a larger deployment file.
This can impact deployment time and resource utilization.
If minimizing the deployment size is critical, developers need to be cautious23.
- Conversion Process:
Converting an existing Spring project into a Spring Boot application can be complex and time-consuming.
Developers may face challenges when migrating legacy code to Spring Boot23.
- Not Suitable for Large-Scale Projects:
While Spring Boot is excellent for microservices and smaller applications, it might not be the best fit for large-scale projects.
For extensive enterprise-level systems, other Spring frameworks or custom configurations may be more appropriate23.
Remember that Spring Boot’s benefits often outweigh its disadvantages, especially for smaller projects or when rapid development is crucial. However, understanding these limitations helps make informed decisions when choosing the right framework for your specific use case


## Actuator:
Provides built in production ready features to monitor and manage your application.
Features:
- Built in endpoints
- Ability to view real time metrics

<img src="images/actuator_endpoints.png" alt="image" width="500" height="auto">

## Redis cache:
Remote Dictionary Server, aka Redis, an in-memory data store, is one of the many options for implementing caching in Spring Boot applications due to its speed, versatility, and simplicity of use. It is a versatile key-value store that supports several data structures, such as Strings, Sorted Sets, Hashes, Lists, Streams, Bitmaps, Sets, etc., because it is a NoSQL database and doesn’t need a predetermined schema.
Use the following steps to configure any given cache provider:
1. Add the @EnableCaching annotation to the configuration file.
2. Add the required cache library to the classpath.
3. Add the cache provider configuration file to the root classpath.

https://github.com/SushantPoman/UserService/commit/a4b0131deda0ed55facc969b0d0a128c215f59a4
https://medium.com/simform-engineering/spring-boot-caching-with-redis-1a36f719309f

## Feign:
Declarative web service client designed to make writing HTTP clients easier

- Embarkx - https://www.youtube.com/watch?v=EeQRAxXWDF4&t=1s

## Zipkin:
Is an open-source distributed tracing system

- Embarkx - https://www.youtube.com/watch?v=EeQRAxXWDF4&t=1s

## Kafka:
Apache kafka is like a communication system that helps different parts of computer system exchange data by publishing and subscribing to topics.

<img src="images/kafka_archi.png" alt="image" width="500" height="auto">

- Publishing topics: https://github.com/SushantPoman/OrderService/commit/70aa7903ca3ca5b59bc9ec7f3ac368b22839f567
- Subscribing topics: https://github.com/SushantPoman/UserService/commit/6701600c8d32b6060b8307d6c93cf2d049887685

References:
- Official - https://kafka.apache.org/documentation/
- Durgesh - https://www.youtube.com/watch?v=ei6fK9StzMM
- AshokIt - https://www.youtube.com/watch?v=19n9usmc2l8

## Jenkins:
Jenkins is used to automate build and deployment process
- AshokIt - https://www.youtube.com/watch?v=4cG7dWKbrC8


## Docker:
Docker is a open source platform for developing, shipping and  running application in  containers. Containers are light weight, isolated environment that package applications and their dependencies. 

- Images - Docker images are the templates that define the container and its dependencices
- Container - Containers are runtime environments created from docker images
- Docker engine - The docker engine is the runtime that runs and manages containers
- Dockerfile -  Is a file that contains instructions to build a Docker image
- DockerHub - DockerHub is cloud based registry that hosts a vast collection of Docker images

create img from mvn wrapper:
./mvnw spring-boot:build-image "-Dspring-boot.build.image.imageName=dcode007/companyms"

- Embarkx - https://www.youtube.com/watch?v=BLlEgtp2_i8
- Ashokit - https://www.youtube.com/watch?v=8dccz7ca4FM