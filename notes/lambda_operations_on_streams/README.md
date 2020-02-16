### Lambda Operations on Streams

#### Quick review of streams 
A stream is a sequence of data. A stream pipeline is the operation that runs on a stream to produce a result

Stream does not store data, it operates on the source data structure (Collection or array) and produces pipelined data 
that we can use to perform specific operations. For example, we can create a Stream from a `java.util.List` and filter 
it based on a condition as shown below.

```java
List<String> names = Arrays.asList("Mike", "John", "Dave", "Peter");  
names.stream()
  .filter(n -> n.length() == 4)
  .map(String::toUpperCase)
  .forEach(n -> System.out.println(n));
```

Stream API operations that returns a new `java.util.stream.Stream` are called __intermediate operations__.

Most of the times, these operations are lazy in nature, computation on the source data is only performed when the 
terminal operation is initiated, and source elements are consumed only as needed.

#### Intermediate Operations

Intermediate operations are never the final result producing operations. 
Commonly used intermediate operations are filter and map.

- Stream.filter
```java
stream.filter(s -> s.equals("Hello World"));
```

- Stream.map
```java
    stream.map(s -> s.toUpperCase());
```

#### Terminal Operations
Stream API operations that returns a result or produce a side effect. 
Once the terminal method is called on a stream, it consumes the stream and after that we can not use it

- Stream.collect
```java
List<String> names = Arrays.asList("John", "Mike", "Mark", "Paul");
    List<String> filtered = names.stream()
        .filter(n -> n.startsWith("M"))
        .collect(Collectors.toList());
    
    filtered.forEach(n -> System.out.println(n));
```

| [Previous](../java_interfaces/define_and_write_functional_interfaces.md) | [Next](extract_stream_data_using_map_peek_and_flatMap_methods.md) |
| :--------- | ----------: | 