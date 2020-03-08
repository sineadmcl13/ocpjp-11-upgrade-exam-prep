### Create and use methods in interfaces

Java 9 introduced `private` methods and `private static` methods in interfaces. 
So an interface can now have 7 different things:

- constant variables
- `abstract` methods
- nested types
- `default` methods
- `static` methods
- `private` methods
- `private static` methods

The `private` methods are only accessible within an interface only and cannot be accessed or inherited from the 
interface to another interface or class.  

#### Constant variables
Interface variables are `static` because Java interfaces cannot be instantiated in their own right; 
the value of the variable must be assigned in a static context in which no instance exists. 

The `final` modifier ensures the value assigned to the interface is a true constant that cannot be re-assigned

```java
public interface IGreeting {
  String GREETING = "Hello from the interface";
}
```
```java
public class Example {
  public static void main(String[] args){
    System.out.println(IGreeting.GREETING);
  }
}
```
[Code Sample](/examples/java_interfaces/src/interface_examples/ConstantVariableInterfaceExample.java)

#### `abstract` methods
Every method declaration in an interface with body represented by a semicolon is implicitly `public` and `abstract`

It is a compile-time error if a method declaration that contains the keyword `abstract` also contains any one of the 
keywords `private`, `static`, `final`, `native`, `strictfp`, or `syncronized`

It would be impossible for a class to implement a `private abstract` method, because `private` methods are not inherited 
by subclasses

```java
public interface Greeting {
  void sayHello();
}
```
```java
public class Example {
  public static void main(String[] args){
    GreetingImpl greeting = () -> {
      System.out.println("Hello");
    };
    greeting.sayHello();
  }
}
```

#### nested types
Interfaces may contain member type declarations. A member type declaration is an interface is implicitly `static` and `public`

```java
public interface Greeting {
  class GreetingException extends Exception {
    public GreetingException() { super(); }
  }
  
  interface EnglishGreeting {
    String GREETING = "Hi there";
  }
}
```
```java
public class Example {
  public static void main(String[] args){
    try {
      System.out.println(Greeting.EnglishGreeting.GREETING);
    } catch (Greeting.GreetingException ex){
      // do something useful with the caught exception
    }
  }
}
```
[Code Sample](/examples/java_interfaces/src/interface_examples/NestedTypesInterfaceExample.java)

#### `default` methods
Default methods are declared with the `default` keyword at the beginning of the method signature and they provide
an implementation.

As such they enable you to add new functionality to the interfaces of your library, ensuring backwards compatibility 
as classes already implementing your interface do not have to provide a implementation of the new method.

An implementing class can override the default implementation provided by the interface
```java
public interface Greeting {
  default void sayHello(){
    System.out.println("Hello");
  };
}
```
```java
public class Example {
  public static void main(String[] args){
    GreetingImpl greeting = new Greeting(){
      //We don't need to override the default method
    };
    greeting.sayHello();
  }
}
```
[Code Sample](/examples/java_interfaces/src/interface_examples/DefaultMethodInterfaceExample.java)

If a class implements two interfaces, both of which have a `default` method with the same name and parameter types then 
you must resolve the conflict
```java
public interface GreetingEnglish{
  default void sayHello(){
      System.out.println("Hello");
    };
}
```
```java
public interface GreetingFrench{
  default void sayHello(){
      System.out.println("Bonjour");
    };
}
```
```java
public class Example implements GreetingEnglish, GreetingFrench {
  //WILL NOT COMPILE. You must resolve the conflict on sayHello()
}
```

In the example above you should either provide a `sayHello()` method in the `Example` class and implement your own 
greeting or delegate to one of the conflicting methods like so:
```java
public class Example implements GreetingEnglish, GreetingFrench {
  @Override
  public void sayHello(){
    GreetingFrench.super.sayHello();
  }
}
```

#### `static` methods
Like `static` methods in classes, you can specify that a method definition in a interface is a `static` method with the 
`static` keyword at the beginning of the method signature

A `static` method can be invoked from other `static` or `default` methods
```java
public interface Greeting {
  static void sayHello() {
    System.out.println("Hello");
  }
}
```
```java
public class Example {
  public static void main(String[] args){
    Greeting.sayHello();
  }
}
```

A `static` method cannot be overridden or changed in the implementing class

A `static` method cannot be shadowed, neither as part of the interface, or part of the implementing class

[Code Sample](/examples/java_interfaces/src/interface_examples/StaticMethodInterfaceExample.java)

#### `private` methods
`private` methods should improve code reusability inside interfaces and encapsulation. You can use `private` methods
 to share code among default methods without exposing it to classes implementing the interface
 ```java
public interface Greeting {
  default void greet(){
    System.out.print(getGreeting());
  }
  
  private String getGreeting(){
    return "Hello";
  }
}
```
Rules for `private` methods in interfaces:
- The `private` modifier must be used to define them 
- The `private` and `abstract` modifiers cannot be used together
- The `private` and `default` modifiers cannot be used together. `default` methods are always public
- The `private` methods must contain an implementation body

[Code Sample](/examples/java_interfaces/src/interface_examples/PrivateMethodInterfaceExample.java)

#### `private static` methods
`private static` methods allow you to extract common code into a `private static` method but not into an instance 
method that would require you to create a instance of the type to use

A `private static` method can be called from instance (i.e `default` or `private` non-static) methods or `static` 
method inside the interface

A `private` non-static method is not allowed to be called from `static` or `private static` methods within the interface
```java
public interface Greeting {
  static void sayHello(){
    System.out.println(getGreeting());
  }
  
  private static String getGreeting(){
    return "Hello";
  } 
} 
```
[Code Sample](/examples/java_interfaces/src/interface_examples/PrivateStaticMethodInterfaceExample.java)

| [Previous](README.md) | [Next](define_and_write_functional_interfaces.md) |
| :--------- | ----------: | 
