### Extract stream data using map, peek and flatMap methods

#### Stream.peek(...)

The Stream.peek(...) returns Stream itself after applying the action passed as `Consumer` object. Therefore it is a 
intermediate stream operation.

```java
Stream<T> peek(Consumer<? super T> action)
```

The `Stream.peek(...)` is extremely useful during debugging as it allows you to peek into a stream before an action 
is encountered
```java
Stream<String> names = Stream.of("John", "Mike", "Dean", "Paul");
    List<String> list = names
        .peek(n -> System.out.println(n))
        .map(n -> n.toUpperCase())
        .collect(Collectors.toList());
    
    list.forEach(n -> System.out.println(n));
```
[Code Sample](/examples/lambda_operations_on_streams/src/streamPeekExample.java)

#### Stream.map(...)
Streams support the method map() which take a Function as an argument and returns a Stream. As such it is also an 
intermediate stream operation
```java
<R> Stream<R> map(Function<? super T, ? extends R> mapper);
```
```java
Stream<String> stream = Stream.of("Mark", "Luke", "Paul", "Dave");
Stream<String> upperCase = stream.map(s -> s.toUpperCase());
upperCase.forEach(s -> System.out.println(s));   
```

`map()` can also be chained 
```java
Stream<String> stream = Stream.of("Mark", "Luke", "Paul", "Dave");
    Stream<String> upperCase = stream
            .map(s -> s.substring(0,1))
            .map(s -> s.toLowerCase());
    upperCase.forEach(s -> System.out.println(s));
```

[Code Sample](/examples/lambda_operations_on_streams/src/streamMapExample.java)

#### Stream.flatMap(...)

The Stream.flatMap(...) method returns a stream consisting of the results of replacing each element of this stream  
with the contents of a mapped stream produced by applying the provided mapping function to each element.
The function produces a stream for each input element and the output streams are flattened. Performs one-to-many mapping

The Stream.flatMap(...) operation works as follows:
- It takes an input stream and produces and output stream using a mapping function
- The mapping function takes an element from the input stream and maps the element to a stream. The type of input 
  element and the elements in the mapped stream may be different. This step produces a streams of streams. 
  Suppose the input stream is a `Stream<T>` and the mapped stream is `Stream<Stream<R>>` where `T` and `R` may be 
  different or the same
- Finally it flattens the output stream to produce a stream. That is `Stream<Stream<R>>`is flattened to `Stream<R>`

```java
<R> Stream<R> flatMap(Function<? super T,? extends Stream<? extends R>> mapper)
```
```java
List<String> names1 = Arrays.asList("Peter", "John");
List<String> names2 = Arrays.asList("David", "Mike");
Stream<List<String>> s = Stream.of(names1, names2);
s.flatMap(names -> names.stream()).forEach(System.out::println);
```
[Code Sample](/examples/lambda_operations_on_streams/src/streamFlatMapExample.java)

The `flatMap(...)` transforsm wach element of a stream into another form (just like `map(...)`) and generates 
sub-streams of the newly formed elements. Finally its flattens all of the sub-streams into a single stream of elements.
As the `flatMap(...)` is a map type of function, it also takes a function and applies that function to each element in 
the stream

The difference between `map(...)` and `flatMap(...)` is:
- The `map(...)` accepts a function that returns a mapped element and the the `map(...)` function returns a stream of 
  such elements (1 to 1).
- The `flatMAp(...)` accepts a function that returns streams of the mapped elements and then the `flatMAp(...)` finally 
  retuns a collective stream of all of the sub-streams that are created by each execution of the passed function 
  (1 to 0...n).
  