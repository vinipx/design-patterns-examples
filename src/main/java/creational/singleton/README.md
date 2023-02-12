# Singleton

### "Singleton pattern restricts the instantiation of a class and ensures that only one instance of the class exists in the Java Virtual Machine."

#### Examples present in Java libraries: 

>java.lang.System#getSecurityManager()
<br>Java.lang.Runtime with getRuntime() method
<br>Java.awt.Desktop with getDesktop()

## Definition

To implement a singleton pattern, we have different approaches, but all of them have the following common concepts.
- Private constructor to restrict instantiation of the class from other classes.
- Private static variable of the same class that is the only instance of the class.
- Public static method that returns the instance of the class, this is the global access point for the outer world to get the instance of the singleton class.

There are different approaches to singleton pattern implementation:

### Eager Initialization
In eager initialization, the instance of the singleton class is created at the time of class loading. The drawback to eager initialization is that the method is created even though the client application might not be using it. Here is the implementation of the static initialization singleton class:
```java
public class EagerInitializedSingleton {

    private static final EagerInitializedSingleton instance = new EagerInitializedSingleton();

    // private constructor to avoid client applications using the constructor
    private EagerInitializedSingleton(){}

    public static EagerInitializedSingleton getInstance() {
        return instance;
    }
}
```
If your singleton class is not using a lot of resources, this is the approach to use. But in most of the scenarios, singleton classes are created for resources such as File System, Database connections, etc. We should avoid the instantiation unless the client calls the getInstance method. Also, this method doesn’t provide any options for exception handling.

### Static Block Initialization
Static block initialization implementation is similar to eager initialization, except that instance of the class is created in the static block that provides the option for exception handling.
```java
public class StaticBlockSingleton {

    private static StaticBlockSingleton instance;

    private StaticBlockSingleton(){}

    // static block initialization for exception handling
    static {
        try {
            instance = new StaticBlockSingleton();
        } catch (Exception e) {
            throw new RuntimeException("Exception occurred in creating singleton instance");
        }
    }

    public static StaticBlockSingleton getInstance() {
        return instance;
    }
}
```
Both eager initialization and static block initialization create the instance even before it’s being used and that is not the best practice to use.

### Lazy Initialization
The instance could be initialized only when the singleton class is used for the first time.
Doing so creates the instance of the singleton class in the JVM during the execution of the method.
```java
public class LazyInitializedSingleton {

    private static LazyInitializedSingleton instance;

    private LazyInitializedSingleton(){}

    public static LazyInitializedSingleton getInstance() {
        if (instance == null) {
            instance = new LazyInitializedSingleton();
        }
        return instance;
    }
}
```
The preceding implementation works fine in the case of the single-threaded environment, but when it comes to multi-threaded systems, it can cause issues if multiple threads are inside the if condition at the same time. It will destroy the singleton pattern and both threads will get different instances of the singleton class. In the next section, we will see different ways to create a thread-safe singleton class.

### Advantages
- Provide global access point from anywhere in the program - it can't be modified though
- Control access to shared resources
- Limits object initialization

### Disadvantages
- Increases coupling - impacts scalability and testing
- Requires static memory allocation
- Hidden dependencies in code
- Violates the single responsibility principle
- Violates the open/close principle
- Can be directly affected by multithreaded solutions

### Usages
- Singleton design pattern is used in core Java classes also (i.e. java.lang.Runtime, java.awt.Desktop).
- Singleton pattern is used for logging, drivers objects, caching, and thread pool. 
- Singleton design pattern is also used in other design patterns like Abstract Factory, Builder, Prototype, Facade, etc.

## Interview Questions

### Q1: What is Singleton Pattern?

Singleton Pattern helps in providing the best ways for creating an object. 
It is also responsible for creating objects while single objects in making 
sure if only one object is been created. 

This class helps by providing a way for accessing the objects that can be 
accessed without the need for instantiating the object of the class.

### Q2: What is Eager Initialization?

Eager initialization is the simplest method of creating a singleton class.
The object of a class is created when it is loaded to the memory by JVM.
It is done by assigning the reference of an instance directly.

It can be used when program will always use instance of this class
or the cost of creating the instance is not too large in terms of
resources and time.
```java 
public class EagerinitializedSingleton {
   
    //private constructor for avoiding client applications for using constructor
    private EagerinitializedSingleton(){}

    public static EagerinitializedSingleton getInstance(){
        return instance;
    }
}
```

### Q3: What is Lazy Initialization?

The instance could be initialized only when the singleton class is used for the first time.
<br>Doing so creates the instance of the singleton class in the JVM during the execution of the method.

```java 
public class LazyinitializedSingleton {

    private static LazyinitializedSingleton instance;
   
    private LazyinitializedSingleton(){}
   
    public static LazyinitializedSingleton getInstance(){
        if(instance == null){
            instance = new LazyinitializedSingleton();
        }
        return instance;
    }
}
```

### Q4: Why Singleton is Anti pattern

With more and more classes calling getInstance() the code gets 
more and more tightly coupled, monolithic, not testable and 
hard to change and reuse because of hidden dependencies.
<br>Also, there would be no need for this clumsy double-checked 
locking if you call getInstance less often (i.e. once).

### Q5: Why we should avoid the Singleton?

#### Increased Coupling:
- Couples all callers to the concrete implementation.
- Harder to test since you cannot isolate/mock it.
- In order to change the behavior of the singleton you have to
  check and change all the callers since they all share a global variable

#### Open/Closed Principle:
- In order to change the behavior you need to change the class.
  (changing code is way riskier than adding new code
  Undesired side effects (bugs) might be introduced in various
  different areas of the code.

### Q6: What are the problems in implementing this patterns using static Class ?

a. We cannot achieve runtime Polymorphism or late binding as Java doesn't allow overriding static methods.
<br>b. We cannot do lazy initialization as Static members are loaded during class loading only.
<br>c. We cannot serialize as Java doesn't serialize static members.

### Q7: What’s the best way to create a thread-safe Singleton pattern in Java?

The best way to create a thread-safe Singleton pattern in Java is to use 
the double-checked locking method. 
<br>This method uses a synchronized block to ensure that only one instance of the Singleton is created.

### References

- [HowToDoInJava- Java Singleton Pattern Explained](https://howtodoinjava.com/design-patterns/creational/singleton-design-pattern-in-java/)
- [Baeldung - Singletons in Java](https://www.baeldung.com/java-singleton)
- [Java Revisited - 10 Interview Questions on Singleton](https://javarevisited.blogspot.com/2011/03/10-interview-questions-on-singleton.html#axzz7nGmsZOxX)
