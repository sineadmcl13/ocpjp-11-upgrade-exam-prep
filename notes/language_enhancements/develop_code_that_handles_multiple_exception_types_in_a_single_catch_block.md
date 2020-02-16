### Develop code that handles multiple Exception types in a single catch block

From Java 7, a single catch block can handle more than one type of exception. This feature reduces code duplication 
and can lessen the temptation to catch and overly broad exception type

THe following code show catching multiple exceptions types prior to Java 7
```java
try {
  // exception thrown 
} catch (IOException ex){
  logger.log(ex);
} catch (SQLException ex){
  logger.log(ex);
}
```

From Java 7 you can combine catch blocks by specifying each exception type separated by a vertical bar `|`
```java
try {
  //exception thrown 
} catch (IOException | SQLException ex){
  logger.log(ex);
}
```

However you cannot combine exceptions that are a subtype or supertype of on of the catch clauses exception parameters
e.g
```java
try {
  //exception thrown
} catch (IOEXception | Exception ex){ //COMPILATION FAILURE
}
```
In the example above `IOEXception` is a subclass of `Exception` so both cannoth be listed in the catch clause 
parameter list

If a catch clause lists more than one exception type, as shown in the example above, the catch parameter is implicitly 
final. So from the example above `ex` is final can therefore you cannot assign any values to it within the catch block

| [Previous](use_try_with_resources_construct.md) | [Next](../bibliography.md) |
| :--------- | ----------: | 