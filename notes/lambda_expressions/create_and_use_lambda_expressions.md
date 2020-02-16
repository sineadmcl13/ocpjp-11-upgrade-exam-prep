### Create and use lambda expressions

#### Refactor the code that uses an anonymous inner class to use a lambda expression
The following lines of code demonstrate a typical anonymous inner class implementation for a button action 
```java
JButton button = ...
JLabel com = ...
button.addActionListener(new ActionListener() {
  @Override
  public void actionPerformed(ActionEvent e){
    comp.setTesxt("Button has been clicked");
  }
})
```
We can replace this with a lambda expressions as shown below
```java
JButton button = ...
JLable comp = ...
button.addActionListener(e -> comp.setText("Button has been clicked"));
```

#### Describe type inference and target typing
In the examples above we have not declared the type of the variable being passed. 
The Java compiler is inferring the type of the variable from its context.

It means that you do not need to explicitly write out the type when it is obvious. 
In some situations where the Java compiler cannot infer types, you MUST explicitly specify values for type 
variables with type witnesses. The example belows the explicit type declaration  
```java
button.addActionListener((ActionEvent e) -> comp.setText("Button has been clicked"));
```


#### Using Built-in Lambda Types
Java 8 have captured the common use cases of lambdas and created a library of functions for them. 
A new package called `java.util.function` was created to host these common functions.

It includes :
   - java.util.function.Predicate
   - java.util.function.Consumer
   - java.util.function.Function
   - java.util.function.Supplier
   - java.util.function.UnaryOperator and primitive and binary variations of the above

- #### Function Interface
  - Parameter type `T`
  - Return type `R`
  - Applies a function to one argument and produces a result
  - Can turn one paramter into a value of a potentially different type and return it
```java
@FunctionalInterface
public class Function<T, R> {
  R apply(T t);
}
```
- #### Consumer Interface
  - Parameter type `T`
  - Return type `void`
  - A function that accepts one parameter but returns nothing
```java
@FunctionalInterface
public class Consumer<T> {
  void accept(T t);
}
```

- #### Supplier Interface
  - Parameter type n/a
  - Return type `R`
  - A function that can get a value without taking any input
```java
@FunctionalInterface
public class Supplier<T> {
  public T get();
}
```

- #### Predicate Interface
  - Parameter type `T`
  - Return type `boolean`
  - Test the parameter and returns a boolean depending on the outcome
  - Often used when filtering or matching
```java
@FunctionalInterface
public class Predicate<T> {
  boolean test(T t);
}
```

- #### BiPredicate Interface
  - Parameter type `T, U`
  - Return type `boolean`
  - Represents a predicate of two arguments. 

```java
@FunctionalInterface
public class BiPredicate<T, U> {
  boolean test(T t, U u);
}
```
  
- #### UnaryOperator Interface
  - Parameter type `T`
  - Return type `T`
  - Applies a function to its parameter to return one of the same type
  - It requires all parameters be of the same type
  - The `java.util.function.UnaryOperator` is a function interface that extends `java.util.function.Function`
```java
@FunctionalInterface
public class UnaryOperator<T> extends Function<T, T>{
  T apply(T t);
}
```

- #### ToDoubleFunction Interface
 - Parameter type `T`
 - Return type `double`
 - Represents a function that produces a double valued result
```java
@FunctionalInterface
public class ToDoubleFunction<T> {
  double applyAsDouble(T t);
}
```

- #### DoubleFunction Interface
 - Parameter type `double`
 - Return type `R`
 - Represents a function that accepts a double argument and produces a result
```java
@FunctionalInterface
public class DoubleFunction<R> {
  R apply(double d);
}
```

| [Previous](README.md) | [Next](use_lambda_expressions_and_method_references.md) |
| :--------- | ----------: | 