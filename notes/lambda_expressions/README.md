### Lambda Expressions

#### Syntax of Lambda Expressions 
A lambda expression consists of the following:
- A comma-separated list of formal parameters enclosed in parentheses
```java
p -> p.getAge() >= 18
(Pet p) -> p.getAge() >= 18
(p) -> p.getAge() >= 18
```
- The arrow token ->
- A body, which consists of a single expression or a statement block
```java
p -> p.getAge() >= 18
p -> { p.getAge() >= 18 }
p -> { return p.getAge() }
```

A return statement is NOT an expression; in a lambda expression, you MUST enclose statment braces ({...}).
However you do not have to enclose a void method invocation in braces. For example, the following is a valid lambda 
expression
```java
name -> System.out.println(name)
``` 

| [Previous](../local_variable_type_inference/create_and_use_lambda_expressions_with_local_variable_type_inferred_parameters.md) | [Next](create_and_use_lambda_expressions.md) |
| :--------- | ----------: | 