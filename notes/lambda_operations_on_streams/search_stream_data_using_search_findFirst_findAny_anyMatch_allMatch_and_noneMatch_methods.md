### Search stream data using search findFirst, findAny, anyMatch, allMatch and noneMatch methods

#### Java stream order of processing
Streams may or may not have a defined encounter order. Whether a stream has an encounter order depends on the source 
and the intermediate operations. 
Certain stream sources (such as `java.util.List`) are intrinsically ordered whereas others (such as `java.util
.HashSet`) are not. 
Some intermediate operations such as `sorted`, may impose an encounter order on an otherwise unordered stream and 
others may render an unordered stream ordered such as `BaseStream.unordered()`

For sequential streams, the presence or absence of an encounter order does not affect performance, only determinism.
For parallel streams, relaxing the ordering constraint can sometimes enable more efficient execution

#### `findFirst()`
Returns the first element of the stream unless the stream is empty. If the stream is empty, it returns an empty `Optional`
```java
Option<T> findFirst();
```
```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
Optional<Integer> results = numbers
  .stream()
  .filter(i -> i% 3 == 0)
  .findFirst();
System.out.println(results.get());
```

[Code Sample](/examples/lambda_operations_on_streams/src/streamFindFirstExample.java)

#### `findAny()`
Returns an arbitrary element of the stream unless the stream is empty. If the stream is empty, it returns an empty `Optional`
```java
Optional<T> findAny();
```
```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
Optional<Integer> results = numbers
  .stream()
  .filter(i -> i% 3 == 0)
  .findAny();
System.out.println(results.get());
```
The behavior of findAny() operation is explicitly non deterministic; it is free to select any element in the stream. 
This is to allow for maximal performance in parallel operations

[Code Sample](/examples/lambda_operations_on_streams/src/streamFindAnyExample.java)

#### `anyMatch()`
The `anyMatch()` method searches a stream and returns information about how the stream pertains to the predicate.
```java
boolean anyMatch(Preciate<? super T> predicate);
```
```java
Stream<String> names = Stream.of("Mike", "Mark", "Peter", "Dave");
boolean nameWith5Chars = names.anyMatch(n -> n.length() == 5);
System.out.println(nameWith5Chars);
```

[Code Sample](/examples/lambda_operations_on_streams/src/streamAnyMatchExample.java)

#### `allMatch()`
Works in the same way as `anyMatch()` but will check if all the elements in the stream match the given Predicate
```java
boolean allMatch(Predicate<? super T> predicate);
```
```java
Stream<String> names = Stream.of("Mike", "Mark", "Peter", "Dave");
boolean allWith4Chars = names.allMatch(n -> n.length() == 4);
System.out.println(allWith4Chars);
```

[Code Sample](/examples/lambda_operations_on_streams/src/streamAllMatchExample.java)

#### `noneMatch()`
Works in the same way as `allMatch()` but ensures that none of the elements in the stream match the Predicate
```java
boolean noneMatch(Predicate<? super T> predicate);
```
```java
Stream<String> names = Stream.of("Mike", "Mark", "Peter", "Dave");
boolean none6CharsLong = names.noneMatch(n -> n.length() == 6);
System.out.println(none6CharsLong);
```

[Code Sample](/examples/lambda_operations_on_streams/src/streamNoneMatchExample.java)

>All findXxx() methods have no arguments and return Optional
>
>All xxxMatch() methods accept a Predicate and return a boolean primitive

In relation to streams, operations `anyMatch(...)`, `allMatch(...)`, `noneMatch(...)`, `findFirst()`, and `findAny()` 
do not need to process the whole stream to produce a result. 
As soon as an element is found, a result can be produced. These are short-circuiting terminal operations.