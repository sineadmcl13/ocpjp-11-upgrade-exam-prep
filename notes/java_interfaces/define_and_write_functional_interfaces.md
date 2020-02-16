### Define and write functional interfaces 

#### Functional Interfaces
Each functional interface has a __single abstract method__ called the functional method for that functional interface.
You can supply a lambda expression whenever an object of an interface with a single abstract method is expected. 

```java
public interface Predicate<T> {
  boolean test(T t);
}
```

#### `@FunctionalInterface` annotation
The `@FunctionalInterface` annotation was introduced to communicate that an interface was intended as a functional interface
Its use is optional. It only serves as a hint to the compiler

[Code Sample](/examples/java_interfaces/src/functional_interface_examples/FunctionalInterfaceExample.java)

#### Default methods in interfaces
As functional interfaces require a __single abstract method__, the following code will not compile
```java
@FunctionalInterface
public interface IFoo {
  default void actionFoo(){
    //some action code here
  }
}
```
but this code will compile
```java
@FunctionalInterface
public interface IFoo {
  default void actionFoo(){
    //some action code here
  }
  boolean isFooAllowed(); //single abstract method
}
```

[Code Sample](/examples/java_interfaces/src/functional_interface_examples/DefaultMethodFunctionalInterfaceExample.java)

#### Static methods in interfaces
The same applies the `static` methods as was outlined in the default methods section. The following code will not compile
```java
@FunctionalInterface
public interface IFoo {
  static void actionFoo(){
    //some action code here
  }
}
```
but this code will compile
```java
@FunctionalInterface
public interface IFoo {
  static void actionFoo(){
    //some action code here
  }
  boolean isFooAllowed(); //single abstract method
}
```
[Code Sample](/examples/java_interfaces/src/functional_interface_examples/StaticMethodFunctionalInterfaceExample.java)

#### Public methods of java.lang.Object in functional interfaces
If an interface declares an abstract method overriding one of the public methods of java.lang.Object, it __doe not__ 
count toward the interface's abstract method count. This is because any implementation of the interface will have
an implementation from java.lang.Object or elsewhere

```java
@FunctionalInterface
public interface IFoo {
  static void actionFoo(){
    //some action code here
  }
  boolean isFooAllowed(); //single abstract method
  
  boolean equals(Object var1); // ignored as its a public method from java.lang.Object
}
```
[Code Sample](/examples/java_interfaces/src/functional_interface_examples/FunctionInterfaceWithJavaLangObjectMethods.java)

| [Previous](create_and_use_methods_in_interfaces.md) | [Next](../lambda_operations_on_streams) |
| :--------- | ----------: | 