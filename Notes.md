Notes:


29-35-SBMS-17-NOV-23 - Hibernate - Database with mysql, spring boot
Hibernate is ORM tool
Java object representing table name called as Entity
-hibernate.cfg.xml - define all the configuration - db url, username, pwd
-HibernateConfig - class to instantiate SessionFactory
hibernate-core starter - to use db with hibernate
mysqldrive - communcating with db
Entity - mapped with hibernate.cfg.xml
- Dao all the methods manually starting the transaction and taking care about all the operations
Advantage: No need to write basic sql query, for complex query you can write hquery language

30-35-SBMS-20-NOV-23 -
ddl-auto - create
ddl-auto - update 
ddl-auto - validate -> migration versioning tools(Flyway, Liquibase) -> migrations of db version
Never take primitive data type for Entity(table creation) - first record it will store default value and then it will lead to nullpointer ..

@GeneratedValue(strategy = GenerationType.AUTO) - Create new table hibernate_sequence to get next primary
Problem - if we have two projects/tables/individual services in same database and if we are using above param then wrong primary key will get inserted because they are sharing primary key generation table
@GeneratedValue(strategy = GenerationType.IDENTITY) - Check from table what was the last primary key and then it will insert next one

36-35-SBMS-29-NOV-23
ORM - object is directly mapping with your table. you can perform operation on entity using sessionFactory and transaction it will update your table in db.
Diff(V. imp):
session.get - directly taking from db
session.load - hibernate maintain cache and while retrieving check in first level cache and if is not there then it will take from db else it will give from cache.(To improve performance)
fail_on_empty_beans - if empty bean is try to convert to json, spring will give emptyBeanException to solve it create DTO object

@Transactional - if we are using this then we can avoid transaction.commit(). 
2 Types of transaction management:
1. declrative - @Transactional
2. programmatical - once DML operation is completed, detatched object will commit by using transaction.commit().


32-35-SBMS-22-NOV-23 - 
Due to heavy configuration spring boot suggested to use Spring DataJPA with autoconfiguration
No need to write - hibernate.cfg.xml, HibernateConfig, Dao - session & transaction mgmt
Spring DataJpa -> ORM(hibernate)+autoconfiguration
Repositories - CrudRepository -> PagingAndSorting -> JPA
Without default constructor ORM tool will not work due to reflection api-53:55

33-35-SBMS-23-NOV-23 -
Named query method - 24:04 (Just need to declare the method, internally i)
Sytax - (Any_name)By_Col_name

34-35-SBMS-24-NOV-23 - 
nativeQuery = true -> Telling db that no conversion required
PagingAndSorting Repository - Child class of CrudRepository

35-35-SBMS-27-NOV-23 -
If we are using JDBC Statement/PreparedStatement/CallableStatement by defaultly after every statement execution your data is going to be commited(Permanently save). Because of this for which transaction application faced issue from that point it will stop processing and will not rollback previous queries.(E.g. Debit and credit - in this both the stmts has to be success or failure)
Group of stmt which are dependent on each other called as Unit of work. Unit of work should be successful if both the stmt are success.
All the stmt should be successful else if any exception occurs then previous stmt should be rollback, this is called as TransactionManagement.
Solution(Manual/Programmatical Transaction Mgmt):
1. If we are doing this in jdbc then we need to set con.setAutoCommit(false) - 48:12
2. After all processing the con.commit()

In jdbc - by default transaction mgmt(commit) is true and in hibernate(ORM tool) we need to manually begin the transaction and commit it, bcoz there transaction mgmt is manual.

Solution(Declarative Transaction Mgmt):
If we don't want this then we can use @Transactional - so ORM tool will make sure that if all the stmt are success or not and if any exception occurs then it will revert all the stmt.
@Transactional - we can define on method or class level
To define unit of work on method level or class level we use @Transactional
Spring data - By default every repository is annotated with @Transactional internally it will take care
If we have two microservices then keep both (userRepo.save(), userRepo.update() and orderRepo.save(), orderRepo.update()) in one method and define that method as @Transactional

36-35-SBMS-29-NOV-23
Communicate one ms with another ms, spring offers RestTemplate. supported by Spring boot.
Similary we were using HttpClient till Spring 4 after that it is deprecated.
RestTemplate is not developed by us we need to use it in further development using autowired. so we need to create configuration class.
if we want to use predefined classes(not created by us) then we need to annotate them using @Bean. @Bean annotated methods added in Configuration class will be taken care by IOC.

37-35-SBMS-30-NOV-23
Spring cloud - Collection of libraries which will solve commonly occured microservice communication, tracing, fault tolerance(circuit breaker - no downtime), metrics of application - actuator.
Discovery server - internal service communication, external service communication
Actuator - metrics(MS up and running, how much memory consuming, traffic about MS)
Tracing - sleuth(how request is processiong, failing in MS environment)
Circuit Breaker - Fault tolerance - Hystrics/Resilience4j

Discovery server - if one MS is communicating with another MS and if we need to change address/port no then that MS will have downtime to avoid this for MS communication we can use Discovery server -> consul by hashicorp, eureka from spring cloud.
if we use consul it is a master-slave approach. In consul you need to harcode address and port of other MS. so one MS will ask address to consul for another MS so in case of any change we need to start consul which cause downtime to avoid that we use eureka.
Eureka- server-client approach. Convert all MS to eureka client. Client will register itself to discovery server. Instead of address and port we are using name to communicate with other MS.

Swagger
api - all the core logic which requires to generate api
ui - dashboard

38-35-SBMS-01-DEC-23
Access eureka server on - http://localhost:8761/
orderservice.addr=http://ORDERSERVICE -> this is logical name
Based on logical name eureka server will resolve then it will give you actual url and port no.
Horizontal load balancing - Same MS you can run with 2 instances 1:13:50 by changing the port
2 instances will work like roundrobin
Vertical scalability - Increasing system capability(currently using 20Gb ram and add 30Gb ram)
Horizontal scalability - Same application splitting into multiple instance(Only eureka does)
EurekaService -> UserService and OrderService - This we called as internal MS communication
(Who are not belonged to MS ecosystem wants to communicate with our MS and because of port and address it became as tight coupling)Angular/React/Android UI wants to communicate with our service - This called as external MS communication
if we change address/port_no then To solve that we will use Api gateway
EurekaServer -> Once it got hit then it will resolve logical name and redirect to MS
Changed project - EurekaService, UserService, OrderService

39-35-SBMS-04-DEC-23
Api gateway - It will register all the MS with them and it will give some routes and based on routes it will delegate the request to respective MS
E.g. Nginx - manually you need to add all the server ip, port no and it becomes hardcoded.
Spring cloud earlier used zuul proxy developed by netflix(Stoppped further release due to licensing issue), later spring cloud people developed Cloud gateway(Both configuration is same). spring cloud gateway is one of the Api gateway.
New project - Gateway, Spring web
Routes addition - 37:29
Predicate - some prefix and suffix(kind of identifier)
In ApiGateway - we are using hardcoded urls of userservice and orderservice to avoid that we can make apiGateway eureka client then we can use eureka client names of user and orderservice
eg. http://localhost:8080(Userservice) -> lb://UserService(Name of MS)
Changed project - ApiGateway


40-35-SBMS-05-DEC-23
Actuator - One of the library offering from the spring cloud, if you want to collect the metrics of the application/monitor your application/Understand traffic of application
URL - http://localhost:8080/actuator
By default it will expose very few endpoints, Add following line to expose all the endpoints-
management.endpoints.web.exposure.include=*
Http traffic- 
management.endpoints.jmx.exposure.include=*
URL - http://localhost:8090/actuator/metrics/http.server.requests
Changed project -> Orderservice

Spring boot admin(independent library, community project) - Monitor your application graphically by dashboard.
Add @EnableAdminServer in main file
URL - http://localhost:7090
In other MS add dependency in pom.xml and set below property in application.properties
spring.boot.admin.client.url=http://localhost:7090
Changed project -> AdminService, UserService, OrderService
Earlier they used dynatrace(commercial) for analytics
In background spring boot admin is fetching data from actuator who have all the info.
Without Actuator, admin server will not work.
Actuator/Spring boot admin - give metrics of application - if we have 100 of MS and want to identify how many instances are running that we can easily do by Admin server.(Monitoring)


41-35-SBMS-06-DEC-23
In MS environment, one request can hit multiple MS so in that case if get failure from any of the microservice then to find out that we can use Sleuth.
To trace/debug the request we use Spring cloud Sleuth.(Used for distributed tracing)
Spring cloud sleuth id is distributed tracing so whenever MS propogating multiple MS then it will create some kind of tracingId. Through this tracingId we are going to be checking all this things.
Earlier every request they were creating correlation id passing in each MS header for tracing.
Every request sleuth add - [appName, tracingId, spanId]
tracingId - same throughout all the MS, to check original MS
spanId - for your application
Steps - Add the dependency
How you will trace your MS communication - Using tracingId
By the time we are using Sleuth but this is CMD line oriented to simplify this we can use zipkin server. It will give dashboard for you.
Download jar from- https://repo1.maven.org/maven2/io/zipkin/java/zipkin-server/2.12.9/



42-35-SBMS-08-DEC-23
To make application reliable and secure we need to use fallback mechanism.
If something goes wrong then we need to have backup plan, called as fallback mechanism(Abnormally if anything goes wrong)
To avoid cascade failure of MS this will help you. This is not related to MS but related to architecture.
Cascade failure - domino effect - one MS failure causes another MS failure
Preparing fallback plan called as fallback mechanism.
To implement fallback mechanism we have design pattern called as circuit breaker DP.
Design pattern - solution for common and repeated pattern in proper way
To implement this spring people give us Hystrix
some fallback plans from developer side ->
- Return with some message
- Retry
- Intermediate cache(kafka)
- Having default items(temporary db)
Instead of writing logic at developer side, use hystrix.
Due to the conflict between netflix and pivotel, hystrix is deprecated. Hystrix people guiding to use Resilience4j(inspired by hystrix)

Resilience4j will take the help of spring AOP and it will going to be depending on the actuator(To monitor health of the application).
For this we need - AOP and Actuator

You can define circuit breaker on class or method level.

Add @CircuitBreaker(name = "orderFallback") for one endpoint method in controller.
Add Fallback properties(Resilience4j) -

States fo circuit - open, half-open, closed
resilience4j.circuitbreaker.configs.default.register-health-indicator=true
if 50% of request failing then circuit will be open. After circuit opens then only fallback plan will happen. Once specific threshold the reached then circuit will be open, to defing this use sliding window size.
resilience4j.circuitbreaker.configs.default.sliding-window-size=10
resilience4j.circuitbreaker.configs.default.minimum-number-of-calls=5
resilience4j.circuitbreaker.configs.default.permitted-number-of-calls-in-half-open-state=3
resilience4j.circuitbreaker.configs.default.wait-duration-in-open-state=5000
resilience4j.circuitbreaker.configs.default.failure-rate-threshold=50
resilience4j.circuitbreaker.configs.default.event-consumer-buffer-size=10
resilience4j.circuitbreaker.configs.default.automatic-transition-from-open-to-half-open-enabled=true
#Show details
management.endpoint.health.show-details=always
management.endpoint.circuitbreakers.enabled=true
management.health.circuitbreakers.enabled=true
#Retry
resilience4j.retry.instances.orderfallback.max-attempts=3
resilience4j.retry.instances.orderfallback.wait-duration=3000ms

While creating fallback methods -
1. Fallback method should be exact same return type as current method
2. Fallback method and normal mehod params should be same along with Throwable as param
Changed project -> UserService

Spring cloud->
Discovery server - MS Inter communication to avoid hard coding of hostname - Eureka server
Api Gateway - External MS Inter communication to avoid hard coding of hostname - Spring cloud gateway
Metrics - To collect the metrics such as health, memory, Http load - Actuator
To Monitor - To monitor MS instances and health - Spring boot admin
Tracing - To analyze MS communication, request propogation - Sleuth, Micrometer
Visualize tracing - To see graphically tracing - Zipkin
Fault tolerance - To implement fallback mechanism with circuit breaker desing pattern - Resilience4j(inspired from Hystrix)



43-35-SBMS-11-DEC-23
Spring security -
Authentication and Authorization
Authentication - who you are - Username and password - Oauth2/LDAP/SAMP(IDP.SP)
Authorization -  what you are - roles(user/admin/client)

44-35-SBMS-12-DEC-23
Tell the spring security that you want to use Db, we will use filters
Mendotary columns(username, password, enabled, role)
Spring security provides predefined login form.


45-35-SBMS-13-DEC-23
In the place of spring login form you need to use custom login form.
Spring login form takes username and password as form attributes and submit it to the /login.
So you need to develop custom login form in same way.
Retrive user/passwd from db called as basic authentication/session based authentication.
In distributed ecosystem session based authentication is not possible(MS1 running and Payment MS2 is running so both are different server and to make payment we need to share session or to send all that, it is not possible bcoz all request are happening on Http protocol and http protocol is a statefull protocol - To resolve this you need to make cookies but that is unsecure way for storing the username and pwd).
Due to above problem we are going to use stateless authentication where we can use token.
Token logic generate by third party libraries like keylock, azure, octas, google authenticator, microsoft authenticator.

46-35-SBMS-14-DEC-23
OAuth - Open Authorization
Authentication -
Before 2010
- Simple signon - Username and pwd
- Singlesignon - work in single system(system based authentication one time) for multiple applications achieve by SAML(secure asset markup lang) eg. Microsoft word, excel, powerpoint. 
After 2010 - webservice introduced due to distributed environment
- Mobile app logins - required longer sessions(login only once), used register keys
- Delegated Authentications - some application is trying to access your application(choice logging gmail, facebook). OAuth is standard design which will allow website or application going to access resources hosted in other apps behalf of users.
To achieve delegated authentication, to implement in secure manner we have standard protocol that is a open authorization(OAuth 2.0).
To deal this delegated authentication - we have JWT(Json web) token(long data including user roles) and opaque(okta) - OpenId(compress - less data - used in banking app).
JWT will help you to share token service to service in (Distributed)MS ecosystem because all MS are available in different server.
Token passing - 32:00
JWT Token - 
1. Signature (Signed token by authorization server)
2. Info user
3. Roles(Admin, user)
4. deprecated - Hashing algo. to decode the signature(available OAuth1.0 bcoz of this they released 2.0)
4. Lifetime 
As a developer your resposiblity is passing token in header.
Authorization is taking care by keylock, Okta, microsoft authentication, google authentication
401 - Till now user is not authenticated
403 - user don't have access(don't have privilege)
Interview:
what is OAuth tool, what is purpose, what kind of token you are using, is it signed?
For opaque we are using unsigned bcoz they have different encryption algo.

47-35-SBMS-15-DEC-23
Docker - Comes under IAAS(Infrastructure as a service)
Development and deployment are working fine but to to run your app it requires something.
Infrastructure - what things are required to run your app(Java - jdk, mysql, tomcat, kafka)
Here to solve this situation Docker comes.
Whenever you want to setup certain kind of infrastructure for you application so docker will help you to setup that infrastructure.
To reduce the burden of infrastructure mgmt docker came into picture.
Steps-
- Create docker file
- Inside that you will tell them what application you need irrespective of system.
- While installing on other system, download docker(macos, windows, linux)
- Share the docker image, that image will take care  for infrastucture whatever app needs.
Two terminologies
Image - Skeleton of infrastructure(Infrastructure descriptor)
Container - Running thread of image

Cmd to cread docker image-
docker build -f Dockerfile -t springdocker .
To check the image-
docker images
To run-
docker run -p 8080:8080 springdocker
To run our application on another system, we need to export this image through docker trusted registry
To check running service- (ps means present services)
docker ps
If we have 10 MS then it is difficult to run all of them one by one, so in this case we can use docker compose. It requires .yml file and in that we can add all the MS detail.
To run docker compose for multiple services
docker-compose -f docker-compose.yml up
To shutdown all the service docker compose(if at different location)
docker-compose -f docker-compose.yml down
To shutdown all the service docker compose(if at same location)
docker-compose down

48-35-SBMS-16-DEC-23
Keycloak - Identity and access management
It supports-
- Simple form login
- SAML
- OPENID - OAuth2
- Social logins
- LDAP authentication


Kafka:
Apache kafka is like a communication system that helps different parts of computer system exchange data by publishing and subscribing to topics






Docker:
Docker is a open source platform for developing, shipping and  running application in  containers.

Images- Docker images are the templates that define the container and its dependencices
Container - Containers are runtime environments created from docker images
Docker enginer - The docker engine is the runtime that runs and manages containers
Dockerfile -  Is a file that contains instructions to build a Docker image
DockerHub - DockerHub is cloud based registry that hosts a vast collection of Docker images

create img from mvn wrapper:
./mvnw spring-boot:build-image "-Dspring-boot.build.image.imageName=dcode007/companyms"


Feign:
Declarative web service client designed to make writing HTTP clients easier


Zipkin:
Is an open-source distributed tracing system









