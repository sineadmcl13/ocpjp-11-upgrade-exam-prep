### Java Interfaces

#### Interfaces
An interface is a mechanism for spelling out a contract between two parties: 
the supplier of a service and the classes that want their objects to be usable with the service. 

- An interface specifies a set of methods that an implementing class must provide
- An interface is a supertype of any class that implements it. 
  Therefore you can assign instances of the class to variables of the interface type
- An interface can contain static methods. All variables of an interface are automatically public, static and final
- An interface can contain default methods that an implementing class can inherit or override
- An interface can contain private methods that cannot be called or overridden by implementing classes
- A functional interface is an interface with a single abstract method
- Lambda expressions are converted to functional interfaces
