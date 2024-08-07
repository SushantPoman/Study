

## Java 8:
https://www.youtube.com/watch?v=mafkhtals0o


### Tell me about yourself:- 
qualification\
skillset working on java, spring and springboot and tools like eureka, api gateway, actuator, resilience4j, redis, prometheus and kafka\
domain - currently working on telecom.. and having exp in ecommerce domain\
achievement - I can work as independent as well as a team member.\
That's it from my side, please let me know if u r looking for any other information

### why java?
portability - can run on any platform and it is opensource(free)\
security - it protects the customers from malicious script injection\
strong oops concepts - reusablity, performance etc.\
robust - it's reliable and efficient\
wildely used - simple prog. lang and easy to learn

### data types:
Primitive -
- byte: An 8-bit signed. Its range is from -128 to 127 (inclusive).
- short: A 16-bit signed. It can hold values from -32,768 to 32,767.
- int: A 32-bit signed. Its range is from -2,147,483,648 to 2,147,483,647. In Java SE 8 and later, you can use int to represent an unsigned 32-bit integer with a range from 0 to 2,147,483,647.
- long: A 64-bit. The signed long has a minimum value of -9,223,372,036,854,775,808 and a maximum value of 9,223,372,036,854,775,807. In Java SE 8, you can use long to represent an unsigned 64-bit long with a range from 0 to 18,446,744,073,709,551,615.
- float: A 32-bit floating-point type for fractional numbers. It can store approximately 6 to 7 decimal digits.
- double: A 64-bit floating-point type. It provides greater precision and can store approximately 15 decimal digits.
- boolean: A 1-bit type representing true or false.
- char: A 16-bit type that stores a single character or an ASCII value.
Non primitive - String, Array, Class, Interface and Enum

### Exception and types:
How to handle the error and represent to end user.\
Checked - it should be declare and we should handle the exception and we need to throw the error to base class. if we can not handle compiler will throw the error.

    try{
        File file = new File("ab.txt");
        Scanner scanner = new Scanner(file);
    }catch(IOException ie){
        sysout("file not found");
    }
Unchecked - this should not be declared in the method signature and it can be thrown by any other method. compiler will not generate any error if they are not handled.

    try{
        File file = new File("ab.txt");
        Scanner scanner = new Scanner(file);
    }catch(IOException ie){
        throw new RuntimeException(id);
    }

### diff between class and interface
A class contains properties, methods and constructors where as interface contains only abstract methods which has only signatures without any implementation.\
E.g Bank account stmt download(Abstract method - downloadStmt(type, data) ) - pdf format, csv format, json format

### Normal thread vs daemon thread
- A thread created by user/application/thread pool i.e. known as normal thread and JVM will take care(create, maintain and terminate) about this.
- These are the thread created by operating system to provide services to normal threads. They are low priority thread and only needed while user
threads are running. once the task is over JVM will terminate them even though daemon thread still running.(called as sema phores or monitors)

### OOPS concepts:
- Abstraction - hide implemention
- Encapsulation - providing the abstraction like getters/setters and constructors
- Inheritance -
- Polymorphism
- Overloading - multiple methods with same name and different parameters(prepare car - classic, suv, )
- Overriding - same params and same method name - functionality differs(download stmt)

### Difference between == and equals method:
== supports shallow comparison(check memory location) and equals supports Deep comparison(check value)

    String s1 = "hello";
    String s2 = new String(s1);
    String s3 = "hello";
    sysout("s1 equals s2"+ s1.equals(s2)); // true
    sysout("s1 == s2"+ s1==s2); //false
    sysout("s1 == s3"+ s1==s3); //true

### Abstract class vs Interface
Abstract classes are similar to normal classes but they can have abstract(only signature) methods which can not be instantiated.
Interfaces can only contains abstract methods and we can't write non abstract method inside interface

    Feature                 Abstract    Interface
    Instantiation           No          yes
    Abstract method         yes         yes
    Non abstract method     yes         no
    state                   yes         no
    can extend other class  yes         no
    implement other class   yes         yes
- Abstract class eg: baseController for error cases handling
- Interface eg: service layer implementation

### Arrays vs LinkedList:

    Feature                 Array           Linkedlist
    Data storage            Contigoues      Non contigoues memory
    Access efficiency       High            Low
    Insertion/Deletion      Low             High
    Order of data           Important       Not Important
    E.g. (cases)            Only retrieval  Update data, add, remove

### Hashtable:
It's a data structure used to store key and value pair. Its an efficient data structure for storing and retrieving the data as we can access the data in constant time.
- put(key, value) -> going to insert data in HashTable -> new bucket and add this item to the bucket
- get(key) -> based on hashcode it retrievs the data
- remove(key) -> removed the key and value pair from the hash table

### Priority queue:
It's an operating system feature.\
Its also data structure that stores the elements along with their priorities.(how to create priority queue, set priority). It allows efficient of the element retrieval based on priority.Schedule tasks we can use this.\
E.g. -> Banking sector -> Fund Transfer -> IMPS(Immediate), RTGS(Huge amount), NEFT(Take time and less money)

### Heap memory and Stack memory:
java.lang.OutOfMemoryException - common problem in big enterprise application\
Don't have memory to create object ->\
Drawaback of java - garbage collection algorithm(how it works internally)\
memory problem only comes on heap memory.

- Stack memory contains local variables like primitives, int, float, decimal etc and reference to the objects in the heap and also method parameters for classes.
- Heap memory contains objects and string pools
Code from screenshot:
how outofmemory will come here------------

Creating order with two products -> UseCase

    Order order = new Order(); -> base class              order.setCustomer(cust);    Orderservice ser = new OrderService();
    Customer customer = new Customer("Sushant","Poman");  order.setProduct(listp);    ser.createOrder(ord);
    List<Product> listp = new ArrayList("TV","Laptop");   order.setInventory(inv);
    Inventory inv = new Inventory(1,1);                   order.setPayment(payment);  ord -> 200Kb of data
    Payment payment = new GooglePay("11111");             ..shipment                  service -> 10kb of data
    Discount discount = new Discount("0.1");              ..discount                  2GB of PermGenSpace -> VM Argument
    Shipment ship = new Shipment("1111","Pune");

--- I have one order how much memory with above object it will table

    Amazon Avg order per hour -> 1 lakh
    Our application -> 1 hr - 1000 order -> 1000*200 kb =

    Garbage collection - 20 Orders per minute -> 4MB of data per minute.        finally{
    1st min -> order 1 to order 20 -> 4MB                                           ser = null;
    2nd min -> order 21 to order 40 -> 4MB                                          order = null;
    3rd min -> order 41 to order 60 -> 4MB                                          cust = null;
    6th..                                                                           inv = null;
    7th ..                                                                      }
Garbage collector don't know the scope of order, cust, service until we define finally.. it will pile up and it will throw OutOfMemoryExceptions

### What is multithreading:
Is a programming concept, allows multiple tasks to be executed concurrently. In java multithreading can be implemented using Thread class. A thread object represents a single thread of execution.\
Advantages:
- increased performance
- improved responsiveness
- reduce resource storage
Did you used in real time/ where you have used it(scenario)?
Homeloan -> variable rate of interest -> RBI contols
I'm the developer of SBI who process the home loan. now
Avg 10 million people have home loan in pune -> RBI increased ROI 9.5 to 9.8 -> calculate 10 million people new WMI .

        for(int i =0; i<=10M; i++){             1000 customers -> thread1
                                                next 1000 -> thread2
        }

### Collections(uses):
- Main benefits of colleciton framework:
    - Reusabliity - Common classes and common util methods
    - Quality(Performance) - Code already tested an easy to write
    - Speed - JVM created the collection by taking performance in the criteria
    - Maintenance - Easy to maintain
- Root interface of collections is:
    - Collections
- Thread safe(avoid deadlocks) classes in java collection framework
    - Stack
    - Vector
    - Hashtable
    - BlockingQueue
    - ConcurrentMap
    - ConcurrentNavigatbleMap
- How you can remove elements efficiently while iterating a collection
        ListIterator<Integer> item = myList.iterator(); //concurrentModificationException not come in the listIterator
            while(item.hasNext()){
                item.remove();
        }
- Convert list into an array\
    int[] intArray = ArrayUtils.toPrimitive(myList.toArray(new Integer[0]));
- Collection.nCopies() -> can use while testing for multiple copies
    - It is going to return an immutable list which contains "n" copies of given object
- Collection.frequency
    - It counts the frequency of the specified element in the given list
- Collection.disjoint
    - It returns common element by comparing two datastructure
- Collection.Singleton
    - It created an immutable set over a specified collection

### Java 8 features:
- Functional programming

- Optional keyword in java:
To avoid NullPointerException in Java - we can use optional keyword\
Product prod = Product.getProduct("iPhone14");

#### Default Methods:
- Default methods allow you to add new functionality to existing interfaces without breaking the code in classes that implement those interfaces.
- They provide default implementations that can be optionally overridden by implementing classes.
- Use cases: Backward compatibility: You can extend an interface’s functionality without affecting already implemented classes.

        interface MyInterface {
            void regularMethod();
            default void defaultMethod() {
                System.out.println("Default method implementation");
            }
        }
        class MyClass implements MyInterface {
            public void regularMethod() {
            System.out.println("Regular method implementation");
            }
        }
        MyClass myObj = new MyClass();
        myObj.regularMethod(); // Output: Regular method implementation
        myObj.defaultMethod(); // Output: Default method implementation

#### Static Methods
- Static methods in interfaces are similar to static methods in classes.
- They can be invoked on the interface itself without requiring an instance of the interface.
- Purpose: Organizing utility methods related to the interface.

        interface MyInterface {
            // Abstract method
            void regularMethod();
            // Static method with a default implementation
            static void staticMethod() {
                System.out.println("Static method implementation");
            }
        }
        MyInterface.staticMethod(); // Output: Static method implementation

These features enhance the flexibility and expressiveness of Java interfaces, making them more powerful and versatile.

### Collections:
https://github.com/SushantPoman/JavaBasics/blob/main/src/Basics/Streams.java
https://github.com/SushantPoman/JavaBasics/blob/main/src/Basics/StreamsCustom.java
- ArrayList vs LinkedList - 
    - https://www.javatpoint.com/difference-between-arraylist-and-linkedlist
    - https://www.geeksforgeeks.org/arraylist-vs-linkedlist-java/
- Internal working of hashmap 
    - https://www.javatpoint.com/working-of-hashmap-in-java
    - https://www.youtube.com/watch?v=sw-j_ETGBEo&list=PL0zysOflRCen9SPmMO2XN1I2S9m96G_dx&index=3
    - Hashing(&)
        - https://madformath.com/calculators/basic-math/base-converters/decimal-to-binary-converter-with-steps/
decimal-to-binary-converter-with-steps#calc43
        - https://www.freecodecamp.org/news/java-operator-and-or-logical-operators/
- Internal working of hashset 
    - https://www.geeksforgeeks.org/internal-working-of-sethashset-in-java/https://www.geeksforgeeks.org/internal-working-of-sethashset-in-java/
- Synchronized collection 
    - https://medium.com/@the_infinity/javas-synchronized-collections-07712ae3b2cb

### Comparable vs comparator
https://github.com/SushantPoman/JavaBasics/blob/main/src/Basics/CompareFields.java 
#### Comparable:
1.	The Comparable interface allows you to compare an object with other objects of the same type.
2.	It is used for the default ordering of objects.
3.	Classes that implement the Comparable interface override the compareTo() method to enable default ordering based on a specific attribute.
4.	The actual class is modified when implementing Comparable.
5.	Example: Suppose we have a Student class with attributes like rollno, name, and age. By implementing Comparable<Student>, we can sort a list of students based on their age.
#### Comparator:
1.	The Comparator interface is a functional interface that can sort objects.
2.	It provides multiple sorting sequences.
3.	Unlike Comparable, it does not modify the actual class.
4.	You can create custom comparators to sort objects based on different attributes.
5.	Example: If you want to sort students by name or roll number, you can create a custom Comparator for that specific sorting logic.
In summary:
- Use Comparable when you want to define the default ordering for objects within the same class.
- Use Comparator when you need custom sorting logic or want to sort objects based on different attributes.


### Thread lifecyce:
Threads go through various stages or phases during their lifetime. At any given moment, a thread exists in one of the following states:
1.	New State:
    - Occurs when a thread is created but not yet started.
    - The thread’s code has not yet begun execution.
    - It lies in the new state until the start() method is invoked.
2.	Runnable State:
    - A thread that is ready to run is moved to the runnable state.
    - In this state, a thread might actually be running or waiting for resource allocation.
    - The thread scheduler allocates time for each runnable thread to execute.
3.	Blocked State:
    - A thread enters the blocked state when it tries to acquire a lock that is currently held by another thread.
    - It remains blocked until it acquires the lock.
    - Once the lock is available, the thread moves back to the runnable state.
4.	Waiting State:
    - A thread enters the waiting state when it calls methods like wait() or join().
    - It waits for another thread to notify it or for the waiting thread to be terminated.
    - When notified, it transitions back to the runnable state.
5.	Timed Waiting State:
    - A thread enters this state when it calls a method with a time-out parameter (e.g., sleep or a conditional wait).
    - It remains in this state until the timeout expires or until it receives a notification.
6.	Terminated State:
    - A thread terminates due to either of the following reasons:
    - It exits normally after its code has been executed.
    - An unusual event occurs, such as an unhandled exception or a segmentation fault.
In Java, you can use the Thread.getState() method to get the current state of a thread. The java.lang.Thread.State enum defines constants for each thread state.\
yeild(), sleep()

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

### Singleton class:
https://github.com/SushantPoman/JavaBasics/blob/main/src/Basics/DbSingleton.java

## SOLID principles:
1. Single Responsibility Principle I
    - A class should have only one reason to change
    - eg. generate report, send report
    -   https://medium.com/@saygiligozde/applying-solid-principles-to-spring-boot-applications-191d7e50e1b3

2. Open-Closed Principle
    - Software entities (classes, modules, functions, etc.) should be open for extension, but closed for modification
    - eg. spring's dependency injection Leverage Spring's DI mechanism to inject different implementations of interfaces without modifying the client class, DiscountStrategy
    - https://numericaideas.com/blog/solid-principles-in-spring-boot/

3. Liskov Substitution Principle
    - Derived or child classes must be substitutable for their base or parent classes"
    - e.g. https://medium.com/@javatechie/solid-design-principle-java-ae96a48db97

4. Interface Segregation Principle
    - Do not force any client to implement an interface which is irrelevant to them
    - e.g https://amrtechuniverse.com/solid-principles-in-spring-boot

5. Dependency Inversion Principle
    - Must use abstraction (abstract classes and interfaces) instead of concrete implementations. High-level modules should not depend on the low-level module but both should depend on the abstraction
    - https://numericaideas.com/blog/solid-principles-in-spring-boot/

### Saga design pattern:

## Design patterns:
https://www.youtube.com/watch?v=neSp9gap7Rw

### Creational:
1. Builder
    - Construct a complex object from simple objects using step-by-step approach
    - It's especially useful when you need to create an object with lots of possible configuration options. 
    - e.g. Spring(Kafka - topicBuilder while generating NewTopic, Servlet -SpringApplicationBuilder), Android (NotificaitonBuilder, AlertDialogBuilder)
    - SpringApplicationBuilder - Add more sources (configuration classes and components) to this application

2. Factory
    - Define an interface or abstract class for creating an object but let the subclasses decide which class to instantiate. 
    - Factory Method Pattern allows the sub-classes to choose the type of objects to create. It promotes the loose-coupling by eliminating the need to bind application-specific classes into the code.. 
    - e.g. slf4j.LoggerFactory, SessionFactory, BeanFactory, ReportFactory(Custom)

3. Singleton
    - Ensures that only one object of its kind exists and provides a single point of access to it for any other code
    - e.g. Logging service, utility classes, configuration (properties, environment variables, feature toggles), caching (Implement a singleton cache manager to store frequently accessed data in memory).

4. Prototype
    - Cloning of an existing object instead of creating new one and can also be customized as per the requirement
    - When you need a new instance of a bean every time it's requested, such as maintaining per-client or per-request state, use the prototype scope
    - e.g. user session, shopping cart, generate unique tokens, random numbers

### Structural:

1. Adapter
    - Attach new behaviors to objects by placing these objects inside special wrapper objects that contain the behaviors.
    
### Behavioural:

1. Chain of responsibility
    - Upon receiving a request, each handler decides either to process the request or to pass it to the next handler in the chain


Java 11:
- https://www.baeldung.com/java-11-new-features
- https://www.interviewbit.com/blog/java-11-features/

