# Factory Method

### The **factory** is intended to simplify and provide flexibility during object creation via single method call.

#### Factory examples present in Java libraries:

>java.util.Calendar#getInstance()
<br>java.util.ResourceBundle#getBundle()
<br>java.text.NumberFormat#getInstance()
<br>java.nio.charset.Charset#forName()
<br>java.net.URLStreamHandlerFactory#createURLStreamHandler(String)
<br>java.util.EnumSet#of()
<br>javax.xml.bind.JAXBContext#createMarshaller() and other similar methods.

## Advantages
- Factory Method Pattern allows the subclasses to choose the type of objects to create.
- It promotes the **loose-coupling** by eliminating the need to bind application-specific classes into the code. That means the code interacts solely with the resultant interface or abstract class, so that it will work with any classes that implement that interface or that extends that abstract class.

## Usages  
- When a class doesn't know what subclasses will be required to create
- When a class wants that its subclasses specify the objects to be created.
- When the parent classes choose the creation of objects to its subclasses.

Inspired by the excellent [Refactoring Guru](https://refactoring.guru/design-patterns/factory-method/java/example#lang-features) our example will be based on UI elements.

### Example 1: Dialog screen with button - Windows/Linux?


>**Given** a client operating a system
<br>**When** a dialog screen with a button is displayed
<br>**Then** the dialog and buttons might vary from Windows or Linux 
<br>**and** a single **createButtonFactory** method will be used to instantiate the appropriate button (win/linux) 

### Main Elements:
- **Dialog**: Base factory class
- **LinuxDialog**: concrete class which instantiates the Dialog with the appropriate button based on overriding factory method.
- **WindowsDialog**: : concrete class which instantiates the Dialog with the appropriate button based on overriding factory method.

## Interview Questions
### Q1: What is the Factory Design Pattern?

The Factory Design Pattern is a creational design pattern that is used to abstract the process of creating objects. The pattern defines an interface for creating an object, but it leaves the details of the implementation up to the subclasses. This allows for new objects to be created without the need to hard-code their specific class.

### Q2: When should you use the Factory design pattern?

The Factory design pattern is most useful when you need to create objects that are of the same type but with different data. For example, if you were creating a game with different levels, you could use the Factory design pattern to create objects that represent each level. The Factory design pattern is also useful when you want to hide the details of object creation from the user.

### Q3:What are some examples of when you would use the Factory method?

The Factory method is used when you want to create an object, but you don’t know ahead of time what type of object you will need. For example, if you were creating a program that could read in different types of files, you might use a Factory method to create the appropriate object to read in the file based on its type.

### Q4: Can you give me an example of where I might apply the Factory pattern to my code?

The Factory pattern is often used in situations where you need to create objects that belong to a particular class, but you don’t know ahead of time which class that will be. For example, if you were writing a program that needed to generate different types of reports based on user input, you could use the Factory pattern to create the appropriate report object based on the user’s selection.

### Q5: What do you understand about the differences between static, abstract, and dynamic factories?

Static factories are the simplest type of factory, and they simply return a new instance of a class. Abstract factories are a bit more complex, and they return an instance of a class that is determined by the input parameters. Dynamic factories are the most complex, and they return an instance of a class that is determined at runtime based on the input parameters.

### Q6: Is it possible to create multiple objects using the same factory method? If yes, then how?

Yes, it is possible to create multiple objects using the same factory method. This can be done by passing in different parameters to the factory method, which will then create different objects based on those parameters.

### Q7: Are there any drawbacks to using the Factory design pattern? If yes, then can you please explain them?

Yes, there are some drawbacks to using the Factory design pattern. One such drawback is that it can lead to code that is difficult to maintain and understand. This is because the Factory pattern can often lead to a large amount of code duplication. Additionally, the Factory pattern can sometimes be an overkill solution to a problem that could be solved more simply.







