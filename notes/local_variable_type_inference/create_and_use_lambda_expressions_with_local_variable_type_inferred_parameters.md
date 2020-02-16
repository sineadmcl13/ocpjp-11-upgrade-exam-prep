### Create and use lambda expressions with local-variable type inferred parameters 

From Java 11 you can use the var reserved type name as lambda expression parameter type: 
```java
UnaryOperator<String> lc = (var s) -> s.toLowerCase();
```

The type of the parameter declared with the `var` above will ve inferred to the type `String` because the type 
declaration of the variable has its generic type set to `String` which means the parameter type and return type of 
UnaryOperator is `String`

#### Legal lambda expression type inference usage

- Enables you to add annotations to lambda expressions
```java
UnaryOperator<String> lc = (@NonNull var s) -> s.toLowerCase();
```

#### Illegal lambda expression type inference usage

- Not allowed to use var for some parameter and skip for others:
```java
BiFunction<String, String, String> lc = (var a, b) -> a + b;
```

- Not allowed to mix `var` with explicit type:
```java
BiFunction<String, String, String> lc = (var a, String b) -> a + b;
```

- Not allowed to skip parentheses in single parameter lambda when using `var`
```java
UnaryOperator<String> unOp = var s -> s.toLowerCase();
```

[Code Samples for Local Variable Usage and Lambdas](/examples/local_variable_type_inference/src/LambdaExpressionsWithVarExamples.java)

| [Previous](use_local_variable_type_inference.md) | [Next](../lambda_expressions) |
| :--------- | ----------: | 