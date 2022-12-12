# Builder

### "A Builder is a wrapper of a complex object. It is used when such complex object cannot be produced in one single step."

#### Builder examples present in Java libraries: 

>java.lang.StringBuilder#append() (unsynchronized)
<br>java.lang.StringBuffer#append() (synchronized)
<br>java.nio.ByteBuffer#put() (also in CharBuffer, ShortBuffer, IntBuffer, LongBuffer, FloatBuffer and DoubleBuffer)
<br>javax.swing.GroupLayout.Group#addComponent()
<br>All implementations java.lang.Appendable

## Definition

> Builder pattern aims to "separate the construction of a complex object from its representation so that the same construction" process can create multiple different representations."

### Advantages
- Lines of code increases with builder usage, but pays off in terms of design flexibility and more readable code.
- helps to create immutable classes with a large set of state attributes.
- Instance is always instantiated in a complete state.
- It supports to change the internal representation of objects.

### Usages
- Builder isolates the product’s internal representation and the steps for the product’s construction. 
- Use the Builder pattern to get rid of having a Product with multiple constructors with a diverse number of parameters each

> **Curiosity**! Lombok [@Builder](https://howtodoinjava.com/lombok/lombok-builder-annotation/) annotation is a useful technique to implement the pattern

## Interview Questions

### Q1: What is the Builder design pattern?

The Builder design pattern is a creational design pattern that allows for the construction of complex objects to be created in a step-by-step fashion, with each step providing more information about the object being created. This pattern is often used when creating objects that have a large number of parameters, or when the order of parameters is important.

### Q2: Can you explain what a builder class is in the context of this pattern?

A builder class is a class that is used to create objects. In the context of the builder design pattern, the builder class is responsible for creating objects that meet a certain set of specifications. The builder class typically has a number of methods that allow the user to specify the different aspects of the object that they want to create. Once all of the specifications have been provided, the builder class will then create the object and return it to the user.

### Q3: Is it possible to create multiple builders for a single object? If yes, then how?

Yes, it is possible to create multiple builders for a single object. This can be done by using a builder factory. A builder factory is an object that is responsible for creating other builder objects. This allows you to have different builder objects for different purposes, while still only having to manage a single factory object.

### Q4: Can you give me an example where I would use this pattern?

The builder design pattern is often used when creating complex objects. This is because it allows for the construction of the object to be done in steps, with each step adding a new level of complexity to the object. This can be helpful when you need to create an object that has a lot of different parts or that needs to be created in a specific order.

### Q5: When should you not use this pattern?

The Builder design pattern is not appropriate in every situation. One common pitfall is when the construction process is relatively simple and not worth abstracting into a separate Builder object. In addition, this pattern can lead to code that is difficult to read and maintain if it is not used carefully.

### Q6: What are the pros and cons of using the Builder Design Pattern?

The Builder Design Pattern is a creational design pattern that allows for the construction of complex objects to be created step-by-step. The main advantage of using the Builder Design Pattern is that it allows for a great deal of flexibility in terms of how the final object is created. The disadvantage of using the Builder Design Pattern is that it can lead to a lot of code duplication if not used carefully.

### Q7: What are the steps involved in creating a Builder Design Pattern?

The steps involved in creating a Builder Design Pattern are:

1. Define a static nested class that acts as the builder
2. Define a private constructor that takes a builder as an argument
3. Define all of the required fields in the builder class, and make them final
4. Define a public method in the builder class for each field that returns the builder
5. Define a public method in the builder class that returns the built object
6. In the main class, create a builder instance and call the methods to set the values
7. Finally, call the build method to create the object