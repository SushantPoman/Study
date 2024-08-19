
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


### Bean lifecycle:
In Spring, the bean lifecycle refers to the stages a bean goes through from its instantiation to its destruction. Let’s explore this process:
1.	Bean Definition Acquisition:
    - The Spring container reads the bean definitions from configuration files (such as XML or Java-based configuration).
    - It acquires the necessary information about the beans, including their class, properties, and lifecycle callbacks.
2.	Bean Creation and Instantiation:
    - The Spring container creates an instance of the bean based on the bean definition.
    - It uses the bean’s class and constructor to instantiate the object.
    - Dependencies are injected into the bean during this phase.
3.	Populating Bean Properties:
    - After instantiation, Spring sets the properties of the bean.
    - Property values are either directly injected or resolved from external configuration files.
4.	Post-Initialization:
    - If the bean implements the InitializingBean interface or defines an init-method, Spring calls the corresponding method.
    - This phase allows you to perform any custom initialization logic for the bean.
5.	Ready to Serve:
    - The bean is now fully initialized and ready for use.
    - It can be injected into other components or accessed by the application.
6.	Pre-Destroy:
    - When the Spring container is shutting down (e.g., during application shutdown), it calls the bean’s destroy-method (if defined).
    - Use this phase to release resources or perform cleanup tasks.
In summary, the Spring container manages the entire lifecycle of a bean, from creation to destruction. You can customize this lifecycle by implementing callback methods or using annotations.
- https://medium.com/@sendvjs/spring-bean-life-cycle-9363332c335e
- https://digitalocean.com/community/tutorials/spring-bean-life-cycle 


### REST API Design Guidelines:
- https://www.javaguides.net/2018/06/restful-api-design-best-practices.html#google_vignette
- https://medium.com/@avocadi/building-restful-apis-with-spring-boot-a-comprehensive-guide-2a7bf72aeea6

### Scopes in spring:
- https://www.baeldung.com/spring-bean-scopes
- https://jayamaljayamaha.medium.com/bean-scopes-in-java-springboot-e1e3c5874b51 - Image
- https://docs.spring.io/spring-framework/reference/core/beans/factory-scopes.html

### Secure Api using Api key and secret:
- https://www.geeksforgeeks.org/securing-spring-boot-api-with-api-key-and-secret/
- https://github.com/SushantPoman/SecureApi/commit/be78b44ae9efaa2e486f82c0f7fbe70813640f74

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
- Apache kafka is like a communication system that helps different parts of computer system exchange data by publishing and subscribing to topics.
- Zookeeper used to manage topics/partition/cluster using api gateway technique.

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

Dockerfile inside springboot:

    FROM openjdk:17
    EXPOSE	8080
    ADD target/kubernetespractice.jar kubernetespractice.jar
    ENTRYPOINT ["java","-jar","/kubernetespractice.jar"]


- Embarkx - https://www.youtube.com/watch?v=BLlEgtp2_i8
- Ashokit - https://www.youtube.com/watch?v=8dccz7ca4FM


## AWS
- Application load balancer
- Route 53
- VPC public and private subnet
- Auto scaling
- cloudfront - cdn, domain name, public and private certificates,
- WAF - web application firewall

## Actuator:
- Provides built in production ready features to monitor and manage your application.
- Provides endpoint like /actuator, /actuator/health, /actuator/metric
- This helps us to monitor data like threads, cache, requests, jvm memory
- Spring boot to actuator provides all this details with the micrometer data provider.
Features:
- Built in endpoints
- Ability to view real time metrics

<img src="images/actuator_endpoints.png" alt="image" width="500" height="auto">

## Micrometer:
- Monitoring system vendors are Prometheus, AWS cloudwatch, Netflix Atlas, Graphana
- All this vendors need data in different different formats to process and display the output in graphical representation - Micrometer converts this metrics data to the vendor required formats. (Taking data from actuator)

## Prometheus:
- It is a in memory dimensional time series database and it is designed to operate on a pool model (It pulls the metrics from application periodically).
- It also supports custom query language and math operation to extract the relevant metrics data
- Imp - https://blog.devops.dev/send-email-alerts-using-prometheus-alert-manager-16df870144a4

## Kubernetes:
Kubernetes is an open-source container-orchestration engine or container management tool, it automates deploying, scaling, and managing containerized application.

- Container - Docker
- Management - Deploying, scheduling, scaling, load balancing, self healing, roll back, monitoring

Components - Pods, Nodes, Cluster, Replica set, Service, Deployment, Secrets, Config Map, ETCD

<img src="images/k8s_master_worker_node.png" alt="image" width="800" height="auto">
<img src="images/k8s_master_node.png" alt="image" width="700" height="auto">
<img src="images/k8s_master_node.png" alt="image" width="700" height="auto">


Set default context:
- docker context use default

Deploy application using commands:
- minikube version
- minikube start --driver=docker (Use docker as platform to make to minikube cluster up)
- minikube status
- kubectl cluster-info
- kubectl get nodes
- minikube docker-env   (Use docker inside minikube)
- copy last line from above cmd output and paste as next cmd
- docker images     (To check docker images)
- docker build -t spring-k8s-practice:1.0 .     (After navigating to project directory)
- docker images     (To check img is created or not)
- kubectl create deployment spring-k8s-practice --image=spring-k8s-practice:1.0 --port=8080
- kubectl get deployment
- kubectl describe deployment spring-k8s-practice
- kubectl get pods
- kubectl logs  (use pod_name here)
- kubectl get deployment
- kubectl expose deployment spring-k8s-practice --type=NodePort
- kubectl get service
- minikube service spring-k8s-practice --url    (To get the url inside container where our application is running)
- minikube dashboard
- kubectl delete service spring-k8s-practice
- kubectl delete deployment spring-k8s-practice
- docker rmi kubernetespractice:1.0 (Image:tag)
- minikube stop \
Application - https://github.com/SushantPoman/KubernetesPractice/commit/5ef37cf101dda23290f7a3ea46f7af2bd1faf7d0

Deploy application using yaml:
- minikube version
- minikube start --driver=docker (Use docker as platform to make to minikube cluster up)
- minikube status
- minikube docker-env   (Use docker inside minikube)
- copy last line from above cmd output and paste as next cmd
- navigate to current project directory
- mvn clean install -DskipTests=true
- docker build -t spring-k8s-practice:1.0 .
- docker images     (To check docker images)
- kubectl apply -f k8s-deployment.yaml
- kubectl apply -f k8s-service.yaml \
Application - https://github.com/SushantPoman/KubernetesPractice/commit/05961da31fd539bcb0f5d8c719826680197a9be7