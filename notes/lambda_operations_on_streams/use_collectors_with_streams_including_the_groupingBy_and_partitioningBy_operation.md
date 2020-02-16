### Use Collectors with streams, including the groupingBy and partitioningBy operation

#### `Stream.collect(...)`
`Stream.collect()` is one of the Java 8's Stream API‘s terminal methods. It allows you to collect the results of a 
series of operations on a stream into some type of data structure.

The Stream.collect(...) takes 3 arguments:
1. A supplier to make a new instance of the target object, e.g a constructor for a list
2. An accumulator that adds an element to the target. e.g an add method
3. An combiner that merges two objects into one, such as addAll

There is a convenient `Collector` interface for these three functions and a `Collectors` class with factory methods for 
common collectors e.g `Collectors.toList()`
```java
List<String> result = stream.collect(Collectors.toList());
```
```java
Set<String> result = stream.collect(Collectors.toSet());
```

#### `Collectors.averagingDouble(ToDoubleFunction<? super T> mapper)`
Calculates that average stream elements as `double` data type. It returns the `Collector` interface
```java
List<String> list = Arrays.asList("A", "AA", "A", "AAA");
double result = 
  list.stream()
      .collect(Collectors.averagingDouble(s -> s.length()));
System.out.println(result);
```

#### `Collectors.groupingBy(Function<? super T, ? extends K> classifier)`
Groups elements according to the `Function` provided and returns the results in a `map`
```java
List<String> list = Arrays.asList("A", "AA", "A", "AAA");
Map<Integer, List<String>> result = 
    list.stream().collect(Collectors.groupingBy(String::length));
System.out.println(result);
```

#### `Collectors.joining`
This concatenates all elements in a stream into a single string bu invoking the `toString()` method on each object in 
the stream
```java
Stream<String> names = Stream.of("James", "John", "Joe");
String concat = names.collect(Collectors.joining());
System.out.println(concat);
// JamesJohnJoe
```
```java
Stream<String> names = Stream.of("James", "John", "Joe");
String concat = names.collect(Collectors.joining(", "));
System.out.println(concat);
// James, John, Joe
```

#### `Collectors.partiitioningBy(Predicate<? super T> predicate)`
As `partitioningBy(...)` takes a `Predicate` there are only 2 possible groups; true and false
```java
Stream<String> names = Stream.of("John", "Joe", "James");
Map<Boolean, List<String>> map = names.collect( Collectors.partitioningBy(s -> s.length() <= 4));
System.out.println(map);
 //{false=[James], true=[John, Joe]}
```

[Code Samples](/examples/lambda_operations_on_streams/src/collectorsWithStreamExamples.java)

| [Previous](sort_a_collection_using_lambda_expressions.md) | [Next](../java_file_io_nio2) |
| :--------- | ----------: | 