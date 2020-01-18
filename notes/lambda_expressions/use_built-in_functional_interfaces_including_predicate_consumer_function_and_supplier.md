### Use built-in functional interfaces including Predicate, Consumer, Function, and Supplier

#### Develop code that uses the Function interface

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
- #### BiFunction Interface
 ```java
@FunctionalInterface 
public class BiFunction<T, U, R> { 
  R apply(T t, U u);
}   
```

- #### Primitive Function Functional Interfaces

| Functional Interface | Parameters | Return Type |	Single Abstract Method |
|----------------------|------------|-------------|------------------------|
| DoubleFunction<R>    | 1 double   | R 	      | apply                  |
| IntFunction<R>       | 1 int      | R           | apply                  |
| LongFunction<R> 	   | 1 long 	| R      	  | apply                  |

[Code Sample](/examples/lambda_expressions/src/FunctionInterfaceExamples.java)

#### Develop code that uses the Consumer interface
  - Parameter type `T`
  - Return type `void`
  - A function that accepts one parameter but returns nothing
```java
@FunctionalInterface
public class Consumer<T> {
  void accept(T t);
}
```

- #### BiConsumer Interface 
```java
@FunctionalInterface
public class BiConsumer<T, U> { 
 void accept(T t, U u);
}   
```
- #### Primitive Consumer Functional Interfaces

| Functional Interface | Parameters | Return Type |	Single Abstract Method |
|----------------------|------------|-------------|------------------------|
| DoubleConsumer       | 1 double   | n/a 	      | accept                 |
| IntConsumer          | 1 int      | n/a         | accept                 |
| LongConsumer  	   | 1 long 	| n/a      	  | accept                 |
      
[Code Sample](/examples/lambda_expressions/src/ConsumerInterfaceExamples.java)

#### Develop code that uses the Supplier interface
  - Parameter type n/a
  - Return type `R`
  - A function that can get a value without taking any input
```java
@FunctionalInterface
public class Supplier<T> {
  public T get();
}
```

- #### Primitive Supplier Functional Interfaces
| Functional Interface | Parameters | Return Type |	Single Abstract Method |
|----------------------|------------|-------------|------------------------|
| DoubleSupplier       | n/a        | double 	  | getAsDouble            |
| IntSupplier          | n/a        | int         | getAsInt               |
| LongSupplier 	       | n/a 	    | long     	  | getASLong              |

[Code Sample](/examples/lambda_expressions/src/SupplierInterfaceExamples.java)

#### Develop code that uses the UnaryOperator interface
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

| Functional Interface | Parameters | Return Type |	Single Abstract Method |
|----------------------|------------|-------------|------------------------|
| DoubleUnaryOperator  | 1 double   | double 	  | applyAsDouble          |
| DoubleUnaryOperator  | 1 int      | int         | applyAsInt             |
| LongUnaryOperator    | 1 long     | long     	  | applyAsLong            |

[Code Sample](/examples/lambda_expressions/src/UnaryOperatorInterfaceExamples.java)

#### Develop code that uses the Predicate interface
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
| Functional Interface | Parameters | Return Type |	Single Abstract Method |
|----------------------|------------|-------------|------------------------|
| DoublePredicate      | 1 double   | boolean 	  | test                   |
| IntPredicate         | 1 int      | boolean     | test                   |
| LongPredicate        | 1 long     | boolean     | test                   |

[Code Sample](/examples/lambda_expressions/src/PredicateInterfaceExamples.java)
