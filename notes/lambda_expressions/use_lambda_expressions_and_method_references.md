### Use lambda expressions and method references

#### Method References
Method references can be seen as shorthand for lambdas calling only a specific method

When you need a method reference, the target reference is placed before the delimiter `::` and the name of the method 
is provided after it. For example, `String::toUpperCase` is a method reference to the method `toUpperCase` 
defined in the `String` class. 
The method reference is shorthand for the lambda expression `(String s) -> s.toUpperCase();`.

There are 4 types of method reference:

- #### Reference to a static method
    A non-constructor method reference consists of a qualifier, followed by the `::` delimiter, followed by an 
    identifier. The qualifier is a type for static methods:
```java
Class::staticMethodName
```
e.g
```java
IntFunction<String> f1 = String::valueOf;
System.out.println(f1.apply(100));
```

- #### Reference to a constructor
    A constructor reference consists of a qualifier, followed by the `::` delimiter, followed by the keyword `new`. 
    The qualifier type must support the creation of instances. When a class declares multiple constructors, 
    the compiler will check the type of the functional interface with all of the constructors and choose the best match. 
```java
ClassName::new
```
e.g
```java
Function<char[], String> f1 = (arr) -> String::new;
System.out.println(f1.apply(new char[]{'H', 'e', 'l', 'l', 'o'}));
```
  
- #### Reference to an instance method of an arbitrary object of a particular type
    Reference to an instance method of an arbitrary object of a particular type refers to a non-static method that is 
    not bound to a receiver. For example `String::trim` is a non-static method reference that identifies a non-static 
    `trim()` method of the `String` class
```java
BiFunction<String, String> b1 =(s1, s2) -> String::equalsIgnoreCase;
System.out.println(b1.apply ("HEllO", "hELlO"));
```

- #### Reference to an instance method of a particular object
    Reference to an instance method of a particular object refers to a non-static method that is bound to a receiver. 
    This kind or method reference refers to a situation when you are calling a method in a lambda to an external 
    object that already exists
```java
Function 
Integer i = 110;
Supplier<String> s1 = i::toString;
```

| [Previous](create_and_use_lambda_expressions.md) | [Next](use_built-in_functional_interfaces_including_predicate_consumer_function_and_supplier.md) |
| :--------- | ----------: | 