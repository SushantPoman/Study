
### IS-A and HAS-A Relationships:
- "Is-a" Relationship: This represents inheritance. For example, if you have a class Animal and a class Dog that extends Animal, then Dog "is a" type of Animal. This relationship is established using the extends keyword.
- "Has-a" Relationship: This represents composition. For example, if a Car class has an Engine object, then a Car "has an" Engine. This relationship is established by including an instance of one class as a member variable in another class.
- In below example we’ll create a RESTful service where Employee "is a" Person and a Company "has an" Employee.

        // Person class
        public class Person {
            private String name;
            private int age;

            // Constructors, getters, and setters
        }

        // Employee class
        public class Employee extends Person {
            private String employeeId;

            // Constructors, getters, and setters
        }

        // Company class
        public class Company {
            private String name;
            private Employee employee;

            // Constructors, getters, and setters
        }

        // EmployeeController class
        @RestController
        @RequestMapping("/employees")
        public class EmployeeController {
            @GetMapping("/{id}")
            public Employee getEmployee(@PathVariable String id) {
                // For demonstration purposes, returning a static Employee object
                Employee employee = new Employee();
                employee.setName("John Doe");
                employee.setAge(30);
                employee.setEmployeeId(id);
                return employee;
            }
        }

        // CompanyController class
        @RestController
        @RequestMapping("/companies")
        public class CompanyController {
            @GetMapping("/{name}")
            public Company getCompany(@PathVariable String name) {
                // For demonstration purposes, returning a static Company object
                Company company = new Company();
                company.setName(name);

                Employee employee = new Employee();
                employee.setName("John Doe");
                employee.setAge(30);
                employee.setEmployeeId("E123");
                company.setEmployee(employee);

                return company;
            }
        }

        // Spring Boot Application
        @SpringBootApplication
        public class DemoApplication {
            public static void main(String[] args) {
                SpringApplication.run(DemoApplication.class, args);
            }
        }


### Difference between Clonable and Copy in java:
- In Java, Cloneable and copy are related to creating copies of objects, but they work differently and are used in different contexts.
- Cloneable Interface:
    - Purpose: Used to indicate that a class allows its objects to be cloned (i.e., create a copy of the object).
    - Method: Typically involves overriding the clone() method from the Object class.
    - Implementation: The class that implements Cloneable must handle the cloning process manually.
    - Deep/Shallow Copy: By default, clone() performs a shallow copy(It copy the references with new variables). To achieve a deep copy, the clone() method must be customized to also clone referenced objects.

            public class Person implements Cloneable {
                private String name;
                private int age;

                public Person(String name, int age) {
                    this.name = name;
                    this.age = age;
                }

                @Override
                protected Object clone() throws CloneNotSupportedException {
                    return super.clone(); // Shallow copy
                }

                // Getters, setters, etc.
            }

            public class Main {
                public static void main(String[] args) throws CloneNotSupportedException {
                    Person person1 = new Person("John", 30);
                    Person person2 = (Person) person1.clone();
                    
                    System.out.println(person2.getName()); // Output: John
                }
            }

- Copy Constructor
    - Purpose: A constructor that takes an object of the same class and creates a new object with the same values.
    - Method: Defined explicitly in the class.
    - Implementation: Easier to control compared to cloning, as you can specify exactly how the new object is created.
    - Deep/Shallow Copy: Can be implemented to perform either shallow or deep copies based on how the constructor is defined.

            public class Person {
                private String name;
                private int age;

                public Person(String name, int age) {
                    this.name = name;
                    this.age = age;
                }

                // Copy constructor
                public Person(Person person) {
                    this.name = person.name;
                    this.age = person.age;
                }

                // Getters, setters, etc.
            }

            public class Main {
                public static void main(String[] args) {
                    Person person1 = new Person("John", 30);
                    Person person2 = new Person(person1);
                    
                    System.out.println(person2.getName()); // Output: John
                }
            }


