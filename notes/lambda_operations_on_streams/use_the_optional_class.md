### Use the Optional class

An `Optional<T>` object is a wrapper for either an object of type `T` or no object. 
In the former case, we say that the value is present. The `Optional<T>` type is intended as a safer alternative for a 
reference of type `T` that either refers to an object or is null. 

#### Creating Optional objects 

- #### Empty Optional 
You can get an empty optional object using the static factory method `Optional.empty()`
```java
Optional<String> str = Optional.empty();
```

- #### Optional from a non-null value
You can also create an optional from a non-null value with the static factory method `Optional.of(...)`
```java
Optional<String> opStr = Optional.of("some string");
```
When using `Optional.of(...)`, the object passed in must not be null or a NPE will be thrown

- #### Optional from nullable value
You can create an `Optional` object that may hold a null by using the static factory method `Optional.ofNullable(...)`
```java
Optional<String> opStr = OPtional.ofNullable(null);
```
In the example above, the resulting `Optional` object would be empty

----

#### Unwrapping an Optional
- `Optional.get()`    
   It returns the wrapped value if present but throws a `NoSuchElementException` otherwise

- `Optional.orElse(T other)`
   Allows you to provide a default value for when the optional does not contain a value

- `Optional.orElseGet(Supplier<? extends T> other)`
   The `Supplier` is invoked only if the optional contains no value.

- `Optional.orElseThrow(Supplier<? extends X> exceptionSupplier)`
   Similar to `get()` in that it throws an exception when empty, but in this case you can choose the type of exception

- `Optional.ifPresent(Consumer<? super T> consumer)`
   Lets you execute the action given as an argument if a value if present; otherwise no action is taken

- `Optional.isPresent()`
   Returns true is the `Optional` contains a value, `false` otherwise

- `Optional.isEmpty()`
   Returns true if the `Optional` id empty, otherwise it returns false
   
#### Converting an `Optional` into a `Stream`
You can convert an `Optional` into a stream using the `Optional.stream()` method. If the `Optional` contains a value, 
it will return a `Stream` containing only that value, otherwise it will return an empty stream

It can be helpful to remove empty optionals and keep only the ones with values. In Java 9 you can use the `flatMap()` 
to remove empty optionals
```java
List<String> list - stream.flatMap(Optional::stream).collect(Collectors.toList());
```
In the example above where the variable `stream` is a stream of optionals, the flatMap calls `Optional.stream()` 
on each optional. As described above, this will either return an empty stream or a stream containing only the value 
of the optional before finally flattening the stream of streams to produce a stream which contains only optionals 
with a value

[Code Samples](/examples/lambda_operations_on_streams/src/optionalExamples.java)
