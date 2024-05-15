

## Java 8:
https://www.youtube.com/watch?v=mafkhtals0o

## Design patterns:
https://www.youtube.com/watch?v=neSp9gap7Rw

Factory - BeanFactory(IOC container of spring), ActiveMqConnectionFactory
Builder - RestTemplate, NewTopic(Kafka)
Singleton - Logging service, utility classes, configuration(properties, environment variables, feature toggles), caching(Implement a singleton cache manager to store frequently accessed data in memory.) Prototype(When you need a new instance of a bean every time it’s requested, such as maintaining per-client or per-request state, use the prototype scope) - user session, shopping cart, generate unique tokens, random numbers
Dependency injection - Autowired
Observer -


### Saga design pattern:

### Hashmap:
Internal working of hashmap - https://www.javatpoint.com/working-of-hashmap-in-java

### How to make java class as immutable:
Immutable class is a class which is once created, it’s contents can not be changed. Sometimes we need to create Immutable classes for some purposes such as not allowing outside world to modify the objects. We have several inbuilt classes in Java also. Some of them are:
String, Wrapper Classes, Arrays, LocalDate, LocalTime and etc...
Steps:
- The class must be declared as final so that child classes can’t be created.
- Data members in the class must be declared private so that direct access is not allowed.
- Data members in the class must be declared as final so that we can’t change the value of it after object creation.
- A parameterized constructor should initialize all the fields performing a deep copy so that data members can’t be modified with an object reference.
- Deep Copy of objects should be performed in the getter methods to return a copy rather than returning the actual object reference
https://www.geeksforgeeks.org/create-immutable-class-java/  


### Factory design pattern:
The factory design pattern is a creational design pattern that provides an interface for creating objects in a super class but allows subclasses to alter the type of objects that will be created. In Spring Boot applications, the factory pattern can be quite useful when different subtypes of objects are needed. Let’s explore an example of how you might use the factory pattern in a Spring Boot application.

Suppose you’re building a Report Microservice using Spring Boot. For this example, let’s assume you have a REST controller with a GET endpoint that provides data for different types of report requests. Here’s how you can apply the factory pattern:

Define an Abstract Report Class: First, create an abstract Report class that defines the common behavior for all report types. This class could have methods like generateReport() or fetchData(). Subclasses will implement these methods to provide specific functionality for each report type.
Java

public abstract class Report {
    public abstract void generateReport();
}
AI-generated code. Review and use carefully. More info on FAQ.
Create Concrete Report Types: Next, create concrete report classes that extend the Report class. Each subclass will implement the generateReport() method according to its specific requirements. For example:
Java

public class PDFReport extends Report {
    @Override
    public void generateReport() {
        // Logic to generate a PDF report
        System.out.println("Generating PDF report...");
    }
}

public class ExcelReport extends Report {
    @Override
    public void generateReport() {
        // Logic to generate an Excel report
        System.out.println("Generating Excel report...");
    }
}
AI-generated code. Review and use carefully. More info on FAQ.
Create a Report Factory: Now, let’s create a factory class that produces instances of different report types based on user input. This factory class will encapsulate the logic for creating specific report objects.
Java

public class ReportFactory {
    public Report createReport(String reportType) {
        if ("pdf".equalsIgnoreCase(reportType)) {
            return new PDFReport();
        } else if ("excel".equalsIgnoreCase(reportType)) {
            return new ExcelReport();
        } else {
            throw new IllegalArgumentException("Invalid report type: " + reportType);
        }
    }
}
Usage in Controller: Finally, in your REST controller, you can use the ReportFactory to create the appropriate report based on user input:
Java

@RestController
public class ReportController {
    private final ReportFactory reportFactory;

    public ReportController(ReportFactory reportFactory) {
        this.reportFactory = reportFactory;
    }

    @GetMapping("/generate-report")
    public ResponseEntity<String> generateReport(@RequestParam String type) {
        try {
            Report report = reportFactory.createReport(type);
            report.generateReport();
            return ResponseEntity.ok("Report generated successfully.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Invalid report type: " + type);
        }
    }
}

When a client requests a report type (e.g., /generate-report?type=pdf), the controller will create the corresponding report using the factory pattern.
Remember that the factory pattern allows you to encapsulate object creation logic and provides a flexible way to add new report types without modifying existing code.