### Parallel Streams

Streams can be parallel or sequential. Operations on a sequential stream are processed in serial using one thread. 
Operations on a parallel stream, are processed in parallel using multiple streams. There are no additional steps 
required to process streams in parallel. This handled by the Streams API when you call the appropriate method

To produce a parallel stream you need to call the `parallelStream()` method of the `Collection` interface

```java
default Stream<E> parallelStream() {
}
```

| [Previous](../lambda_expressions/use_primitive_and_binary_variations_of_base_interfaces_of_java_util_function_package.md) | [Next](develop_the_code_that_use_parallel_streams.md) |
| :--------- | ----------: | 

