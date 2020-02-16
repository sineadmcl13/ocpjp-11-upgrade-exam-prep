### Sort a collection using lambda expressions

#### `sorted()`
Returns a stream with the elements sorted. Java uses natural ordering unless we specify a comparator
```java
Stream<T> sorted()
Stream<T> sorted(Comparator<? superT> comparator)
```

```java
Stream<String> names = Stream.of("Bill", "Makie", "Andy");
names.sorted().forEach(System.out::println);
names.sorted(Comparator.reverseOrder()).forEach(System.out::println);    
```

#### `comparing()`
The `comparing(...)` method has been added to the `Comparator` interface. It can be used to provide custom sorting logic
```java
Stream<String> names = Stream.of("Aaron", "Conor", "Bill");
    
Comparator<String> c1 = Comparator.comparing(n -> n.length());
names.sorted(c1).forEach(System.out::println);
```

#### `Comparator.thenComparing(...)`
This is a default method of `Comparator` interface introduced in Java 8. Allows you do a sorting by composite condition
```java
Stream<String> names = Stream.of("Aaron", "Andy", "Barney", "Bill");
    
Comparator<String> c1 = Comparator.comparing(n -> n.length());
Comparator<String> c2 = (n1, n2) -> n1.compareTo(n2);
    
names.sorted(c1.thenComparing(c2))
     .forEach(System.out::println);
```

#### Sorting a `List`
The `java.util.Collections.sort(...)` method sorts the specified `List` into ascending order, according to the natural 
ordering of its elements. All elements in the list must implement the `Comparable` interface. Furthermore they should 
be mutually comparable

```java
List<String> emps = new ArrayList<>();
emps.add("Paul"); emps.add("Mike"); emps.add("Steve");
Collections.sort(emps);
System.out.print(emps);
```
```java
[Mike, Paul, Steve]
```
> If you initialize a list in the following way it will fail at runtime, as `List.of(...)` creates an immutable list
> and sorting modifies exactly the same list object
> ```java
> List<String> emps = List.of("Nathaniel", "Steve","Nick");
> ``` 

If the objects in the list do not implement `Comparable`, you should provide your own `Comparator`

[Code Samples](/examples/lambda_operations_on_streams/src/sortingCollectionsExamples.java)

| [Previous](perform_calculations_using_count_max_min_average_and_sum_stream_operations.md) | [Next](use_collectors_with_streams_including_the_groupingBy_and_partitioningBy_operation.md) |
| :--------- | ----------: | 