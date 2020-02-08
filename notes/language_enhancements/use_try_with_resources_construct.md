### Use try-with-resources construct

The `try-with-resource` statement is a `try` statement that declares one or more objects that implement the 
`java.lang.AutoClosable` interface

```java
package java.lang;

public interface AutoClosable {
  void close() throws Exception;
}
```

The `java.io.Closable` interface extends the `java.lang.AutoClosable` interface but overrides the `close()` method to 
declare it throws the more specialised `IOException`. This shows that subclasses of `AutoClosable` can override the 
`close()` method to throw specialised exceptions or no exception at all

```java
package java.io;

import java.io.IOException;

public interface Closeable extends AutoCloseable {
  void close() throws IOException;
}
```

Using `BufferedReader` and `BufferedWriter` as an examples as they implement `AutoClosable` we can write the following 
try-with-resources statement
```java
try(BufferedReader in = new BufferedReader(new FileReader(src));
    BufferedWriter out = new BufferedWriter(new FileWriter(dest))) {
  
  //read from in and write to out
}
```

You can declare one or more resources in a try-with-resources statement, separated by a semi-solon, which are all 
automatically closed when the statement completes. Its important to note the `close()` methods of the resources are 
called in the __opposite__ order of their creation

The catch and finally blocks are also optional. You can still include them but any `catch` or `finally` block is run 
__after the resources have been closed__

#### Suppressed Exceptions

If both the (explicit) `try` block and the (implicit) resource handling code throw an exception, then the `try` block 
exception is the one which will be thrown. The resource handling exception will be made available via the 
`Throwable.getSuppressed()` method of the thrown exception.

[Suppressed Exception Example Code](/examples/language_enchancements/src/SuppressedExceptionExample.java)

#### Improved try-with-resources statement

In Java 7 and 8 the `AutoClosable` resources must be declared and initialized inside the try block of the 
try-with-resources statement:

```java
try (BufferedReader br = new BufferedREader(new FileReader(file));) {
  String s = br.readLine();
  System.out.println();
}
```
In Java 9 you are not required to declare a new local variable and initialise it inside the try block. If you have 
already declared and opened outside the try-with-resources statement, then you can write the variable name pointing to 
resource inside the try block and it will be eligible for automatic resource management
```java
BufferedReader br = new BufferedREader(new FileReader(file));
try (br) {
  String s = br.readLine();
  System.out.println();
}
``` 
The restriction is that the local variable you refer to in the try block must be effectively final or explicitly 
declared with the final keyword

In Java 10 you can use the `var` reserved keyword for resource variable declaration
```java
try (var br = new BufferedReader(new FileReader(file));) {
    String s = br.readLine();
    System.out.println(s);
}					
```
or
```java
var br = new BufferedReader(new FileReader(file));
try (br) {
    String s = br.readLine();
    System.out.println(s);
}
```
