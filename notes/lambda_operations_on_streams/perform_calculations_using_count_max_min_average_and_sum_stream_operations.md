### Perform calculations using count, max, min, average and sum stream operations

#### `count()`
Determines the number of elements in a finite stream
```java
long count()
```
```java
Stream<string> names = Stream.of("Jake", "James", "John");
System.out.println(names.count());
```

#### `min()`
Allows you to pass a custom comparator and find the smallest value of a finite stream according to that sort order
```java
Optional<T> min(<? super T> comparator)
```
```java
Stream<String> s = Stream.of("John", "James", "Joe");
Optional<String> min = s.min((s1, s2) -> s1.length() - s2.length());
min.ifPresent(System.out::println);
```

#### `max()`
The same as `min()` except it allows you to find the largest value according to the sort order of the comparator you 
provide

```java
Optional<T> max(? super T> comparator);
``` 
```java
Stream<String> s = Stream.of("John", "James", "Joe");
Optional<String> max = s.max((s1, s2) -> s1.length() - s2.length());
max.ifPresent(System.out::println);
```

#### `average()`
The stream library has specialized types IntStream, LongStream and DoubleStream that store primitive values directly 
without using wrappers.
The `average` method was defined for these specialized streams and not for `Stream`
```java
IntStream stream = IntStream.of(2, 4, 6, 1, 34, 5, 9);
double average = stream.average().getAsDouble();
```

#### `sum()`
Similar to `average()`, the `sum()` method was also defined for these specialized stream types. 
```java
IntStream stream = IntStream.of(2, 4, 6, 1, 34, 5, 9);
int sum = stream.sum();
```

[Code Samples](/examples/lambda_operations_on_streams/src/calculationExamples.java)

| [Previous](use_the_optional_class.md) | [Next](sort_a_collection_using_lambda_expressions.md) |
| :--------- | ----------: | 