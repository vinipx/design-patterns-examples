# Prototype

### "The Prototype pattern is generally used when we have an instance of the class (prototype) and we'd like to create new objects by just copying the prototype."

#### Examples present in Java libraries: 

>java.lang.StringBuilder#append() (unsynchronized)
<br>Java.lang.Runtime with getRuntime() method
<br>Java.awt.Toolkit with getDefaultToolkit()
<br>Java.awt.Desktop with getDesktop()

## Definition

The Prototype pattern is generally used when we have an instance of the class (prototype) and we'd like to create new objects by just copying the prototype.
In some games, we want trees or buildings in the background. We may realize that we don't have to create new trees or buildings and render them on the screen every time the character moves
So, we create an instance of the tree first. Then we can create as many trees as we want from this instance (prototype) and update their positions. We may also choose to change the color of the trees for a new level in the game.

The Prototype pattern is quite similar. Instead of creating new objects, we just have to clone the prototypical instance.

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
Lazy initialization method to implement the singleton pattern creates the instance in the global access method. Here is the sample code for creating the singleton class with this approach:
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
- **Global Access Point**: A Singleton is a global object in disguise, but it provides a global access point. As a global, a Singleton can be accessed from anywhere in the program, but it cannot be modified from anywhere. It can only be modified from within the Singleton. It is, therefore, a means to protect globals.
- **Unique Entity Model**: It makes it easier to reason about your program when you model entities of reality. In reality, we often have Singletons such as registration offices, global timers, or factories for unique IDs. Consequentially, you achieve a very nice match between the program abstraction and the reality. This correspondence helps you and your client to better understand the program.

### Disadvantages
- **Static Initialization Order Fiasco**:  you have no guarantee in which order statics in different translation units are initialized and destructed.

### Usages
- Singleton design pattern is used in core Java classes also (i.e. java.lang.Runtime, java.awt.Desktop).
- Singleton pattern is used for logging, drivers objects, caching, and thread pool. 
- Singleton design pattern is also used in other design patterns like Abstract Factory, Builder, Prototype, Facade, etc.

## Interview Questions

### Q1: What is Singleton Pattern?

Singleton Pattern helps in providing the best ways for creating an object. It is also responsible for creating objects while single objects in making sure if only one object is been created. This class helps by providing a way for accessing the objects that can be accessed without the need for instantiating the object of the class.

### Q2: What is Eager Initialization?

Eager Initialization is used as an instance in Singleton Class that is created on class loading and is the easiest method for creating singleton class.
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

Lazy Initialization is a method used for implementing singleton pattern, that creates instances in the Global Access Method.For creating a singleton class we can use the following command:
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

With more and more classes calling getInstance() the code gets more and more tightly coupled, monolithic, not testable and hard to change and hard to reuse because of not configurable, hidden dependencies. Also, there would be no need for this clumsy double-checked locking if you call getInstance less often (i.e. once).

### Q5: When should you not use this pattern?

The Builder design pattern is not appropriate in every situation. One common pitfall is when the construction process is relatively simple and not worth abstracting into a separate Builder object. In addition, this pattern can lead to code that is difficult to read and maintain if it is not used carefully.

### Q6: What are the problems in implementing this patterns using static Class ?

a. We cannot achieve runtime Polymorphism or late binding as Java doesn't allow overriding static methods.
<br>b. We cannot do lazy initialization as Static members are loaded during class loading only.
<br>c. We cannot serialize as Java doesn't serialize static members.

### Q7: What’s the best way to create a thread-safe Singleton pattern in Java?

The best way to create a thread-safe Singleton pattern in Java is to use the double-checked locking method. This method uses a synchronized block to ensure that only one instance of the Singleton is created.

### References

- [HowToDoInJava- Java Singleton Pattern Explained](https://howtodoinjava.com/design-patterns/creational/singleton-design-pattern-in-java/)
- [Baeldung - Singletons in Java](https://www.baeldung.com/java-singleton)
- [Java Revisited - 10 Interview Questions on Singleton](https://javarevisited.blogspot.com/2011/03/10-interview-questions-on-singleton.html#axzz7nGmsZOxX)
