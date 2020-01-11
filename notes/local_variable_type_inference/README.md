### Local Variable Type Inference

Java 10 introduced a new language feature called local variable type inference (LVTI)
Type inference refers to the automatic detection of the datatype of a variable, done at compile time. 

Until Java 9, we had to declare the type of the local variable explicitly and ensure it was compatible 
with the initializer used to initialize it:
```java
String message = "Clearly a string here";
```

In Java 10, this is how we could declare a local variable:
```java
@Test
public void whenVarInitWithString_thenGetStringTypeVar() {
    var message = "Hello, Java 10";
    assertTrue(message instanceof String);
}
```

LVTI allows the developer to skip the type declaration associated with local variables (those defined inside method 
definitions, initialization blocks, for-loops, and other blocks like if-else), and the type is inferred by the JDK. 
It will, then, be the job of the compiler to figure out the datatype of the variable.

In Java 11 the local variable type inference was extended for lambda parameters

> Despite the introduction of var, Java is still a statically typed language, and there should be enough 
> information to infer the type of local variable. If not, the compiler will throw an error. 

The `var` __IS NOT__ a keyword. Instead, it is a reserved type name. This means that existing code that uses var as a 
variable, method, or package name __WILL NOT__ be affected. 
Existing code that uses `var` as a class or interface name __WILL__ be affected. 